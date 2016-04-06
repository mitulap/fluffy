/**
 * Copyright 2016 Gash.
 *
 * This file and intellectual content is protected under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package gash.router.server;

import java.io.File;
import java.io.FileOutputStream;

import gash.router.server.edges.EdgeMonitor;
import gash.router.server.queue.ChannelQueue;
import gash.router.server.queue.InboundCommandQueue;
import gash.router.server.queue.InboundWorkerQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gash.router.container.RoutingConf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import pipe.common.Common;
import pipe.common.Common.Failure;
import pipe.election.Election;
import pipe.work.Work;
import routing.Pipe.CommandMessage;

/**
 * The message handler processes json messages that are delimited by a 'newline'
 * 
 * TODO replace println with logging!
 * 
 * @author gash
 * 
 */
public class CommandHandler extends SimpleChannelInboundHandler<CommandMessage> {
	protected static Logger logger = LoggerFactory.getLogger("cmd");
	protected RoutingConf conf;
	private ServerState state;

	private InboundCommandQueue queue;

	public CommandHandler(RoutingConf conf) {
		if (conf != null) {
			this.conf = conf;

			state = new ServerState();
			state.setConf(conf);
		}
	}

	/**
	 * override this method to provide processing behavior. This implementation
	 * mimics the routing we see in annotating classes to support a RESTful-like
	 * behavior (e.g., jax-rs).
	 * 
	 * @param msg
	 */
	public void handleMessage(CommandMessage msg, Channel channel) {
		if (msg == null) {
			// TODO add logging
			System.out.println("ERROR: Unexpected content - " + msg);
			return;
		}

		PrintUtil.printCommand(msg);

		try {
			// TODO How can you implement this without if-else statements?
			if (msg.hasPing()) {
				logger.info("ping from " + msg.getHeader().getNodeId());
			} else if (msg.hasMessage()) {
				logger.info(msg.getMessage());
			} else if (msg.hasRetrieve()) {

                boolean hasSavedData = false;

                if(hasSavedData)
                {
                    //is saved in local database
                }
                else
                {
                    Work.WorkState.Builder sb = Work.WorkState.newBuilder();
                    sb.setEnqueued(-1);
                    sb.setProcessed(-1);

                    pipe.election.Election.LeaderStatus.Builder leaderStatusBuilder = pipe.election.Election.LeaderStatus.newBuilder();
                    leaderStatusBuilder.setAction(pipe.election.Election.LeaderStatus.LeaderQuery.WHOISTHELEADER);

                    Common.Header.Builder hb = Common.Header.newBuilder();
                    hb.setNodeId(conf.getNodeId());
                    hb.setDestination(-1);
                    hb.setTime(System.currentTimeMillis());

                    Work.WorkMessage.Builder wb = Work.WorkMessage.newBuilder();
                    wb.setHeader(hb);
                    wb.setLeader(leaderStatusBuilder);

                    wb.setSecret(1000l);

                    EdgeMonitor.broadcastMessage(wb.build());
                }
            }
            else if (msg.hasData()) {

				if(ElectionHandler.getInstance().getLeaderNodeId() == ElectionHandler.conf.getNodeId())
				{
					// you are the leader save it and send it to all nodes
				}
				else
				{
					Work.Task.Builder taskBuilder = Work.Task.newBuilder();
					taskBuilder.setTaskType(Work.Task.TaskType.SAVEDATATOLEADER);
					taskBuilder.setFilename(msg.getData().getFilename());
					taskBuilder.setData(msg.getData().getData());

					Common.Header.Builder hb = Common.Header.newBuilder();
					hb.setNodeId(conf.getNodeId());
					hb.setDestination(-1);
					hb.setTime(System.currentTimeMillis());

					Work.WorkMessage.Builder wb = Work.WorkMessage.newBuilder();
					wb.setHeader(hb);
					wb.setTask(taskBuilder);

					wb.setSecret(1000l);

					EdgeMonitor.sendMessage(ElectionHandler.getInstance().getLeaderNodeId(), wb.build());
				}
//                    if (msg.getData().hasFilename()) {
//                        File file = new File(msg.getData().getFilename());
//                        if (msg.hasData()) {
//                            FileOutputStream fos = new FileOutputStream(file);
//                            byte[] filedata = msg.getData().getData().toByteArray();
//                            fos.write(filedata, 0, filedata.length);
//                            fos.close();
//                        }
//                    }
			}

		} catch (Exception e) {
			// TODO add logging
			Failure.Builder eb = Failure.newBuilder();
			eb.setId(conf.getNodeId());
			eb.setRefId(msg.getHeader().getNodeId());
			eb.setMessage(e.getMessage());
			CommandMessage.Builder rb = CommandMessage.newBuilder(msg);
			rb.setErr(eb);
			channel.write(rb.build());
		}

		System.out.flush();
	}

	/**
	 * a message was received from the server. Here we dispatch the message to
	 * the client's thread pool to minimize the time it takes to process other
	 * messages.
	 * 
	 * @param ctx
	 *            The channel the message was received from
	 * @param msg
	 *            The message
	 */
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, CommandMessage msg) throws Exception {
//		handleMessage(msg, ctx.channel());
		getQueueInstance(ctx, state).enqueueRequest(msg, ctx.channel());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("Unexpected exception from downstream.", cause);
		ctx.close();
	}

	private ChannelQueue getQueueInstance(ChannelHandlerContext ctx, ServerState state)
	{
		if (queue != null)
			return queue;
		else {
//			queue = new WorkerQueue(ctx.channel(), state);
			queue = new InboundCommandQueue(ctx.channel(), state);
			// on close remove from queue
//			channel.closeFuture().addListener(new ConnectionCloseListener(queue));
		}

		return queue;
	}
}
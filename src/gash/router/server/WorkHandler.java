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

//import com.sun.corba.se.spi.activation.Server;

import gash.router.server.edges.EdgeMonitor;

import java.nio.ByteBuffer;

import gash.router.server.queue.ChannelQueue;
import gash.router.server.queue.InboundWorkerQueue;
import gash.router.server.queue.OutboundWorkerQueue;
import gash.router.server.queue.WorkerQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import pipe.common.Common;
import pipe.common.Common.Failure;
import pipe.work.Work;
import pipe.work.Work.Heartbeat;
import pipe.work.Work.Task;
import pipe.work.Work.Task.TaskType;
import pipe.work.Work.WorkMessage;
import pipe.work.Work.WorkState;

/**
 * The message handler processes json messages that are delimited by a 'newline'
 *
 * TODO replace println with logging!
 *
 * @author gash
 *
 */
public class WorkHandler extends SimpleChannelInboundHandler<WorkMessage> {
	protected static Logger logger = LoggerFactory.getLogger("work");
	protected ServerState state;
	protected boolean debug = false;
//	CassandraDAO dao = new CassandraDAO();

	private InboundWorkerQueue queue;

	public WorkHandler(ServerState state) {
		if (state != null) {
			this.state = state;
		}
	}

	/**
	 * override this method to provide processing behavior. T
	 *
	 * @param msg
	 */
	public void handleMessage(WorkMessage msg, Channel channel) {
		if (msg == null) {
			// TODO add logging
			System.out.println("ERROR: Unexpected content - " + msg);
			return;
		}

		if (debug)
			PrintUtil.printWork(msg);

		// TODO How can you implement this without if-else statements?
		try {
			if (msg.hasBeat()) {
				Heartbeat hb = msg.getBeat();
				logger.debug("heartbeat from " + msg.getHeader().getNodeId());

//				if(!EdgeMonitor.activeConnections.containsKey(msg.getHeader().getNodeId()))
//					EdgeMonitor.activeConnections.put(msg.getHeader().getNodeId(), null);

				// check leader state
				ElectionHandler.getInstance().checkCurrentState();

			} else if (msg.hasPing()) {

				logger.info("ping from " + msg.getHeader().getNodeId());
				boolean p = msg.getPing();
				WorkMessage.Builder rb = WorkMessage.newBuilder();
				rb.setPing(true);
				channel.write(rb.build());

			} else if (msg.hasErr()) {

				Failure err = msg.getErr();
				logger.error("failure from " + msg.getHeader().getNodeId());
				// PrintUtil.printFailure(err);

			} else if (msg.hasTask()) {
				// Save file to Cassandra

//				Task t = msg.getTask();
//				if (t.getTaskType() == TaskType.SAVEDATATOLEADER) {
//					ByteString data = t.getData();
//					if(data!= null){
//						byte [] savebytes = t.getData().toByteArray();
//
//						ByteBuffer fileByteBuffer = ByteBuffer.wrap( savebytes);
//						ResultSet insertq = dao.insert(t.getFilename(), fileByteBuffer);
//						if(insertq.wasApplied()){
//							// duplicate to other nodes
//							Work.Task.Builder taskBuilder = Work.Task.newBuilder();
//							taskBuilder.setTaskType(Work.Task.TaskType.SAVEDATATONODE);
//							taskBuilder.setFilename(msg.getTask().getFilename());
//							taskBuilder.setData(msg.getTask().getData());
//
//							Common.Header.Builder hb = Common.Header.newBuilder();
//							hb.setNodeId(state.getConf().getNodeId());
//							hb.setDestination(-1);
//							hb.setTime(System.currentTimeMillis());
//
//							Work.WorkMessage.Builder wb = Work.WorkMessage.newBuilder();
//							wb.setHeader(hb);
//							wb.setTask(taskBuilder);
//
//							wb.setSecret(1000l);
//
//							//EdgeMonitor.sendMessage(ElectionHandler.getInstance().getLeaderNodeId(), wb.build());
//							EdgeMonitor.broadcastMessage(wb.build());
//
//							taskBuilder = Work.Task.newBuilder();
//							taskBuilder.setTaskType(TaskType.DATASAVEDBYEVERYONE);
//
//							hb = Common.Header.newBuilder();
//							hb.setNodeId(state.getConf().getNodeId());
//							hb.setDestination(msg.getHeader().getNodeId());
//							hb.setTime(System.currentTimeMillis());
//
//							wb = Work.WorkMessage.newBuilder();
//							wb.setHeader(hb);
//							wb.setTask(taskBuilder);
//
//							wb.setSecret(1000l);
//
//							EdgeMonitor.sendMessage(msg.getHeader().getNodeId(), wb.build());
//						}
//					}
//				}
//				else if (t.getTaskType() == TaskType.SAVEDATATONODE) {
//
//					ByteString data = t.getData();
//					if (data != null) {
//						byte [] savebytes = t.getData().toByteArray();
//
//						ByteBuffer fileByteBuffer = ByteBuffer.wrap( savebytes);
//						ResultSet insertq = dao.insert(t.getFilename(), fileByteBuffer);
//						if(insertq.wasApplied()) {
//
//							Work.Task.Builder taskBuilder = Work.Task.newBuilder();
//							taskBuilder.setTaskType(TaskType.DATASAVEDBYNODE);
//
//							Common.Header.Builder hb = Common.Header.newBuilder();
//							hb.setNodeId(state.getConf().getNodeId());
//							hb.setDestination(msg.getHeader().getNodeId());
//							hb.setTime(System.currentTimeMillis());
//
//							Work.WorkMessage.Builder wb = Work.WorkMessage.newBuilder();
//							wb.setHeader(hb);
//							wb.setTask(taskBuilder);
//
//							wb.setSecret(1000l);
//
//							EdgeMonitor.sendMessage(msg.getHeader().getNodeId(), wb.build());
//						}
//					}
//				}
			} else if (msg.hasState()) {

				WorkState s = msg.getState();

			} else if (msg.hasLeader()) {

				System.out.println("inquiry for leader");
				ElectionHandler.getInstance().handleLeader(msg);

			} else if (msg.hasElection()) {

				ElectionHandler.getInstance().handleElection(msg);

			}

		} catch (Exception e) {
			// TODO add logging
			Failure.Builder eb = Failure.newBuilder();
			eb.setId(state.getConf().getNodeId());
			eb.setRefId(msg.getHeader().getNodeId());
			eb.setMessage(e.getMessage());
			WorkMessage.Builder rb = WorkMessage.newBuilder(msg);
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
	protected void channelRead0(ChannelHandlerContext ctx, WorkMessage msg) throws Exception {
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
			queue = new InboundWorkerQueue(ctx.channel(), state);
			// on close remove from queue
//			channel.closeFuture().addListener(new ConnectionCloseListener(queue));
		}

		return queue;
	}
}
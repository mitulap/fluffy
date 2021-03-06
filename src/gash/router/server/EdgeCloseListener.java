package gash.router.server;

import gash.router.server.edges.EdgeInfo;
import gash.router.server.edges.EdgeMonitor;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import java.util.Random;

/**
 * Created by patel on 3/31/2016.
 */
public class EdgeCloseListener implements ChannelFutureListener {

    private EdgeInfo edgeInfo;

    public EdgeCloseListener(EdgeInfo edgeInfo)
    {
        this.edgeInfo = edgeInfo;
    }

    @Override
    public void operationComplete(ChannelFuture channelFuture) throws Exception
    {
        // remove active connection and check if removed node was leader
        System.out.println("connection to "+edgeInfo.getRef()+" closed");
        EdgeMonitor.activeConnections.remove(edgeInfo.getRef());

        if(ElectionHandler.getInstance().getLeaderNodeId() == edgeInfo.getRef() || (EdgeMonitor.activeConnections.size() == 0 && ElectionHandler.getInstance().getLeaderNodeId() == ElectionHandler.conf.getNodeId()))
        {
            if(EdgeMonitor.activeConnections.size() == 0 && ElectionHandler.getInstance().getLeaderNodeId() == ElectionHandler.conf.getNodeId())
                System.out.println("Damn I am the leader and I am dead");
            else
                System.out.println("The leader is dead!! The leader is dead!!");

            ElectionHandler.getInstance().leaderIsDead();
        }

        Thread.sleep(new Random().nextInt(3) * 1000);

        ElectionHandler.getInstance().checkCurrentState();
    }
}

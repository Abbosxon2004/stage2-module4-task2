package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;
    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        realConnection.close();
    }

    @Override
    public void close() {
        ConnectionPool.getInstance().releaseConnection(this);
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }
    // Implement methods here!
}
//    com.mjc.stage2.impl.ConnectionPool is a pool that contains all real connections created.
//
//        com.mjc.stage2.impl.RealConnection is a connection that implements the com.mjc.stage2.Connection interface and is used in connection pool.
//
//        Task: Implement proxy pattern for connection.
//        Implement interface Connection in the ProxyConnection class (com.mjc.stage2.impl)
//        The close() method should return connection to the connection pool
//        Write a reallyClose() method in the ProxyConnection class that closes the real connection.
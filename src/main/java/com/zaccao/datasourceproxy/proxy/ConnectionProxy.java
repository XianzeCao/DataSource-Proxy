package com.zaccao.datasourceproxy.proxy;

import java.sql.Connection;
import java.sql.SQLException;


public class ConnectionProxy extends AbstractConnectionProxy{

    public ConnectionProxy(DataSourceProxy dataSourceProxy, Connection targetConnection) {
        super(dataSourceProxy, targetConnection);
    }

    //重写父类方法，不需要改动
    @Override
    public void setAutoCommit(boolean autoCommit) throws SQLException {
        targetConnection.setAutoCommit(autoCommit);
    }

    @Override
    public void commit() throws SQLException {
        targetConnection.commit();
    }

    @Override
    public void rollback() throws SQLException {
        targetConnection.rollback();
    }
}

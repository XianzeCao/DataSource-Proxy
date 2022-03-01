package com.zaccao.datasourceproxy.proxy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class DataSourceProxy extends AbstractDataSourceProxy{


    public DataSourceProxy(DataSource targetDataSource) {
        super(targetDataSource);
    }

    //获取Connection
    @Override
    public Connection getConnection() throws SQLException {
        Connection targetConnection = targetDataSource.getConnection();
        //针对原始连接进行代理
        return new ConnectionProxy(this, targetConnection);
    }

    // 根据username/password获取Connection
    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        Connection targetConnection = targetDataSource.getConnection(username, password);
        return new ConnectionProxy(this, targetConnection);
    }
}

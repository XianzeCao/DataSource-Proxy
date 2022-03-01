package com.zaccao.datasourceproxy.proxy;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;


public abstract class AbstractDataSourceProxy implements DataSource {

    protected DataSource targetDataSource; //原始数据源

    public AbstractDataSourceProxy(DataSource targetDataSource){
        this.targetDataSource=targetDataSource;
    }

    public DataSource getTargetDataSource(){
        return targetDataSource;
    }

    // 下面都是重写父类的方法，因为这里实现了java.sql.DataSource

     @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
         return targetDataSource.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return targetDataSource.isWrapperFor(iface);
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return targetDataSource.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        targetDataSource.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        targetDataSource.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return targetDataSource.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return targetDataSource.getParentLogger();
    }
}

package com.zaccao.datasourceproxy.proxy;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;


public abstract class AbstractStatementProxy <T extends Statement> implements Statement{

    //连接代理对象
    protected AbstractConnectionProxy connectionProxy;
    //目标statement
    protected T targetStatement;

    private CachedRowSet generatedKeysRowSet;
    //目标sql
    protected String targetSQL;

    public AbstractStatementProxy(AbstractConnectionProxy connectionProxy, T targetStatement, String targetSQL)
            throws SQLException {
        this.connectionProxy = connectionProxy;
        this.targetStatement = targetStatement;
        this.targetSQL = targetSQL;
    }
    public AbstractStatementProxy(ConnectionProxy connectionProxy, T targetStatement) throws SQLException {
        this(connectionProxy, targetStatement, null);
    }
    public AbstractConnectionProxy getConnectionProxy() {
        return connectionProxy;
    }

    public T getTargetStatement() {
        return targetStatement;
    }

    public String getTargetSQL() {
        return targetSQL;
    }

    //下面部分都是重写父类的方法，不需要动，直接委派给目标statement执行就行
    @Override
    public void close() throws SQLException {
        targetStatement.close();

    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return targetStatement.getMaxFieldSize();
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        targetStatement.setMaxFieldSize(max);

    }

    @Override
    public int getMaxRows() throws SQLException {
        return targetStatement.getMaxRows();
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        targetStatement.setMaxRows(max);

    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        targetStatement.setEscapeProcessing(enable);

    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return targetStatement.getQueryTimeout();
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        targetStatement.setQueryTimeout(seconds);

    }

    @Override
    public void cancel() throws SQLException {
        targetStatement.cancel();

    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return targetStatement.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        targetStatement.clearWarnings();

    }

    @Override
    public void setCursorName(String name) throws SQLException {
        targetStatement.setCursorName(name);

    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return targetStatement.getResultSet();
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return targetStatement.getUpdateCount();
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        return targetStatement.getMoreResults();
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        targetStatement.setFetchDirection(direction);

    }

    @Override
    public int getFetchDirection() throws SQLException {
        return targetStatement.getFetchDirection();
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        targetStatement.setFetchSize(rows);

    }

    @Override
    public int getFetchSize() throws SQLException {
        return targetStatement.getFetchSize();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return targetStatement.getResultSetConcurrency();
    }

    @Override
    public int getResultSetType() throws SQLException {
        return targetStatement.getResultSetType();
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        targetStatement.addBatch(sql);

    }

    @Override
    public void clearBatch() throws SQLException {
        targetStatement.clearBatch();
        targetSQL = null;
    }

    @Override
    public int[] executeBatch() throws SQLException {
        return targetStatement.executeBatch();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return targetStatement.getConnection();
    }

    @Override
    public boolean getMoreResults(int current) throws SQLException {
        return targetStatement.getMoreResults(current);
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        if (generatedKeysRowSet != null) {
            return generatedKeysRowSet;
        }
        ResultSet rs = targetStatement.getGeneratedKeys();
        generatedKeysRowSet = RowSetProvider.newFactory().createCachedRowSet();
        generatedKeysRowSet.populate(rs);
        return generatedKeysRowSet;
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return targetStatement.getResultSetHoldability();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return targetStatement.isClosed();
    }

    @Override
    public void setPoolable(boolean poolable) throws SQLException {
        targetStatement.setPoolable(poolable);

    }

    @Override
    public boolean isPoolable() throws SQLException {
        return targetStatement.isPoolable();
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        targetStatement.closeOnCompletion();

    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        return targetStatement.isCloseOnCompletion();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return targetStatement.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return targetStatement.isWrapperFor(iface);
    }


}

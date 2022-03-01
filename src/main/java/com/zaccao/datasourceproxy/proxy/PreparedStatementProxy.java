package com.zaccao.datasourceproxy.proxy;

import com.zaccao.datasourceproxy.proxy.sqlparser.ParametersHolder;
import lombok.extern.slf4j.Slf4j;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;


@Slf4j
public class PreparedStatementProxy extends AbstractPreparedStatementProxy implements PreparedStatement, ParametersHolder {

    public PreparedStatementProxy(AbstractConnectionProxy connectionProxy, PreparedStatement targetStatement,
                                  String targetSQL) throws SQLException {
        super(connectionProxy, targetStatement, targetSQL);
    }

    @Override
    public Map<Integer, ArrayList<Object>> getParameters() {
        return parameters;
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        log.info("executeQuery:这里可以拿到执行的目标Sql，然后对目标SQL进行重构："+this.getTargetSQL());
        return this.targetStatement.executeQuery();
    }

    @Override
    public int executeUpdate() throws SQLException {
        log.info("executeUpdate:这里可以拿到执行的目标Sql，然后对目标SQL进行重构："+this.getTargetSQL());
        return this.targetStatement.executeUpdate();
    }

    @Override
    public boolean execute() throws SQLException {
        log.info("execute:这里可以拿到执行的目标Sql，然后对目标SQL进行重构："+this.getTargetSQL());
        return this.targetStatement.execute();
    }
}

package com.zaccao.datasourceproxy.proxy.annotation;


import com.zaccao.datasourceproxy.proxy.DataSourceProxy;

import javax.sql.DataSource;
import java.util.concurrent.ConcurrentHashMap;


public class DataSourceProxyHolder {
    private static final int MAP_INITIAL_CAPACITY = 8;
    private ConcurrentHashMap<DataSource, DataSourceProxy> dataSourceProxyMap;

    private DataSourceProxyHolder() {
        dataSourceProxyMap = new ConcurrentHashMap<>(MAP_INITIAL_CAPACITY);
    }

    /**
     * the type holder
     */
    private static class Holder {
        private static final DataSourceProxyHolder INSTANCE;

        static {
            INSTANCE = new DataSourceProxyHolder();
        }

    }

    /**
     * Get DataSourceProxyHolder instance
     *
     * @return the INSTANCE of DataSourceProxyHolder
     */
    public static DataSourceProxyHolder get() {
        return Holder.INSTANCE;
    }

    /**
     * Put dataSource
     *
     * @param dataSource
     * @return dataSourceProxy
     */
    public DataSourceProxy putDataSource(DataSource dataSource) {
        return this.dataSourceProxyMap.computeIfAbsent(dataSource, DataSourceProxy::new);
    }

    /**
     * Get dataSourceProxy
     *
     * @param dataSource
     * @return dataSourceProxy
     */
    public DataSourceProxy getDataSourceProxy(DataSource dataSource) {
        return this.dataSourceProxyMap.get(dataSource);
    }
}

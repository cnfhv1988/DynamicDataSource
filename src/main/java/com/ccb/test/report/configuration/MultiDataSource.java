package com.ccb.test.report.configuration;

import com.ccb.test.report.common.DataSourceKey;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class MultiDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }
}

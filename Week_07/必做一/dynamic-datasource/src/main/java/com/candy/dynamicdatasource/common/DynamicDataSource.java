package com.candy.dynamicdatasource.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author zh0809
 * @date 2020/12/2 11:10
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        if (DataSourceContextHolder.getDataSource() == null) {
            System.out.println("==============================现在的数据源是:默认库==============================");
        } else {
            System.out.println("==============================现在的数据源是:" + DataSourceContextHolder.getDataSource() + "==============================");
        }
        return DataSourceContextHolder.getDataSource();
    }

}

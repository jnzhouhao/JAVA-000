package com.candy.dynamicdatasource.common.enums;

/**
 * @author zh0809
 * @date 2020/12/2 11:11
 **/
public enum DataSourceEnum {

    /**
     * 主库
     */
    MASTER("master", 100),
    /**
     * 从库
     */
    SLAVE("slave", 1),
    /**
     * 从库2
     */
    SLAVE2("slave2", 3),
    /**
     * 从库3
     */
    SLAVE3("slave3", 4);

    private final String value;
    private final Integer weight;

    DataSourceEnum(String value, Integer weight){
        this.value = value;
        this.weight = weight;
    }

    public String getValue() {
        return value;
    }
    public Integer getWeight() {
        return weight;
    }

}

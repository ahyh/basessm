package com.yanhuan.yhssm.dynamo.proxy;

public class MethodDesc {

    /**
     * 表名
     */
    private String table;

    private String indexName;

    /**
     * 是否走主键
     */
    private boolean primary;

    /**
     * hashKey
     */
    private String hashKey;

    /**
     * sortKey
     */
    private String sortKey;

    /**
     * rangeKey的操作：EQ/START_WITH
     */
    private String op;

    private Class clazz;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public String getSortKey() {
        return sortKey;
    }

    public void setSortKey(String sortKey) {
        this.sortKey = sortKey;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }
}

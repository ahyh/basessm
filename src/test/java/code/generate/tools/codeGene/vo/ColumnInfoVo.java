package code.generate.tools.codeGene.vo;

import java.io.Serializable;

/**
 * 列信息Vo
 */
public class ColumnInfoVo implements Serializable {

    /**
     * 列名
     */
    private String columnName;

    /**
     * sql类型
     */
    private String sqlType;

    /**
     * 字段长度
     */
    private Integer length;

    /**
     * java属性名
     */
    private String javaFliedName;

    /**
     * java类型
     */
    private String javaType;

    /**
     * 列描述信息
     */
    private String columnComment;

    /**
     * 是否主键
     */
    private Boolean isPrimary;

    /**
     * 是否自增
     */
    private Boolean isAutoIncrement;

    /**
     * 是否允许为空
     */
    private Boolean isNullable;

    /**
     * 是否唯一约束
     */
    private Boolean isUnique;

    /**
     * 默认值
     */
    private String defaultValue;

    public ColumnInfoVo() {
    }

    public ColumnInfoVo(String columnName, String sqlType, Integer length, String javaFliedName, String javaType, String columnComment, Boolean isPrimary, Boolean isAutoIncrement, Boolean isNullable, Boolean isUnique, String defaultValue) {
        this.columnName = columnName;
        this.sqlType = sqlType;
        this.length = length;
        this.javaFliedName = javaFliedName;
        this.javaType = javaType;
        this.columnComment = columnComment;
        this.isPrimary = isPrimary;
        this.isAutoIncrement = isAutoIncrement;
        this.isNullable = isNullable;
        this.isUnique = isUnique;
        this.defaultValue = defaultValue;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getJavaFliedName() {
        return javaFliedName;
    }

    public void setJavaFliedName(String javaFliedName) {
        this.javaFliedName = javaFliedName;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public Boolean getPrimary() {
        return isPrimary;
    }

    public void setPrimary(Boolean primary) {
        isPrimary = primary;
    }


    public Boolean getNullable() {
        return isNullable;
    }

    public void setNullable(Boolean nullable) {
        isNullable = nullable;
    }

    public Boolean getUnique() {
        return isUnique;
    }

    public void setUnique(Boolean unique) {
        isUnique = unique;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Boolean getAutoIncrement() {
        return isAutoIncrement;
    }

    public void setAutoIncrement(Boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }
}

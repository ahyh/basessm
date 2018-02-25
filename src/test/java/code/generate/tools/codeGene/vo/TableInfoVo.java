package code.generate.tools.codeGene.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 表信息
 */
public class TableInfoVo implements Serializable {

    /**
     * 表名
     */
    private String tableName;

    /**
     * 类名
     */
    private String className;

    /**
     * 包名
     */
    private String packageName;

    /**
     * 表描述信息
     */
    private String tableComment;

    /**
     * 是否根据创建时间范围查询
     */
    private Boolean timeOrderQuery;

    /**
     * 是否需要默认列
     */
    private Boolean defaultColumnNeed;

    /**
     * 列信息VoList
     */
    private List<ColumnInfoVo> columnInfoVoList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTableComment() {
        return tableComment;
    }

    public void setTableComment(String tableComment) {
        this.tableComment = tableComment;
    }

    public Boolean getTimeOrderQuery() {
        return timeOrderQuery;
    }

    public void setTimeOrderQuery(Boolean timeOrderQuery) {
        this.timeOrderQuery = timeOrderQuery;
    }

    public Boolean getDefaultColumnNeed() {
        return defaultColumnNeed;
    }

    public void setDefaultColumnNeed(Boolean defaultColumnNeed) {
        this.defaultColumnNeed = defaultColumnNeed;
    }

    public List<ColumnInfoVo> getColumnInfoVoList() {
        return columnInfoVoList;
    }

    public void setColumnInfoVoList(List<ColumnInfoVo> columnInfoVoList) {
        this.columnInfoVoList = columnInfoVoList;
    }
}

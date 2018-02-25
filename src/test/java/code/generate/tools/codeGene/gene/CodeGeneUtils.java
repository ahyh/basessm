package code.generate.tools.codeGene.gene;

import code.generate.tools.codeGene.vo.ColumnInfoVo;
import code.generate.tools.codeGene.vo.TableInfoVo;
import com.google.common.base.Preconditions;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 代码生成器工具类
 */
public class CodeGeneUtils {

    private static final String defaultSql = "`create_time` datetime NOT NULL COMMENT '创建时间',\n" +
            "`update_time` datetime NOT NULL COMMENT '更新时间',\n" +
            "`create_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '创建人',\n" +
            "`update_user` varchar(50) COLLATE utf8_unicode_ci NOT NULL COMMENT '更新人',\n" +
            "`is_delete` tinyint(2) NOT NULL COMMENT '删除标识：1-删除，0-未删除',\n" +
            "`ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',\n";

    public static void geneSqlFile(String path, TableInfoVo vo) throws Exception {
        String filePath = (StringUtils.isBlank(path)) ? "D://" : path;
        String fileName = filePath + "//" + vo.getTableName() + ".sql";
        String createTableSql = getCreateTableSql(vo);
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        outputStream.write(createTableSql.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    public static void geneJavaFile(String path, TableInfoVo vo) throws Exception {
        String filePath = (StringUtils.isBlank(path)) ? "D://" : path;
        String fileName = filePath + "//" + vo.getClassName() + ".java";
        String javaFileStr = geneJavaFileStr(vo);
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        outputStream.write(javaFileStr.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    public static void geneQueryClauseFile(String path, TableInfoVo vo) throws Exception {
        String filePath = (StringUtils.isBlank(path)) ? "D://" : path;
        String fileName = filePath + "//" + vo.getClassName() + "QueryClause.java";
        String queryClauseStr = geneQueryClauseStr(vo);
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        outputStream.write(queryClauseStr.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    public static void geneDaoFile(String path, TableInfoVo vo) throws Exception {
        String filePath = (StringUtils.isBlank(path)) ? "D://" : path;
        String fileName = filePath + "//" + vo.getClassName() + "Dao.java";
        String daoFileStr = geneDaoFileStr(vo);
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        outputStream.write(daoFileStr.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    public static void geneMapperFile(String path, TableInfoVo vo) throws Exception {
        String filePath = (StringUtils.isBlank(path)) ? "D://" : path;
        String fileName = filePath + "//" + vo.getClassName() + "Mapper.xml";
        String daoFileStr = geneMapperFileStr(vo);
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName));
        outputStream.write(daoFileStr.getBytes());
        outputStream.flush();
        outputStream.close();
    }

    private static String geneMapperFileStr(TableInfoVo vo) {
        //0-获取主键类型及名称
        List<ColumnInfoVo> columnInfoVoList = vo.getColumnInfoVoList();
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
        sb.append("<mapper namespace=").append("\"").append(vo.getPackageName()).append(".dao.").append(vo.getClassName()).append("Dao\">\n");
        sb.append("   <resultMap id=\"BaseResultMap\" type=\"").append(vo.getClassName()).append("\">\n");
        if (CollectionUtils.isNotEmpty(columnInfoVoList)) {
            for (ColumnInfoVo columnInfoVo : columnInfoVoList) {
                if (columnInfoVo.getPrimary()) {
                    sb.append("     <id column=\"").append(columnInfoVo.getColumnName()).append("\" ").
                            append("property=\"").append(columnInfoVo.getJavaType()).append("\" ").
                            append("jdbcType=\"").append(StringUtils.upperCase(columnInfoVo.getSqlType().equals("int") ? "integer" : columnInfoVo.getSqlType())).append("\"/>\n");
                } else {
                    sb.append("     <result column=\"").append(columnInfoVo.getColumnName()).append("\" ").
                            append("property=\"").append(columnInfoVo.getJavaType()).append("\" ").
                            append("jdbcType=\"").append(StringUtils.upperCase(columnInfoVo.getSqlType().equals("int") ? "integer" : columnInfoVo.getSqlType())).append("\"/>\n");
                }
            }
        }
        sb.append("   </resultMap>\n");
        sb.append("\n");
        sb.append("   <sql id=\"allColumnsWithOutId\">\n");
        sb.append("      (");
        List<String> allColumnsWithOutIdList = columnInfoVoList.stream().filter(x -> !x.getPrimary()).map(x -> x.getColumnName()).collect(Collectors.toList());
        sb.append(StringUtils.join(allColumnsWithOutIdList, ","));
        sb.append(")\n");
        sb.append("   </sql>\n");
        sb.append("\n");
        sb.append("   <sql id=\"allColumns\">\n");
        sb.append("      ");
        List<String> allColumnsList = columnInfoVoList.stream().map(x -> x.getColumnName()).collect(Collectors.toList());
        sb.append(StringUtils.join(allColumnsList, ","));
        sb.append("\n");
        sb.append("   </sql>\n");
        sb.append("\n");
        insertMethod(sb, vo, columnInfoVoList);
        insertBatchMethod(sb, vo, columnInfoVoList);
        getMethod(sb, vo);
        selectMethod(sb, vo, columnInfoVoList, "List");
        selectMethod(sb, vo, columnInfoVoList, "Page");
        updateMethod(sb, vo, columnInfoVoList);
        deleteMethod(sb, vo);
        deleteBatchMethod(sb, vo);
        sb.append("</mapper>\n");
        return sb.toString();
    }

    private static void getMethod(StringBuffer sb, TableInfoVo vo) {
        sb.append("   <select id=\"get\" resultMap=\"BaseResultMap\" parameterType=\"").append(vo.getClassName()).append("QueryClause\"").append(">\n");
        sb.append("       SELECT\n");
        sb.append("       <include refid=\"allColumns\"/>\n");
        sb.append("       from ").append(vo.getTableName()).append("\n");
        sb.append("       where id = #{id,jdbcType=BIGINT}\n");
        sb.append("   </select>\n");
        sb.append("\n");
    }

    private static void insertMethod(StringBuffer sb, TableInfoVo vo, List<ColumnInfoVo> columnInfoVoList) {
        sb.append("   <insert id=\"insert\" parameterType=\"").append(vo.getClassName()).append("\" useGeneratedKeys=\"true\" keyProperty=\"id\">\n");
        sb.append("      insert into ").append(vo.getTableName()).append("\n");
        sb.append("      <include refid=\"allColumnsWithOutId\"/>\n");
        sb.append("      values (\n");
        if (CollectionUtils.isNotEmpty(columnInfoVoList)) {
            for (int i = 0; i < columnInfoVoList.size(); i++) {
                if (!columnInfoVoList.get(i).getPrimary() && !columnInfoVoList.get(i).getColumnName().equals("ts")) {
                    if (i != columnInfoVoList.size() - 1) {
                        if ("createTime".equals(columnInfoVoList.get(i).getJavaFliedName())) {
                            sb.append("       now(),\n");
                        } else if ("updateTime".equals(columnInfoVoList.get(i).getJavaFliedName())) {
                            sb.append("       now(),\n");
                        } else if ("isDelete".equals(columnInfoVoList.get(i).getJavaFliedName())) {
                            sb.append("       0\n");
                        } else {
                            sb.append("      #{").append(columnInfoVoList.get(i).getJavaFliedName()).append(",jdbcType=").
                                    append(StringUtils.upperCase(columnInfoVoList.get(i).getSqlType().equals("int") ? "integer" : columnInfoVoList.get(i).getSqlType())).append("},\n");
                        }
                    }
                }
            }
        }
        sb.append("    )\n");
        sb.append("    </insert>\n");
        sb.append("\n");
    }

    private static void insertBatchMethod(StringBuffer sb, TableInfoVo vo, List<ColumnInfoVo> columnInfoVoList) {
        sb.append("   <insert id=\"insert\" parameterType=\"java.util.List\"").append("\" useGeneratedKeys=\"true\" keyProperty=\"id\">\n");
        sb.append("      insert into ").append(vo.getTableName()).append("\n");
        sb.append("      <include refid=\"allColumnsWithOutId\"/>\n");
        sb.append("      values (\n");
        sb.append("      <foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">\n");
        sb.append("         <trim prefix=\"(\" suffix=\")\">\n");
        if (CollectionUtils.isNotEmpty(columnInfoVoList)) {
            for (int i = 0; i < columnInfoVoList.size(); i++) {
                if (!columnInfoVoList.get(i).getPrimary() && !columnInfoVoList.get(i).getColumnName().equals("ts")) {
                    if (i != columnInfoVoList.size() - 1) {
                        if ("createTime".equals(columnInfoVoList.get(i).getJavaFliedName())) {
                            sb.append("       now(),\n");
                        } else if ("updateTime".equals(columnInfoVoList.get(i).getJavaFliedName())) {
                            sb.append("       now(),\n");
                        } else if ("isDelete".equals(columnInfoVoList.get(i).getJavaFliedName())) {
                            sb.append("       0\n");
                        } else {
                            sb.append("      #{item.").append(columnInfoVoList.get(i).getJavaFliedName()).append(",jdbcType=").
                                    append(StringUtils.upperCase(columnInfoVoList.get(i).getSqlType().equals("int") ? "integer" : columnInfoVoList.get(i).getSqlType())).append("},\n");
                        }
                    }
                }
            }
        }
        sb.append("        </trim>\n");
        sb.append("     </foreach>\n");
        sb.append("   </insert>\n");
        sb.append("\n");
    }

    private static void deleteBatchMethod(StringBuffer sb, TableInfoVo vo) {
        sb.append("    <delete id=\"batchDelete\" parameterType=\"java.util.List\">\n")
                .append("       update ").append(vo.getTableName()).append(" set is_delete = 1,update_time = now()")
                .append("       <where>\n")
                .append("          id IN\n")
                .append("          <foreach collection=\"list\" item=\"item\" index=\"index\" open=\"(\" separator=\",\" close=\")\">\n")
                .append("             #{item,jdbcType=BIGINT}\n")
                .append("          </foreach>\n")
                .append("       </where>\n")
                .append("    </delete>\n")
                .append("\n");
    }

    /**
     * 删除方法
     */
    private static void deleteMethod(StringBuffer sb, TableInfoVo vo) {
        sb.append("    <delete id=\"delete\" parameterType=\"java.lang.Long\">\n")
                .append("       update ").append(vo.getTableName()).append(" set is_delete = 1,update_time = now() where id = #{id,jdbcType=BIGINT}\n")
                .append("    </delete>\n")
                .append("\n");
    }

    /**
     * update方法
     */
    private static void updateMethod(StringBuffer sb, TableInfoVo vo, List<ColumnInfoVo> columnInfoVoList) {
        sb.append("   <update id=\"update\" parameterType=\"").append(vo.getClassName()).append("\">\n");
        sb.append("      update ").append(vo.getTableName()).append("\n");
        sb.append("      <set>\n");
        sb.append("         update_time = now(),update_user=#{updateUser,jdbcType=VARCHAR},\n");
        sb.append("         <trim>\n");
        for (ColumnInfoVo columnInfoVo : columnInfoVoList) {
            if (!columnInfoVo.getPrimary()
                    && !"createTime".equals(columnInfoVo.getJavaFliedName())
                    && !"updateTime".equals(columnInfoVo.getJavaFliedName())
                    && !"createUser".equals(columnInfoVo.getJavaFliedName())
                    && !"updateUser".equals(columnInfoVo.getJavaFliedName())
                    && !"isDelete".equals(columnInfoVo.getJavaFliedName())
                    && !"ts".equals(columnInfoVo.getJavaFliedName())) {
                if (columnInfoVo.getJavaType().equals("String")) {
                    sb.append("         <if test=\"").append(columnInfoVo.getJavaFliedName()).append(" != null and ").append(columnInfoVo.getJavaFliedName()).append(" != ''>\n");
                    sb.append("             ").append(columnInfoVo.getJavaFliedName()).append(" = #{").append(columnInfoVo.getJavaFliedName()).append(",jdbcType = ")
                            .append(StringUtils.upperCase(columnInfoVo.getSqlType().equals("int") ? "integer" : columnInfoVo.getSqlType())).append("},\n")
                            .append("          </if>\n");
                } else {
                    sb.append("         <if test=\"").append(columnInfoVo.getJavaFliedName()).append(" != null \">\n");
                    sb.append("             ").append(columnInfoVo.getJavaFliedName()).append(" = #{").append(columnInfoVo.getJavaFliedName()).append(",jdbcType = ")
                            .append(StringUtils.upperCase(columnInfoVo.getSqlType().equals("int") ? "integer" : columnInfoVo.getSqlType())).append("},\n")
                            .append("          </if>\n");
                }
            }
        }
        sb.append("         <trim>\n");
        sb.append("      <set>\n");
        sb.append("     where id = #{id,jdbcType=BIGINT}\n");
        sb.append("   </update>\n");
        sb.append("\n");
    }

    /**
     * select方法
     */
    private static void selectMethod(StringBuffer sb, TableInfoVo vo, List<ColumnInfoVo> columnInfoVoList, String typeStr) {
        sb.append("   <select id=\"find").append(vo.getClassName()).append(typeStr).append("\"").append(" resultMap=\"BaseResultMap\" parameterType=\"").append(vo.getClassName()).append("QueryClause\"").append(">\n");
        sb.append("       SELECT\n");
        sb.append("       <include refid=\"allColumns\"/>\n");
        sb.append("       from ").append(vo.getTableName()).append("\n");
        sb.append("       <where>\n");
        for (ColumnInfoVo columnInfoVo : columnInfoVoList) {
            if ("isDelete".equals(columnInfoVo.getJavaFliedName())) {
                sb.append("          <choose>\n" +
                        "               <when test=\"isDelete != null\">\n" +
                        "                   and is_delete = #{isDelete,jdbcType=TINYINT}\n" +
                        "               </when>\n" +
                        "               <otherwise>\n" +
                        "                   and is_delete = 0\n" +
                        "               </otherwise>\n" +
                        "          </choose>\n");
            } else if (!"ts".equals(columnInfoVo.getJavaFliedName())) {
                if (columnInfoVo.getJavaType().equals("String")) {
                    sb.append("         <if test=\"").append(columnInfoVo.getJavaFliedName()).append(" != null and ").append(columnInfoVo.getJavaFliedName()).append(" != ''\">\n");
                    sb.append("             and ").append(columnInfoVo.getColumnName()).append(" = #{").append(columnInfoVo.getJavaFliedName()).append(",jdbcType = ")
                            .append(StringUtils.upperCase(columnInfoVo.getSqlType().equals("int") ? "integer" : columnInfoVo.getSqlType())).append("}\n")
                            .append("          </if>\n");
                } else {
                    sb.append("         <if test=\"").append(columnInfoVo.getJavaFliedName()).append(" != null\">\n");
                    sb.append("             and ").append(columnInfoVo.getColumnName()).append(" = #{").append(columnInfoVo.getJavaFliedName()).append(",jdbcType = ")
                            .append(StringUtils.upperCase(columnInfoVo.getSqlType().equals("int") ? "integer" : columnInfoVo.getSqlType())).append("}\n")
                            .append("          </if>\n");
                }
            }
        }
        sb.append("   </select>\n");
        sb.append("\n");
    }

    /**
     * 生成Dao文件
     */
    private static String geneDaoFileStr(TableInfoVo vo) {
        //0-获取主键类型及名称
        List<ColumnInfoVo> columnInfoVoList = vo.getColumnInfoVoList();
        String primaryName = "";
        String primaryClassName = "";
        if (CollectionUtils.isNotEmpty(columnInfoVoList)) {
            for (ColumnInfoVo columnInfoVo : columnInfoVoList) {
                if (columnInfoVo.getPrimary()) {
                    primaryClassName = columnInfoVo.getJavaType();
                    primaryName = columnInfoVo.getJavaFliedName();
                }
            }
        }
        //1-生成包名
        StringBuffer sb = new StringBuffer();
        sb.append("package ").append(vo.getPackageName()).append(".dao;").append("\n");
        sb.append("import ").append(vo.getPackageName()).append(".domain.pojo.").append(vo.getClassName()).append(";\n");
        sb.append("import ").append(vo.getPackageName()).append(".domain.condition.").append(vo.getClassName()).append("QueryClause;").append("\n");
        sb.append("\n");
        sb.append("import java.util.List;").append("\n");
        sb.append("\n");
        sb.append("public interface ").append(vo.getClassName()).append("Dao").append(" {").append("\n");
        sb.append("\n");
        sb.append("    Integer insert(").append(vo.getClassName()).append(" ").append(lowerFirstLetter(vo.getClassName())).append(");\n");
        sb.append("\n");
        sb.append("    Integer insertBatch(List<").append(vo.getClassName()).append("> ").append(lowerFirstLetter(vo.getClassName())).append("List);\n");
        sb.append("\n");
        sb.append("    ").append(vo.getClassName()).append(" get(").append(primaryClassName).append(" ").append(primaryName).append(");\n");
        sb.append("\n");
        sb.append("    List<").append(vo.getClassName()).append("> find").append(vo.getClassName()).append("List(").append(vo.getClassName()).append("QueryClause ").append(lowerFirstLetter(vo.getClassName())).append("QueryClause);\n");
        sb.append("\n");
        sb.append("    List<").append(vo.getClassName()).append("> find").append(vo.getClassName()).append("Page(").append(vo.getClassName()).append("QueryClause ").append(lowerFirstLetter(vo.getClassName())).append("QueryClause);\n");
        sb.append("\n");
        sb.append("    Integer update(").append(vo.getClassName()).append(" ").append(lowerFirstLetter(vo.getClassName())).append(");\n");
        sb.append("\n");
        sb.append("    Integer delete(").append(primaryClassName).append(" ").append(primaryName).append(");\n");
        sb.append("\n");
        sb.append("    Integer deleteBatch(List<").append(primaryClassName).append("> ").append(primaryName).append("List);\n");
        sb.append("\n");
        sb.append("}");
        sb.append("\n");
        return sb.toString();
    }

    /**
     * 生成查询条件文件
     */
    private static String geneQueryClauseStr(TableInfoVo vo) {
        //1-生成包名
        StringBuffer sb = new StringBuffer();
        sb.append("package ").append(vo.getPackageName()).append(".domain.condition;").append("\n");
        sb.append("\n");
        sb.append("import java.io.Serializable;").append("\n");
        sb.append("\n");
        sb.append("public class ").append(vo.getClassName()).append("QueryClause").append(" implements Serializable {").append("\n");
        sb.append("\n");
        List<ColumnInfoVo> columnInfoVoList = vo.getColumnInfoVoList();
        if (vo.getTimeOrderQuery()) {
            ColumnInfoVo createTimeStartColumn = new ColumnInfoVo("create_time_start", "datetime", null, "createTimeStart", "String", "开始时间", false, false, false, false, "");
            ColumnInfoVo createTimeEndColumn = new ColumnInfoVo("create_time_End", "datetime", null, "createTimeEnd", "String", "结束时间", false, false, false, false, "");
            columnInfoVoList.add(createTimeStartColumn);
            columnInfoVoList.add(createTimeEndColumn);
        }
        if (CollectionUtils.isNotEmpty(columnInfoVoList)) {
            for (ColumnInfoVo columnInfoVo : columnInfoVoList) {
                if ("Date".equals(columnInfoVo.getJavaType())) {
                    columnInfoVo.setJavaType("String");
                }
                sb.append(geneJavaField(columnInfoVo));
            }
            sb.append("\n");
            for (ColumnInfoVo columnInfoVo : vo.getColumnInfoVoList()) {
                if ("Date".equals(columnInfoVo.getJavaType())) {
                    columnInfoVo.setJavaType("String");
                }
                sb.append(geneGetAndSetMethod(columnInfoVo));
            }
        }
        sb.append("\n");
        sb.append("}");
        sb.append("\n");
        return sb.toString();
    }

    /**
     * java对象文件
     */
    private static String geneJavaFileStr(TableInfoVo vo) {
        //1-生成包名
        StringBuffer sb = new StringBuffer();
        sb.append("package ").append(vo.getPackageName()).append(".domain.pojo;").append("\n");
        sb.append("\n");
        sb.append("import java.io.Serializable;").append("\n");
        sb.append("import java.util.Date;").append("\n");
        sb.append("\n");
        sb.append("public class ").append(vo.getClassName()).append(" implements Serializable {").append("\n");
        sb.append("\n");
        if (CollectionUtils.isNotEmpty(vo.getColumnInfoVoList())) {
            for (ColumnInfoVo columnInfoVo : vo.getColumnInfoVoList()) {
                sb.append(geneJavaField(columnInfoVo));
            }
            sb.append("\n");
            for (ColumnInfoVo columnInfoVo : vo.getColumnInfoVoList()) {
                sb.append(geneGetAndSetMethod(columnInfoVo));
            }
        }
        sb.append("\n");
        sb.append("}");
        sb.append("\n");
        return sb.toString();
    }

    private static String geneJavaField(ColumnInfoVo vo) {
        StringBuffer sb = new StringBuffer();
        sb.append("   /**\n");
        sb.append("   ").append(vo.getColumnComment()).append("\n");
        sb.append("   **/\n");
        sb.append("   private ").append(vo.getJavaType()).append(" ").append(vo.getJavaFliedName()).append(";");
        sb.append("\n");
        return sb.toString();
    }

    private static String geneGetAndSetMethod(ColumnInfoVo vo) {
        StringBuffer sb = new StringBuffer();
        String javaFieldName = vo.getJavaFliedName();
        String javaType = vo.getJavaType();
        Preconditions.checkNotNull(javaFieldName);
        if (javaFieldName.startsWith("is") && (javaFieldName.charAt(2) > 'A' && javaFieldName.charAt(2) < 'Z')) {
            sb.append("   public void set").append(javaFieldName.substring(2)).append("(")
                    .append(vo.getJavaType()).append(" ").append(StringUtils.lowerCase(String.valueOf(javaFieldName.charAt(2))))
                    .append(javaFieldName.substring(3)).append(") {\n").append("     this.").append(vo.getJavaFliedName()).append(" = ")
                    .append(StringUtils.lowerCase(String.valueOf(javaFieldName.charAt(2))))
                    .append(javaFieldName.substring(3)).append(";\n   }");
            sb.append("\n");
            sb.append("   public ").append(javaType).append(" get").append(javaFieldName.substring(2)).append("(").append(") {\n")
                    .append("     return ").append(javaFieldName.substring(2)).append(" = ").append(javaFieldName.substring(2))
                    .append(";\n   }");
            sb.append("\n");
        } else {
            sb.append("   public void set").append(upperFirstLetter(javaFieldName)).append("(").append(vo.getJavaType())
                    .append(" ").append(javaFieldName).append(") {\n").append("     this.").append(javaFieldName)
                    .append(" = ").append(javaFieldName).append(";\n   }");
            sb.append("\n");
            sb.append("   public ").append(javaType).append(" get").append(upperFirstLetter(javaFieldName)).append("(")
                    .append(" ){\n").append("     return ").append(javaFieldName).append(";\n").append("   }");
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * 首字母大写
     */
    private static String upperFirstLetter(String str) {
        if (StringUtils.isNotBlank(str)) {
            String s = StringUtils.upperCase(String.valueOf(str.charAt(0)));
            return s + str.substring(1);
        }
        return null;
    }

    /**
     * 首字母小写
     */
    private static String lowerFirstLetter(String str) {
        if (StringUtils.isNotBlank(str)) {
            String s = StringUtils.lowerCase(String.valueOf(str.charAt(0)));
            return s + str.substring(1);
        }
        return null;
    }

    private static String getCreateTableSql(TableInfoVo vo) {
        StringBuffer sb = new StringBuffer();
        sb.append("create table `").append(vo.getTableName()).append("` (\n");
        if (CollectionUtils.isNotEmpty(vo.getColumnInfoVoList())) {
            for (ColumnInfoVo columnInfoVo : vo.getColumnInfoVoList()) {
                if ("datetime".equals(columnInfoVo.getSqlType()) || "timestamp".equals(columnInfoVo.getSqlType())) {
                    sb.append("`").append(columnInfoVo.getColumnName()).append("` ").
                            append(columnInfoVo.getSqlType());
                } else {
                    sb.append("`").append(columnInfoVo.getColumnName()).append("` ").
                            append(columnInfoVo.getSqlType()).append("(").append(columnInfoVo.getLength()).append(") ");
                }
                if (columnInfoVo.getNullable()) {
                    sb.append("NOT NULL ");
                }
                if (columnInfoVo.getAutoIncrement()) {
                    sb.append("AUTO_INCREMENT ");
                }
                if (StringUtils.isNotBlank(columnInfoVo.getDefaultValue())) {
                    sb.append("DEFAULT ").append(columnInfoVo.getDefaultValue()).append(" ");
                }
                sb.append("COMMENT ").append("'").append(columnInfoVo.getColumnComment()).append("'").append(",\n");
            }
        }
        if (vo.getDefaultColumnNeed()) {
            sb.append(defaultSql);
        }
        //主键
        if (CollectionUtils.isNotEmpty(vo.getColumnInfoVoList())) {
            for (ColumnInfoVo columnInfoVo : vo.getColumnInfoVoList()) {
                if (columnInfoVo.getPrimary()) {
                    sb.append("PRIMARY KEY (`").append(columnInfoVo.getColumnName()).append("`)");
                    break;
                }
            }
        }
        //唯一约束
        if (CollectionUtils.isNotEmpty(vo.getColumnInfoVoList())) {
            for (ColumnInfoVo columnInfoVo : vo.getColumnInfoVoList()) {
                if (columnInfoVo.getUnique()) {
                    sb.append(",\n").append("UNIQUE KEY ").append("`unique_").append(columnInfoVo.getColumnName()).append("` ").append("(`").append(columnInfoVo.getColumnName()).append("`)");
                }
            }
        }
        sb.append("\n").append(") ").append("ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;\n");
        return sb.toString();
    }


}

package com.mytool;

import com.github.pagehelper.PageHelper;
import com.mytool.common.api.CommonResult;
import com.mytool.model.ClientMenu;
import com.mytool.model.ClientMenuExample;
import com.mytool.model.PmsProductCategoryExample;
import com.mytool.model.UmsRole;
import io.swagger.annotations.ApiModelProperty;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;


public class MySQLGeneratorEntityUtil {
    //表名
    private String tableName;
    private String modelName;
    private String modelName2;


    //列名数组
    private String[] colNames;
    //列名类型数组
    private String[] colTypes;
    //列名大小数组
    private int[] colSizes;
    //列名注释
    private Map colNamesComment = new HashMap();
    //是否需要导入包java.util.*
    private boolean needUtil = false;
    //是否需要导入包java.sql.*
    private boolean needSql = false;
    //是否需要导入包java.math.BigDecimal
    private boolean needBigDecimal = false;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String SQL = "SELECT * FROM ";// 数据库操作

    // 数据库配置信息
    private static final String URL ="jdbc:mysql://47.104.173.16:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String NAME = "root";
    private static final String PASS = "xaoyuan521";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static String moduleName = "farm";

    //指定实体生成所在包的路径
    private static String basePath = new File("").getAbsolutePath()+"/"+moduleName+"/src/main/java/";

    private static String resourcesPath = new File("").getAbsolutePath()+"/"+moduleName+"/src/main/resources/";


    private static String  packageName="com.mytool."+moduleName;

    //指定包名
    private static String packageModelOutPath = packageName+".model";

    //指定包名
    private static String packageControllerOutPath =  packageName+".controller";

    private static String packageMapperOutPath = packageName+".mapper";


    private static String packageServiceOutPath =  packageName+".service";
    private static String packageServiceimpleOutPath = packageName+".service.impl";

    //作者名字
    private String authorName = "mytool";
    //指定需要生成的表的表名，全部生成设置为null
    private String[] generateTables = new String[]{"farm_item"};

    private String primaryKey = "id";




    //["farm_item"];
    //主键
    private static String pk;

    private MySQLGeneratorEntityUtil() {
    }

    /**
     * 功能：获取并创建实体所在的路径目录
     * @return
     */
    private static String pkgModelDirName() {
        String dirName = basePath + packageModelOutPath.replace(".", "/");
        File dir = new File(dirName);

        if (!dir.exists()) {dir.mkdirs();System.out.println("mkdirs dir 【" + dirName + "】");}
        return dirName;
    }
    /**
     * 功能：获取并创建实体所在的路径目录
     * @return
     */
    private static String pkgControllerDirName() {
        String dirName = basePath + packageControllerOutPath.replace(".", "/");
        File dir = new File(dirName);

        if (!dir.exists()) {dir.mkdirs();System.out.println("mkdirs dir 【" + dirName + "】");}
        return dirName;
    }

    /**
     * 功能：获取并创建实体所在的路径目录
     * @return
     */
    private static String pkgMapperDirName() {
        String dirName = basePath +  packageMapperOutPath.replace(".", "/");
        File dir = new File(dirName);

        if (!dir.exists()) {dir.mkdirs();System.out.println("mkdirs dir 【" + dirName + "】");}
        return dirName;
    }
    /**
     * 功能：获取并创建实体所在的路径目录
     * @return
     */
    private static String pkgXmlDirName() {
        String dirName = resourcesPath + "mapper";
        File dir = new File(dirName);

        if (!dir.exists()) {dir.mkdirs();System.out.println("mkdirs dir 【" + dirName + "】");}
        return dirName;
    }

    /**
     * 功能：获取并创建实体所在的路径目录
     * @return
     */
    private static String pkgServiceDirName() {
        String dirName = basePath + packageServiceOutPath.replace(".", "/");
        File dir = new File(dirName);

        if (!dir.exists()) {dir.mkdirs();System.out.println("mkdirs dir 【" + dirName + "】");}
        return dirName;
    }

    /**
     * 功能：获取并创建实体所在的路径目录
     * @return
     */
    private static String pkgServiceImplDirName() {
        String dirName = basePath + packageServiceimpleOutPath.replace(".", "/");
        File dir = new File(dirName);

        if (!dir.exists()) {dir.mkdirs();System.out.println("mkdirs dir 【" + dirName + "】");}
        return dirName;
    }
    /**
     * @description 生成class的所有内容
     */
    private String makeExample() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageModelOutPath + ";\r\n");
        sb.append("\r\n");

        sb.append("import java.util.ArrayList;\r\n");
        sb.append("import java.util.List;\r\n");

        // 判断是否导入工具包
        if (needUtil) {
            sb.append("import java.util.Date;\r\n");
        }
        if (needSql) {
            sb.append("import java.sql.*;\r\n");
        }

        for (int i = 0; i < colNames.length; i++) {
            String hasbd = sqlType2JavaType(colTypes[i]);
            if(hasbd =="BigDecimal" || "BigDecimal".equals(hasbd)) {needBigDecimal=true;}
        }
        if(needBigDecimal) {
            sb.append("import java.math.BigDecimal;\r\n");
        }
        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        // 实体部分
        sb.append("public class " + modelName  + "Example {\r\n\r\n");

        sb.append("\tprotected String orderByClause;\r\n\n");
        sb.append("\tprotected boolean distinct;\r\n\n");

        sb.append("\tprotected List<Criteria> oredCriteria;\r\n");
        sb.append("\tpublic "+modelName+"Example() {\r\n");
        sb.append("\t\toredCriteria = new ArrayList<"+modelName+"Example.Criteria>();\r\n");
        sb.append("\t}\r\n");
        sb.append("\tpublic void setOrderByClause(String orderByClause) {\r\n");
        sb.append("\t\tthis.orderByClause = orderByClause;\r\n");
        sb.append("\t}\r\n");
        sb.append("\tpublic String getOrderByClause() {\r\n");
        sb.append("\t\treturn orderByClause;\r\n");
        sb.append("\t}\r\n");

        sb.append("\tpublic void setDistinct(boolean distinct) {\r\n");
        sb.append("\t\tthis.distinct = distinct;\r\n");
        sb.append("\t}\r\n");
        sb.append("\tpublic boolean isDistinct() {\r\n");
        sb.append("\t\treturn distinct;\r\n");
        sb.append("\t}\r\n");



        sb.append("\tpublic List<Criteria> getOredCriteria() {\r\n");
        sb.append("\t\treturn oredCriteria;\r\n");
        sb.append("\t}\r\n");

        sb.append("\tpublic void or(Criteria criteria) {\r\n");
        sb.append("\t\toredCriteria.add(criteria);\r\n");
        sb.append("\t}\r\n");


        sb.append("\tpublic Criteria or() {\r\n");
        sb.append("\t\tCriteria criteria = createCriteriaInternal();\r\n");
        sb.append("\t\toredCriteria.add(criteria);\r\n");
        sb.append("\t\treturn criteria;\r\n");
        sb.append("\t}\r\n");

        sb.append("\tpublic Criteria createCriteria() {\r\n");
        sb.append("\t\tCriteria criteria = createCriteriaInternal();\r\n");
        sb.append("\t\tif (oredCriteria.size() == 0) {\r\n");
        sb.append("\t\t\toredCriteria.add(criteria);\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\treturn criteria;\r\n");
        sb.append("\t}\r\n");

        sb.append("\tprotected Criteria createCriteriaInternal() {\r\n");
        sb.append("\t\tCriteria criteria = new Criteria();\r\n");
        sb.append("\t\treturn criteria;\r\n");
        sb.append("\t}\r\n");

        sb.append("\tpublic void clear() {\r\n");
        sb.append("\t\toredCriteria.clear();\r\n");
        sb.append("\t\torderByClause = null;\r\n");
        sb.append("\t\tdistinct = false;\r\n");
        sb.append("\t}\r\n");

        sb.append("\tprotected abstract static class GeneratedCriteria {\r\n");
        sb.append("\t\tprotected List<Criterion> criteria;\r\n");

        sb.append("\t\tprotected GeneratedCriteria() {\r\n");
        sb.append("\t\t\tsuper();\r\n");
        sb.append("\t\t\tcriteria = new ArrayList<Criterion>();\r\n");
        sb.append("\t\t}\r\n");

        sb.append("\t\tpublic boolean isValid() {\r\n");
        sb.append("\t\t\treturn criteria.size() > 0;\r\n");
        sb.append("\t\t}\r\n");

        sb.append("\t\tpublic List<Criterion> getAllCriteria() {\r\n");
        sb.append("\t\t\treturn criteria;\r\n");
        sb.append("\t\t}\r\n");

        sb.append("\t\tpublic List<Criterion> getCriteria() {\r\n");
        sb.append("\t\t\treturn criteria;\r\n");
        sb.append("\t\t}\r\n");


        sb.append("\t\tprotected void addCriterion(String condition) {\r\n");
        sb.append("\t\t\tif (condition == null) {\r\n");
        sb.append("\t\t\t\tthrow new RuntimeException(\"Value for condition cannot be null\");\r\n");
        sb.append("\t\t\t}\r\n");
        sb.append("\t\t\tcriteria.add(new Criterion(condition));\r\n");
        sb.append("\t\t}\r\n");

        sb.append("\t\tprotected void addCriterion(String condition, Object value, String property) {\r\n");
        sb.append("\t\tif (value == null) {\r\n");
        sb.append("\t\tthrow new RuntimeException(\"Value for \" + property + \" cannot be null\");\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t\t\tcriteria.add(new Criterion(condition, value));\r\n");
        sb.append("\t\t}\r\n");

        sb.append("\t\tprotected void addCriterion(String condition, Object value1, Object value2, String property) {\r\n");
        sb.append("\t\t\tif (value1 == null || value2 == null) {\r\n");
        sb.append("\t\t\t\tthrow new RuntimeException(\"Between values for \" + property + \" cannot be null\");\r\n");
        sb.append("\t\t\t}\r\n");
        sb.append("\t\t\tcriteria.add(new Criterion(condition, value1, value2));\r\n");
        sb.append("\t\t}\r\n");


        sb.append("\t}\r\n");



        sb.append("\tpublic static class Criteria extends GeneratedCriteria {\r\n");
        sb.append("\t\tprotected Criteria() {\r\n");
        sb.append("\t\t\tsuper();\r\n");
        sb.append("\t\t}\r\n");
        sb.append("\t}\r\n");



        sb.append("\tpublic static class Criterion {\n");
        sb.append("\t\tprivate String condition;\n");

        sb.append("\t\tprivate Object value;\n");

        sb.append("\t\tprivate Object secondValue;\n");

        sb.append("\t\tprivate boolean noValue;\n");

        sb.append("\t\tprivate boolean singleValue;\n");

        sb.append("\t\tprivate boolean betweenValue;\n");

        sb.append("\t\tprivate boolean listValue;\n");

        sb.append("\t\tprivate String typeHandler;\n");

        sb.append("\t\tpublic String getCondition() {\n");
        sb.append("\t\t\treturn condition;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tpublic Object getValue() {\n");
        sb.append("\t\t\treturn value;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tpublic Object getSecondValue() {\n");
        sb.append("\t\t\treturn secondValue;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tpublic boolean isNoValue() {\n");
        sb.append("\t\t\treturn noValue;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tpublic boolean isSingleValue() {\n");
        sb.append("\t\t\treturn singleValue;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tpublic boolean isBetweenValue() {\n");
        sb.append("\t\t\treturn betweenValue;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tpublic boolean isListValue() {\n");
        sb.append("\t\t\treturn listValue;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tpublic String getTypeHandler() {\n");
        sb.append("\t\t\treturn typeHandler;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tprotected Criterion(String condition) {\n");
        sb.append("\t\t\tsuper();\n");
        sb.append("\t\t\tthis.condition = condition;\n");
        sb.append("\t\t\tthis.typeHandler = null;\n");
        sb.append("\t\t\tthis.noValue = true;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tprotected Criterion(String condition, Object value, String typeHandler) {\n");
        sb.append("\t\t\tsuper();\n");
        sb.append("\t\t\tthis.condition = condition;\n");
        sb.append("\t\t\tthis.value = value;\n");
        sb.append("\t\t\tthis.typeHandler = typeHandler;\n");
        sb.append("\t\t\tif (value instanceof List<?>) {\n");
        sb.append("\t\t\t\tthis.listValue = true;\n");
        sb.append("\t\t\t} else {\n");
        sb.append("\t\t\t\tthis.singleValue = true;\n");
        sb.append("\t\t\t}\n");
        sb.append("\t\t }\n");

        sb.append("\t\tprotected Criterion(String condition, Object value) {\n");
        sb.append("\t\t\tthis(condition, value, null);\n");
        sb.append("\t\t}\n");

        sb.append("\t\tprotected Criterion(String condition, Object value, Object secondValue, String typeHandler) {\n");
        sb.append("\t\t\tsuper();\n");
        sb.append("\t\t\tthis.condition = condition;\n");
        sb.append("\t\t\tthis.value = value;\n");
        sb.append("\t\t\tthis.secondValue = secondValue;\n");
        sb.append("\t\t\tthis.typeHandler = typeHandler;\n");
        sb.append("\t\t\tthis.betweenValue = true;\n");
        sb.append("\t\t}\n");

        sb.append("\t\tprotected Criterion(String condition, Object value, Object secondValue) {\n");
        sb.append("\t\t\tthis(condition, value, secondValue, null);\n");
        sb.append("\t\t}\n");
        sb.append("\t}\n");









        sb.append("}\r\n");
        return sb.toString();
    }

    private String makeModel() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageModelOutPath + ";\r\n");
        sb.append("\r\n");

        sb.append("import io.swagger.annotations.ApiModelProperty;\r\n");
        sb.append("import java.io.Serializable;\r\n");

        // 判断是否导入工具包
        if (needUtil) {
            sb.append("import java.util.Date;\r\n");
        }
        if (needSql) {
            sb.append("import java.sql.*;\r\n");
        }

        for (int i = 0; i < colNames.length; i++) {
            String hasbd = sqlType2JavaType(colTypes[i]);
            if(hasbd =="BigDecimal" || "BigDecimal".equals(hasbd)) {needBigDecimal=true;}
        }
        if(needBigDecimal) {
            sb.append("import java.math.BigDecimal;\r\n");
        }
        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        // 实体部分
        sb.append("public class " + modelName  + " implements Serializable {\r\n\r\n");

        for (int i = 0; i < colNames.length; i++) {
            if(colNamesComment.get(colNames[i])!=null &&!"".equals(colNamesComment.get(colNames[i]))) {
                sb.append("\t@ApiModelProperty(value = \""+colNamesComment.get(colNames[i])+"\")\r\n");
            }
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colNames[i] + ";\r\n");
        }
        sb.append("\tprivate static final long serialVersionUID = 1L;\r\n");



        sb.append("\r\n");


        for (int i = 0; i < colNames.length; i++) {
            sb.append("\tpublic void set" + initCap(colNames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " "
                    + colNames[i] + "){\r\n");
            sb.append("\t\tthis." + colNames[i] + "=" + colNames[i] + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initCap(colNames[i]) + "(){\r\n");
            sb.append("\t\treturn " + colNames[i] + ";\r\n");
            sb.append("\t}\r\n");
        }

        sb.append("\t@Override\r\n\tpublic String toString() {\r\n");
        sb.append("\t\tStringBuilder sb = new StringBuilder();\r\n");
        sb.append("\t\tsb.append(getClass().getSimpleName());\r\n");
        sb.append("\t\tsb.append(\" [\");\r\n");
        sb.append("\t\tsb.append(\"Hash = \").append(hashCode());\r\n");
        for (int i = 0; i < colNames.length; i++) {
            sb.append("\t\tsb.append(\", "+colNames[i]+"=\").append("+colNames[i]+");\r\n");
        }
        sb.append("\t\tsb.append(\", serialVersionUID=\").append(serialVersionUID);\r\n");
        sb.append("\t\tsb.append(\"]\");\r\n");
        sb.append("\t\treturn sb.toString();\r\n");

        sb.append("\t}\r\n");
        sb.append("}\r\n");
        return sb.toString();
    }

    /**
     * @description 生成class的所有内容
     */
    private String makeController() {
        StringBuffer sb = new StringBuffer();

        sb.append("package "+packageName+".controller;\r\n \n");
        sb.append("import com.mytool.common.api.CommonPage;  \r\n");
        sb.append("import com.mytool.common.api.CommonResult;  \r\n");
        sb.append("import "+packageName+".model."+modelName+" ; \r\n");
        sb.append("import "+packageName+".service."+modelName+"Service;\r\n");
        sb.append("import io.swagger.annotations.Api;\r\n");
        sb.append("import io.swagger.annotations.ApiOperation;\r\n");
        sb.append("import io.swagger.annotations.ApiParam;\r\n");
        sb.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        sb.append("import org.springframework.stereotype.Controller;\r\n");
        sb.append("import org.springframework.web.bind.annotation.*;\r\n");
        sb.append("import java.util.List;\r\n");


        sb.append("\r\n");
        // 判断是否导入工具包

        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */\r\n");
        // 实体部分
        sb.append("@Controller\r\n");
        sb.append("@Api(value = \""+modelName+"Controller\", tags = {\""+modelName+"Controller\"})\r\n");
        sb.append("@RequestMapping(\"/"+modelName+"\")\r\n");

        sb.append("public class " + modelName + "Controller" + "{\r\n");
        sb.append("\r\n");
        sb.append("\t\t@Autowired\r\n");
        sb.append("\t\t"+modelName +"Service service;\r\n\r\n");


        sb.append("\t\t@ApiOperation(\"create one item\")\n");
        sb.append("\t\t@RequestMapping(value = \"/create\",method = RequestMethod.POST)\r\n");
        sb.append("\t\tpublic CommonResult create(@RequestBody "+modelName+" "+modelName2+") {\n");
        sb.append("\t\t\t\tint count = service.create("+modelName2+");\n");
        sb.append("\t\t\t\tif (count > 0) {\n");
        sb.append("\t\t\t\t\t\treturn CommonResult.success(count);\n");
        sb.append("\t\t\t\t} else {\n");
        sb.append("\t\t\t\t\t\treturn CommonResult.failed();\n");
        sb.append("\t\t\t\t}\n");
        sb.append("\t\t}\n\n");

        sb.append("\t\t@ApiOperation(\"update item info\")\n");
        sb.append("\t\t@RequestMapping(value = \"/update/{"+primaryKey+"}\",method = RequestMethod.POST)\r\n");
        sb.append("\t\tpublic CommonResult update(@PathVariable Integer "+primaryKey+",\r\n");
        sb.append("\t\t\t\t\t\t\t\t@RequestBody "+modelName+" "+modelName2+") {\n");
        sb.append("\t\t\t\tint count = service.update("+modelName2+");\n");
        sb.append("\t\t\t\tif (count > 0) {\n");
        sb.append("\t\t\t\t\t\treturn CommonResult.success(count);\n");
        sb.append("\t\t\t\t} else {\n");
        sb.append("\t\t\t\t\t\treturn CommonResult.failed();\n");
        sb.append("\t\t\t\t}\n");
        sb.append("\t\t}\n\n");


        sb.append("\t\t@ApiOperation(\"delete item by "+primaryKey+"\")\n");
        sb.append("\t\t@RequestMapping(value = \"/delete/{"+primaryKey+"}\",method = RequestMethod.POST)\r\n");
        sb.append("\t\tpublic CommonResult delete(@PathVariable Integer "+primaryKey+") {\r\n");
        sb.append("\t\t\t\tint count = service.delete("+primaryKey+");\n");
        sb.append("\t\t\t\tif (count > 0) {\n");
        sb.append("\t\t\t\t\t\treturn CommonResult.success(count);\n");
        sb.append("\t\t\t\t} else {\n");
        sb.append("\t\t\t\t\t\treturn CommonResult.failed();\n");
        sb.append("\t\t\t\t}\n");
        sb.append("\t\t}\n\n");


        sb.append("\t\t@ApiOperation(\"get detail\")\n");
        sb.append("\t\t@RequestMapping(value = \"/{"+primaryKey+"}\",method = RequestMethod.GET)\r\n");
        sb.append("\t\tpublic CommonResult<"+modelName+"> getItem(@PathVariable Integer "+primaryKey+"){\r\n");
        sb.append("\t\t\t\t"+modelName+" "+modelName2+"=service.getItem("+primaryKey+");\n");
        sb.append("\t\t\t\treturn CommonResult.success("+modelName2+");\n");
        sb.append("\t\t}\n\n");


        sb.append("\t\t@ApiOperation(\"get list by page\")\n");
        sb.append("\t\t@RequestMapping(value = \"/list\",method = RequestMethod.GET)\r\n");
        sb.append("\t\tpublic CommonResult<CommonPage<"+modelName+">> list(@RequestParam(value = \"pageSize\", defaultValue = \"5\") Integer pageSize,\r\n");
        sb.append("\t\t\t\t\t\t\t\t\t\t\t\t\t\t@RequestParam(value = \"pageNum\", defaultValue = \"1\") Integer pageNum) {\r\n");
        sb.append("\t\t\t\tList<"+modelName+"> itemList = service.list(pageSize, pageNum);\n");
        sb.append("\t\t\t\treturn CommonResult.success(CommonPage.restPage(itemList));\n");
        sb.append("\t\t}\n\n");
        sb.append("}\r\n");
        return sb.toString();
    }

    /**
     * @description 生成class的所有内容
     */
    private String makeMapper() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageMapperOutPath + ";\r\n");
        sb.append("import com.mytool.farm.model."+modelName+" ; \r\n");
        sb.append("import com.mytool.farm.model."+modelName+"Example ; \r\n");
        sb.append("import java.util.List;\r\n");
        sb.append("\r\n");

        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        // 实体部分

        sb.append("public interface " + modelName + "Mapper" + "{\r\n\r\n");

        sb.append("\tint insert("+modelName +" model);\r\n\r\n");

        sb.append("\tint update(Integer "+primaryKey+","+modelName +" model);\r\n\r\n");

        sb.append("\tint delete(Integer "+primaryKey+");\r\n\r\n");

        sb.append("\t"+modelName+" getItem(Integer "+primaryKey+");\r\n\r\n");

        sb.append("\tList<"+modelName+"> list("+modelName+"Example example);\r\n\r\n");

        sb.append("}\r\n");
        return sb.toString();
    }


    /**
     * @description 生成class的所有内容
     */
    private String makeXml() {
        StringBuffer sb = new StringBuffer();

        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
        sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\r\n");
        sb.append("<mapper namespace=\""+packageMapperOutPath+"."+modelName+"Mapper\">\r\n");
        sb.append("<resultMap id=\"BaseResultMap\" type=\""+packageModelOutPath+"."+modelName+"\">\r\n");


        String jdbcType="";
        String colNames_str="";
        String colNames_str_value="";


        for (int i = 0; i < colNames.length; i++) {

            jdbcType=sqlType2JdbcType(colTypes[i]);

            sb.append("\t<result column=\""+colNames[i]+"\" jdbcType=\""+jdbcType+"\" property=\""+under2camel(colNames[i], false)+"\" />\r\n");
            if(i>0){
                colNames_str+=",";
                colNames_str_value+=",";
            }
            colNames_str+=colNames[i];
            colNames_str_value+="#{"+colNames[i]+",jdbcType="+jdbcType+"}";
        }

        sb.append("</resultMap>\r\n");

        sb.append("<insert id=\"insert\" parameterType=\""+packageModelOutPath+"."+modelName+"\">\r\n");
        sb.append("\t<selectKey keyProperty=\"id\" order=\"AFTER\" resultType=\"java.lang.Integer\">\r\n");
        sb.append("\tSELECT LAST_INSERT_ID()\r\n");
        sb.append("\t</selectKey>\r\n");
        sb.append("\tinsert into "+tableName+" ("+colNames_str+")\r\n");
        sb.append("\tvalues("+colNames_str_value+")\n");
        sb.append("</insert>\n\n");


        sb.append("<delete id=\"delete\" parameterType=\"java.lang.Integer\">\n");
        sb.append("\t\tdelete from "+tableName+"\n");
        sb.append("\t\twhere "+primaryKey+" = #{"+primaryKey+",jdbcType=INTEGER}\n");
        sb.append("</delete>\n");

        sb.append("<select id=\"getItem\" parameterType=\"java.lang.Integer\" resultMap=\"BaseResultMap\">\n");
        sb.append("\t\tselect *\n");
        sb.append("\t\tfrom client_menu\n");
        sb.append("\t\twhere "+primaryKey+" = #{"+primaryKey+",jdbcType=INTEGER}\n");
        sb.append("</select>\n");

        sb.append("<select id=\"list\" parameterType=\"java.lang.Integer\" resultMap=\"BaseResultMap\">\n");
        sb.append("\t\tselect *\n");
        sb.append("\t\t<if test=\"distinct\"> distinct </if>\n");
        sb.append("\t\tfrom client_menu\n");

        sb.append("\t\t<if test=\"_parameter != null\">\n");

        sb.append("\t\t</if>\n");

        sb.append("\t\twhere "+primaryKey+" = #{"+primaryKey+",jdbcType=INTEGER}\n");

        sb.append("\t\t<if test=\"orderByClause != null\"> order by ${orderByClause}</if>\n");
        sb.append("</select>\n");

        sb.append("</mapper>\r\n");

        return sb.toString();
    }


    /**
     * @description 生成class的所有内容
     */
    private String makeService() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageServiceOutPath + ";\r\n\n");
        sb.append("import "+packageName+".model."+modelName+" ; \r\n");
        sb.append("import java.util.List;\r\n");
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        sb.append("public interface " + modelName + "Service" + "{\r\n\r\n");

        sb.append("     int create("+modelName +" "+modelName2 +");\r\n\r\n");

        sb.append("     int update(Integer "+primaryKey+","+modelName +" "+modelName2 +");\n\n");

        sb.append("     int delete(Integer "+primaryKey+");\n\n");

        sb.append("     "+modelName+" getItem(Integer "+primaryKey+");\n\n");

        sb.append("     /*page search list*/\n\n");

        sb.append("     List<"+modelName+"> list(Integer "+primaryKey+",Integer pageSize, Integer pageNum);\n\n");


        sb.append("}\r\n");
        return sb.toString();
    }
    /**
     * @description 生成class的所有内容
     */
    private String makeServiceImpl() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageServiceimpleOutPath + ";\r\n");
        sb.append("\r\n");
        // 判断是否导入工具包
        sb.append("import "+packageName+".model."+modelName+" ; \r\n");

        sb.append("import "+packageName+".model."+modelName+"Example ; \r\n");

        sb.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        sb.append("import "+packageName+".service."+modelName+"Service ; \r\n");
        sb.append("import "+packageName+".mapper."+modelName+"Mapper ; \r\n");
        sb.append("import org.springframework.stereotype.Service;\r\n");
        sb.append("import com.github.pagehelper.PageHelper;\r\n");
        sb.append("import java.util.List;\r\n");
        sb.append("import java.util.Date;\r\n");

        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        sb.append("@Service\r\n");
        sb.append("public class " + modelName + "ServiceImpl  implements " +modelName+  "Service{\r\n\r\n");

        sb.append("\t@Autowired\r\n");
        sb.append("\t"+modelName +"Mapper "+modelName2+"Mapper ;\r\n\r\n");

        sb.append("\t@Autowired\r\n");
        sb.append("\tpublic int create("+modelName+" "+modelName2+") {\r\n");
        sb.append("\t\t"+modelName2+".setCreate_time((int)new Date().getTime()/1000);\r\n");
        sb.append("\t\treturn "+modelName2+"Mapper.insert("+modelName2+");\r\n");
        sb.append("\t}\r\n\n");

        sb.append("\t@Autowired\r\n");
        sb.append("\tpublic int update(Integer "+primaryKey+","+modelName+" "+modelName2+") {\r\n");
        sb.append("\t\t"+modelName2+".setUpdate_time((int)new Date().getTime()/1000);\r\n");
        sb.append("\t\treturn "+modelName2+"Mapper.update("+modelName2+");\r\n");
        sb.append("\t}\r\n\n");

        sb.append("\t@Autowired\r\n");
        sb.append("\tpublic int delete(Integer "+primaryKey+") {\r\n");
        sb.append("\t\treturn "+modelName2+"Mapper.delete("+primaryKey+");\r\n");
        sb.append("\t}\r\n\n");

        sb.append("\t@Autowired\r\n");
        sb.append("\tpublic "+modelName+" getItem(Integer "+primaryKey+") {\r\n");
        sb.append("\t\treturn "+modelName2+"Mapper.getItem("+primaryKey+");\r\n");
        sb.append("\t}\r\n\n");


        sb.append("\t@Autowired\r\n");
        sb.append("\tpublic List<"+modelName+"> list(Integer "+primaryKey+",Integer pageNum,Integer pageSize) {\r\n");

        sb.append("\t\tPageHelper.startPage(pageNum,pageSize);\r\n");

        sb.append("\t\t"+modelName+"Example example = new "+modelName+"Example();\r\n");
        sb.append("\t\texample.setOrderByClause(\""+primaryKey+" desc\");\r\n");

        sb.append("\t\treturn "+modelName2+"Mapper.list(example);\r\n");
        sb.append("\t}\r\n\n");


        sb.append("}\r\n");
        return sb.toString();
    }


    /**
     * @param str 传入字符串
     * @return
     * @description 将传入字符串的首字母转成大写
     */
    private String initCap(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z')
            ch[0] = (char) (ch[0] - 32);
        return new String(ch);
    }

    /**
     * 功能：下划线命名转驼峰命名
     * @param s
     * @param fistCharToUpperCase 首字母是否大写
     * @author 呐喊
     * @return
     */
    private String under2camel(String s,boolean fistCharToUpperCase) {
        String separator = "_";
        String under="";
        s = s.toLowerCase().replace(separator, " ");
        String sarr[]=s.split(" ");
        for(int i=0;i<sarr.length;i++)
        {
            String w=sarr[i].substring(0,1).toUpperCase()+sarr[i].substring(1);
            under +=w;
        }
        if(!fistCharToUpperCase) {
            under = under.substring(0,1).toLowerCase()+under.substring(1);
        }
        return under;
    }

    /**
     * @return
     * @description 查找sql字段类型所对应的Java类型
     */
    private String sqlType2JavaType(String sqlType) {
        if (sqlType.equalsIgnoreCase("bit")) {
            return "boolean";
        } else if (sqlType.equalsIgnoreCase("TINYINT")) {
            return "byte";
        } else if (sqlType.equalsIgnoreCase("smallint")) {
            return "short";
        } else if (sqlType.equalsIgnoreCase("int")) {
            return "Integer";
        } else if (sqlType.equalsIgnoreCase("bigint")) {
            return "long";
        } else if (sqlType.equalsIgnoreCase("float") || sqlType.equalsIgnoreCase("FLOAT UNSIGNED")) {
            return "float";
        } else if (sqlType.equalsIgnoreCase("numeric")
                || sqlType.equalsIgnoreCase("real") || sqlType.equalsIgnoreCase("money")
                || sqlType.equalsIgnoreCase("smallmoney")) {
            return "double";
        } else if (sqlType.equalsIgnoreCase("varchar") || sqlType.equalsIgnoreCase("char")
                || sqlType.equalsIgnoreCase("nvarchar") || sqlType.equalsIgnoreCase("nchar")
                || sqlType.equalsIgnoreCase("text")|| sqlType.equalsIgnoreCase("longtext")) {
            return "String";
        } else if (sqlType.equalsIgnoreCase("datetime")) {
            return "Date";
        } else if (sqlType.equalsIgnoreCase("image")) {
            return "Blod";
        }else if (sqlType.equalsIgnoreCase("decimal")) {
            return "BigDecimal";
        }else if(sqlType.equalsIgnoreCase("INT UNSIGNED")){
            return "Integer";
        }else if (sqlType.equalsIgnoreCase("MEDIUMINT UNSIGNED")){
            return "Integer";
        }else if (sqlType.equalsIgnoreCase("BLOB")){
            return "byte[]";
        }else if (sqlType.equalsIgnoreCase("INTEGER UNSIGNED")){
            return "Long";
        }else if(sqlType.equalsIgnoreCase("TINYINT UNSIGNED")){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("SMALLINT UNSIGNED")){
            return "Integer";
        }else if(sqlType.equalsIgnoreCase("BIGINT UNSIGNED")){
            return "BigInteger";
        }else if(sqlType.equalsIgnoreCase("DECIMAL UNSIGNED")){
            return "BigDecimal";
        }else if(sqlType.equalsIgnoreCase("TIMESTAMP")){
            return "Timestamp";
        }else if(sqlType.equalsIgnoreCase("MEDIUMTEXT")){
            return "String";
        }
        System.out.println("null==="+sqlType);
        return null;
    }


    /**
     * @return
     * @description 查找sql字段类型所对应的Java类型
     */
    private String sqlType2JdbcType(String sqlType) {

        if (sqlType.equalsIgnoreCase("VARCHAR")) {
            return "VARCHAR";
        }
        if (sqlType.equalsIgnoreCase("longtext")) {
            return "LONGVARCHAR";
        }

        if (sqlType.equalsIgnoreCase("Int")) {
            return "INTEGER";
        }

        if (sqlType.equalsIgnoreCase("DateTime")) {
            return "TIMESTAMP";
        }

        if (sqlType.equalsIgnoreCase("BIT")) {
            return "BOOLEAN";
        }

        if (sqlType.equalsIgnoreCase("BIT")) {
            return "BOOLEAN";
        }

        if (sqlType.equalsIgnoreCase("BIGINT")) {
            return "BIGINT";
        }


        if (sqlType.equalsIgnoreCase("TINYINT")) {
            return "TINYINT";
        }


        if (sqlType.equalsIgnoreCase("SMALLINT")) {
            return "SMALLINT";
        }

        if (sqlType.equalsIgnoreCase("DOUBLE")) {
            return "DOUBLE";
        }

        if (sqlType.equalsIgnoreCase("DECIMAL")) {
            return "DECIMAL";
        }

        return null;
    }







    /**
     * @description 生成方法
     */
    private void generate() throws Exception {
        //与数据库的连接
        Connection con;
        PreparedStatement pStemt = null;
        Class.forName(DRIVER);
        con = DriverManager.getConnection(URL, NAME, PASS);
        System.out.println("connect database success..."+con);
        //获取数据库的元数据
        DatabaseMetaData db = con.getMetaData();
        //是否有指定生成表，有指定则直接用指定表，没有则全表生成
        List<String> tableNames = new ArrayList<>();

        if (generateTables == null) {
            //从元数据中获取到所有的表名
            //ResultSet rs = db.getTables(null, null, null, new String[] { "TABLE" });
            ResultSet rsTables = db.getTables(null, null, "%", null);
            while (rsTables .next()) {
                String tablename = rsTables.getString(3) ;
                if (tablename.contains("bc_")){
                    tableNames.add(rsTables.getString(3));
                }
            }

            // while (rs.next()) tableNames.add(rs.getString(3));
        } else {
            for (String tableName : generateTables) tableNames.add(tableName);
        }

        String tableSql;
        PrintWriter pw = null;
        for (int j = 0; j < tableNames.size(); j++) {

            tableName = tableNames.get(j);

            modelName =under2camel(tableName, true);
            modelName2 =under2camel(tableName, false);

            tableSql = SQL + tableName;
            pStemt = con.prepareStatement(tableSql);
            ResultSetMetaData rsmd = pStemt.getMetaData();
            ResultSet rsk = con.getMetaData().getPrimaryKeys(con.getCatalog().toLowerCase(), null, tableName);
            if (rsk.next()) {
                String primaryKey = rsk.getString("COLUMN_NAME");
                pk=primaryKey;
            }
            int size = rsmd.getColumnCount();
            colNames = new String[size];
            colTypes = new String[size];
            colSizes = new int[size];
            //获取所需的信息
            for (int i = 0; i < size; i++) {
                colNames[i] = rsmd.getColumnName(i + 1);
                colTypes[i] = rsmd.getColumnTypeName(i + 1);
                if (colTypes[i].equalsIgnoreCase("datetime"))
                    needUtil = true;
                if (colTypes[i].equalsIgnoreCase("image") || colTypes[i].equalsIgnoreCase("text"))
                    needSql = true;
                colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
            }
            //获取字段注释
            ResultSet rsComment = pStemt.executeQuery("show full columns from " + tableName);
            while (rsComment.next()) {
                colNamesComment.put(rsComment.getString("Field"), rsComment.getString("Comment"));
            }






            //解析生成实体java文件的所有内容
            String contentExample = makeExample();
            FileWriter fwExample = new FileWriter(MySQLGeneratorEntityUtil.pkgModelDirName() + "/" + modelName + "Example.java");
            pw = new PrintWriter(fwExample);
            pw.println(contentExample);
            pw.flush();





            //解析生成实体java文件的所有内容
            String content = makeModel();
            //输出生成文件
            String dirName = MySQLGeneratorEntityUtil.pkgModelDirName();
            String javaPath = dirName + "/" + modelName + ".java";
            FileWriter fw = new FileWriter(javaPath);
            pw = new PrintWriter(fw);
            pw.println(content);
            pw.flush();


            ///controller
            String makeControllerContent = makeController();
            String dirControllerName = MySQLGeneratorEntityUtil.pkgControllerDirName();
            String javaCPath = dirControllerName + "/" + modelName + "Controller.java";
            FileWriter fwcontroller = new FileWriter(javaCPath);
            pw = new PrintWriter(fwcontroller);
            pw.println(makeControllerContent);
            pw.flush();
            
            ///Mapper
            String daoContent = makeMapper();
            String dirMapperName = MySQLGeneratorEntityUtil.pkgMapperDirName();
            FileWriter fwdao = new FileWriter(dirMapperName + "/" + modelName + "Mapper.java");
            pw = new PrintWriter(fwdao);
            pw.println(daoContent);
            pw.flush();

            ///Mapper.xml
            String xmlContent = makeXml();
            String dirXmlName = MySQLGeneratorEntityUtil.pkgXmlDirName();
            FileWriter fwXml = new FileWriter(dirXmlName + "/" + modelName + "Mapper.xml");
            pw = new PrintWriter(fwXml);
            pw.println(xmlContent);
            pw.flush();


            ///service
            String serviceContent = makeService();
            String dirServiceName = MySQLGeneratorEntityUtil.pkgServiceDirName();
            String javaServicePath = dirServiceName + "/" + modelName + "Service.java";
            FileWriter fwService = new FileWriter(javaServicePath);
            pw = new PrintWriter(fwService);
            pw.println(serviceContent);
            pw.flush();

            ///service
            String serviceImplContent = makeServiceImpl();
            String dirServiceImplName = MySQLGeneratorEntityUtil.pkgServiceImplDirName();
            String javaServiceImplPath = dirServiceImplName + "/" + modelName + "ServiceImpl.java";
            FileWriter fwServiceimpl = new FileWriter(javaServiceImplPath);
            pw = new PrintWriter(fwServiceimpl);
            pw.println(serviceImplContent);
            pw.flush();



            System.out.println("create class 【" + tableName + "】");
        }
        if (pw != null)
            pw.close();
    }

    public static void main(String[] args) {
        MySQLGeneratorEntityUtil instance = new MySQLGeneratorEntityUtil();
        //instance.basePath=""; //指定生成的位置,默认是当前工程
        try {
            instance.generate();
            System.out.println("generate Entity to classes successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
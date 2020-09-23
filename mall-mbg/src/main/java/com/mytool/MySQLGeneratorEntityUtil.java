package com.mytool;

import com.mytool.common.api.CommonResult;
import com.mytool.model.ClientMenu;
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
    //是否创建EntityHelper
    private boolean needEntityHelper = true;
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final String SQL = "SELECT * FROM ";// 数据库操作

    // 数据库配置信息
    private static final String URL ="jdbc:mysql://47.104.173.16:3306/mall?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String NAME = "root";
    private static final String PASS = "xaoyuan521";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";


            //"com.mysql.jdbc.Driver";

    //指定实体生成所在包的路径
    private static String basePath = new File("").getAbsolutePath()+"/farm/src/main/java/";

    private static String  packageName="com.mytool.farm";


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

        processAllAttrs(sb);// 属性
        sb.append("\r\n");
        processConstructor(sb);//构造函数
        processAllMethod(sb);// get set方法
        processToString(sb);
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
        sb.append("import com.mytool.model."+modelName+" ; \r\n");
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
        String classExtends ="";
        if(needEntityHelper) {
            classExtends=" ";
        }


        sb.append("@Controller\r\n");
        sb.append("@Api(value = \""+modelName+"Controller\", description = \""+modelName+"Controller\")\r\n");
        sb.append("@RequestMapping(\"/"+modelName+"\")\r\n");

        sb.append("public class " + modelName + "Controller" + "{\r\n");
        sb.append("\r\n");
        sb.append("    @Autowired\r\n");
        sb.append("    "+modelName +"Service service;\r\n\r\n");

        processControllerMethed(sb);
        sb.append("}\r\n");
        return sb.toString();
    }
    /**
     * @param sb
     * @description 生成所有get/set方法
     */
    private void processControllerMethed(StringBuffer sb) {

        sb.append("    @ApiOperation(\"create one item\")\n");
        sb.append("    @RequestMapping(value = \"/create\",method = RequestMethod.POST)\r\n");
        sb.append("    public CommonResult create(@RequestBody "+modelName+" "+modelName2+") {\n");
        sb.append("        int count = service.create("+modelName2+");\n");
        sb.append("        if (count > 0) {\n");
        sb.append("             return CommonResult.success(count);\n");
        sb.append("        } else {\n");
        sb.append("             return CommonResult.failed();\n");
        sb.append("        }\n");
        sb.append("    }\n\n");

        sb.append("    @ApiOperation(\"update item info\")\n");
        sb.append("    @RequestMapping(value = \"/update/{id}\",method = RequestMethod.POST)\r\n");
        sb.append("    public CommonResult update(@PathVariable Long id,\r\n");
        sb.append("                               @RequestBody "+modelName+" "+modelName2+") {\n");
        sb.append("        int count = service.update(id,"+modelName2+");\n");
        sb.append("        if (count > 0) {\n");
        sb.append("             return CommonResult.success(count);\n");
        sb.append("        } else {\n");
        sb.append("             return CommonResult.failed();\n");
        sb.append("        }\n");
        sb.append("    }\n\n");


        sb.append("    @ApiOperation(\"delete item by id\")\n");
        sb.append("    @RequestMapping(value = \"/delete/{id}\",method = RequestMethod.POST)\r\n");
        sb.append("    public CommonResult delete(@PathVariable Long id) {\r\n");
        sb.append("        int count = service.delete(id);\n");
        sb.append("        if (count > 0) {\n");
        sb.append("             return CommonResult.success(count);\n");
        sb.append("        } else {\n");
        sb.append("             return CommonResult.failed();\n");
        sb.append("        }\n");
        sb.append("    }\n\n");


        sb.append("    @ApiOperation(\"get detail\")\n");
        sb.append("    @RequestMapping(value = \"/{id}\",method = RequestMethod.GET)\r\n");
        sb.append("    public CommonResult<"+modelName+"> getItem(@PathVariable Long id){\r\n");
        sb.append("         "+modelName+" "+modelName2+"=service.getItem(id);\n");
        sb.append("         return CommonResult.success("+modelName2+");\n");
        sb.append("    }\n\n");


        sb.append("    @ApiOperation(\"get list by page\")\n");
        sb.append("    @RequestMapping(value = \"/list\",method = RequestMethod.GET)\r\n");
        sb.append("    public CommonResult<CommonPage<"+modelName+">> list(@RequestParam(value = \"pageSize\", defaultValue = \"5\") Integer pageSize,\r\n");
        sb.append("                                                    @RequestParam(value = \"pageNum\", defaultValue = \"1\") Integer pageNum) {\r\n");
        sb.append("         List<"+modelName+"> itemList = service.list(pageSize, pageNum);\n");
        sb.append("         return CommonResult.success(CommonPage.restPage(itemList));\n");
        sb.append("    }\n\n");

    }


    /**
     * @description 生成class的所有内容
     */
    private String makeMapper() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageMapperOutPath + ";\r\n");
        sb.append("import org.apache.ibatis.annotations.Insert;  \r\n");
        sb.append("import org.apache.ibatis.annotations.Update;  \r\n");
        sb.append("import org.springframework.stereotype.Component;  \r\n");
        sb.append("import com.mytool.farm.entity."+modelName+" ; \r\n");
        sb.append("import org.apache.ibatis.annotations.Select;\r\n");
        sb.append("import java.util.List;\r\n");
        sb.append("\r\n");

        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        // 实体部分

        sb.append("@Component\n");

        sb.append("public interface " + modelName + "Mapper" + "{\r\n\r\n");

        sb.append("\r\n");

        sb.append("int insert"+modelName +"("+modelName +" model);\r\n\r\n");
        sb.append("}\r\n");
        return sb.toString();
    }

    /**
     * @description 生成class的所有内容
     */
    private String makeService() {
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageServiceOutPath + ";\r\n\n");
        sb.append("import com.mytool.model."+modelName+" ; \r\n");
        sb.append("import java.util.List;\r\n");
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        sb.append("public interface " + modelName + "Service" + "{\r\n\r\n");
        processServiceMethed(sb);
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
        sb.append("import org.springframework.beans.factory.annotation.Autowired;\r\n");
        sb.append("import "+packageName+".service."+modelName+"Service ; \r\n");
        sb.append("import "+packageName+".mapper."+modelName+"Mapper ; \r\n");
        sb.append("import org.springframework.stereotype.Service;\r\n");
        sb.append("import java.util.List;\r\n");
        sb.append("import org.springframework.stereotype.Service;\r\n");
        // 注释部分
        sb.append("/**\r\n");
        sb.append(" * table name:  " + tableName + "\r\n");
        sb.append(" * author name: " + authorName + "\r\n");
        sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
        sb.append(" */ \r\n");
        sb.append("@Service\r\n");
        sb.append("public class " + modelName + "ServiceImpl  implements " +modelName+  "Service{\r\n\r\n");
        processServiceImplMethed(sb);
        sb.append("}\r\n");
        return sb.toString();
    }

    /**
     * @param sb
     * @description 生成所有成员变量及注释
     * @author paul
     * @version V1.0
     */
    private void processAllAttrs(StringBuffer sb) {
        for (int i = 0; i < colNames.length; i++) {
            if(colNamesComment.get(colNames[i])!=null &&!"".equals(colNamesComment.get(colNames[i]))) {
                sb.append("\t@ApiModelProperty(value = \""+colNamesComment.get(colNames[i])+"\")\r\n");
            }
            sb.append("\tprivate " + sqlType2JavaType(colTypes[i]) + " " + colNames[i] + ";\r\n");
        }
        sb.append("\tprivate static final long serialVersionUID = 1L;\r\n");
    }

    /**
     * 重写toString()方法
     * @param sb
     */
    private void processToString(StringBuffer sb) {
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
    }
    /**
     * 构造函数
     * @param sb
     */
    private void processConstructor(StringBuffer sb) {
        StringBuffer p = new StringBuffer();
        StringBuffer v = new StringBuffer();
        for(int i = 0; i < colNames.length; i++) {
            p.append(sqlType2JavaType(colTypes[i])+" "+colNames[i]);
            if(i!=colNames.length-1) {
                p.append(",");
            }
            v.append("\t\tthis."+colNames[i]+"="+colNames[i]+";\r\n");
        }
        //无参数构造函数
        sb.append("\tpublic "+under2camel(tableName,true)+"() {\r\n");
        sb.append("\t\tsuper();\r\n");
        sb.append("\t}\r\n");
        //带参构造函数
        sb.append("\tpublic "+under2camel(tableName,true)+"("+p.toString()+") {\r\n");
        sb.append(v.toString());
        sb.append("\t}\r\n");
    }

    /**
     * @param sb
     * @description 生成所有get/set方法
     */
    private void processAllMethod(StringBuffer sb) {
        for (int i = 0; i < colNames.length; i++) {
            sb.append("\tpublic void set" + initCap(colNames[i]) + "(" + sqlType2JavaType(colTypes[i]) + " "
                    + colNames[i] + "){\r\n");
            sb.append("\t\tthis." + colNames[i] + "=" + colNames[i] + ";\r\n");
            sb.append("\t}\r\n");
            sb.append("\tpublic " + sqlType2JavaType(colTypes[i]) + " get" + initCap(colNames[i]) + "(){\r\n");
            sb.append("\t\treturn " + colNames[i] + ";\r\n");
            sb.append("\t}\r\n");
        }
    }

    /**
     * @param sb
     * @description 生成所有get/set方法
     */
    private void processDaoMethed(StringBuffer sb) {


    }

    /**
     * @param sb
     * @description 生成所有get/set方法
     */
    private void processServiceMethed(StringBuffer sb) {

        sb.append("     int create("+modelName +" "+modelName2 +");\r\n\r\n");

        sb.append("     int update(Long id,"+modelName +" "+modelName2 +");\n\n");

        sb.append("     int delete(Long id);\n\n");

        sb.append("     "+modelName+" getItem(Long id);\n\n");

        sb.append("     /*page search list*/\n\n");

        sb.append("     List<"+modelName+"> list(Integer pageSize, Integer pageNum);\n\n");
    }

    /**
     * @param sb
     * @description 生成所有get/set方法
     */
    private void processServiceImplMethed(StringBuffer sb) {

        sb.append("@Autowired\r\n");
        sb.append(modelName +"Mapper "+modelName2+"Mapper ;\r\n\r\n");

        sb.append("@Autowired\r\n");
        sb.append("public int create("+modelName+" "+modelName2+") {\r\n");
        sb.append("     "+modelName2+".setCreateTime(new Date());\r\n");
        sb.append("     return "+modelName2+"Mapper.insert("+modelName2+");\r\n");
        sb.append("}\r\n");


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
     * 生成EntityHelper
     */
    private void EntityHelper() {
        String dirName = MySQLGeneratorEntityUtil.pkgModelDirName();
        String javaPath = dirName + "/EntityHelper.java";
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("package " + packageModelOutPath + ";\r\n");
            sb.append("\r\n");
            sb.append("public abstract class EntityHelper{\r\n\r\n");
            sb.append("\tpublic abstract String getPrimaryKey();\r\n");
            sb.append("\r\n");
            sb.append("}\r\n");
            FileWriter fw = new FileWriter(javaPath);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(sb.toString());
            pw.flush();
            if (pw != null){pw.close();}
            System.out.println("create class 【EntityHelper】");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
        if(needEntityHelper) {
            EntityHelper();
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
package com.sy.myweber;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class MybatisGenerator {
    /**
     * 生成文件所在项目路径
     */
    private static String baseProjectPath = "F:/IdeaProjects/myweber";
//	private static String baseProjectPath = "/Users/chengbin/IdeaProjects/wizarpos_cloud_server/wizarpos-core";
    /**
     * 静态文件所在项目路径
     */
    private static String viewProjectPath = "/src/main/resources/templates/view/";
    /**
     * 基本包名
     */
    private static String basePackage = "com.sy.myweber";
    /**
     * 作者
     */
    private static String authorName = "supersuger";
    /**
     * 要生成的表名
     */
    private static String[] tables = { "sys_role","sys_source","sys_source_role","sys_user_role"};
    /**
     * table前缀
     */
    private static String prefix = "";

    /**
     * 生成自定义文件(html文件)开关
     */
    private static Boolean htmlPage = false;
    private static File file = new File(basePackage);
    private static String path = file.getAbsolutePath();

    /**数据库配置四要素
     *
     */
    private static String driverName = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/testsm?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC&useSSL=false&nullCatalogMeansCurrent=true&serverTimezone=GMT%2B8";
    private static String username = "root";
    private static String password = "123456";


    private static TableInfo tableInfo = null;

    public static void main(String[] args) {
        doMpGen();
    }

    public static void doMpGen() {

        //生成静态文件夹 否则静态文件不能生成到指定文件夹
        if (htmlPage) {
            for (String table : tables) {
                File fff = new File(baseProjectPath + viewProjectPath + table.replaceAll("_", ""));
                if (!fff.exists()) {
                    fff.mkdirs();
                }
            }
        }

        // 代码生成器
        AutoGenerator gen = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(url);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        gen.setDataSource(dsc);

        // 全局配置
        gen.setGlobalConfig(new GlobalConfig()
                // 输出目录
                .setOutputDir(baseProjectPath + "/src/main/java/")
                // 是否覆盖文件
                .setFileOverride(true)
                // 开启 activeRecord 模式
                .setActiveRecord(true)
                // XML 二级缓存
                .setEnableCache(false)
                // XML ResultMap
                .setBaseResultMap(true)
                // XML columnList
                .setBaseColumnList(true)
                // 生成后打开文件夹
                .setOpen(false)
                .setAuthor(authorName)
                .setIdType(IdType.INPUT)
                // 自定义文件命名，注意 %s 会自动填充表实体属性！
                .setMapperName("%sDao").setXmlName("%sMapper").setServiceName("%sService")
                .setServiceImplName("%sServiceImpl").setControllerName("%sController"));

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // .setCapitalMode(true)// 全局大写命名
        // .setDbColumnUnderline(true)//全局下划线命名
        // 此处可以修改为您的表前缀
        strategy.setTablePrefix(new String[] { prefix })
                // 表名生成策略
                .setNaming(NamingStrategy.underline_to_camel)
                // 需要生成的表
                .setInclude(tables)
                .setRestControllerStyle(true)
                // 自定义实体父类
                // .setSuperEntityClass("com.wizarpos.cloud.core.data.BaseEntity")
                // 自定义实体，公共字段
                //.setSuperEntityColumns(new String[]{"id","createdTime","createdBy","updatedTime","updatedBy","version"})
                // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                .setEntityLombokModel(true)
                // Boolean类型字段是否移除is前缀处理
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setControllerMappingHyphenStyle(true);
        gen.setStrategy(strategy);

        // 包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        //模块名称，单独生成模块时使用！！！！！！！！！！！
        // packageConfig.setModuleName("User")
        // 自定义包路径
        packageConfig.setParent(basePackage);
        // 这里是控制器包名，默认 web
		packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("dao");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setXml("mapper");
        gen.setPackageInfo(packageConfig);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
        InjectionConfig abc = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<>(4);
                map.put("abc", "abc");
                this.setMap(map);
            }
        };
        gen.setCfg(abc);

        // 指定模板引擎 默认是VelocityTemplateEngine ，需要引入相关引擎依赖
        // gen.setTemplateEngine(new FreemarkerTemplateEngine());

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        // 自定义模板配置，模板可以参考源码 /mybatis-plus/src/main/resources/template 使用 copy
        // 至您项目 src/main/resources/template 目录下，模板名称也可自定义如下配置：
        templateConfig.setController("/templates/controller.java.vm");
        // 关闭默认 xml 生成，调整生成 至 根目录
        templateConfig.setXml("/templates/mapper.xml.vm");
        templateConfig.setEntity("/templates/entity.java.vm");
        templateConfig.setMapper("/templates/mapper.java.vm");
        templateConfig.setService("/templates/service.java.vm");
        templateConfig.setServiceImpl("/templates/serviceImpl.java.vm");
        // 模板配置
        gen.setTemplate(templateConfig);

        // 执行生成
        gen.execute();

        System.out.println("代码生成成功");
    }
}

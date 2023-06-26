项目部署说明:
1.项目基于  Maven 进行依赖管理
2.数据库    MySql5.7(8.0)  项目文件中有数据库结构yizhi_db.sql文件,创建库后导入即可
3.缓存模块  Redis 6.x
4.JDK 1.8  SpringBoot2.0

配置文件说明:
1.项目启动 默认加载 application-dev.yml
2.MySql Redis 连接配置修改

程序访问入口:
http://localhost:8080/index
平台登录帐号: admin 密码: 111111

模块:  学生管理模块
需要操作的类:   com.yizhi.student.controller.StudentInfoController
需要完成的功能:  学生信息的,list查询接口,save保存接口,update修改接口,删除接口

mybatis映射文件: 完善 mybits/student/StudentInfoMapper.xml

## 项目依赖库说明

- `spring-boot-starter`：Spring Boot 的核心依赖包，提供 Spring Boot 应用程序开发所需的基本配置和功能。
- `spring-boot-starter-web`：Spring Boot Web 开发依赖包，提供构建 Web 应用程序所需的相关库和配置。
- `mysql-connector-java`：MySQL 数据库 JDBC 驱动。
- `mybatis`：MyBatis 持久化框架。
- `mybatis-spring-boot-starter`：MyBatis Spring Boot 快速集成启动器。
- `druid`：阿里巴巴 Druid 数据库连接池。
- `commons-lang3`：Apache Commons Lang3 工具类库。
- `commons-configuration`：Apache Commons Configuration 配置读取和写入工具库。
- `commons-io`：Apache Commons IO 文件、流等操作工具库。
- `shiro-core`：Apache Shiro 权限认证和授权框架核心库。
- `shiro-spring`：Apache Shiro Spring Boot 快速集成启动器。
- `thymeleaf`：Thymeleaf 模板引擎。
- `ehcache`：Ehcache 缓存库。
- `quartz`：Quartz 定时任务调度库。
- `spring-boot-starter-websocket`：Spring WebSocket 模块快速集成启动器。
- `spring-context-support`：Spring 上下文支持库。
- `springfox-swagger2`：Swagger API 文档生成工具库。
- `springfox-swagger-ui`：Swagger UI 生成库。
- `knife4j-spring-boot-starter`：Knife4j Swagger UI 增强版快速集成启动器。
- `spring-boot-starter-data-redis`：Redis 缓存库。
- `jedis`：Redis 客户端库。
- `jsoup`：Jsoup HTML 解析库。
- `poi`：Apache POI Office 工具库。
- `kaptcha`：验证码生成库。
- `spring-boot-starter-amqp`：Spring AMQP 快速集成启动器。
- `lombok`：Java 实体类相关注解和方法自动生成工具库。
- `weixin-java-miniapp`：微信小程序 Java SDK。
- `avro`：Apache Avro 序列化库。
- `oshi-core`：OSHI 系统监控库。
- `spring-boot-starter-tomcat`：Spring Boot 内嵌 Tomcat 容器快速集成启动器。
- `bcprov-jdk15on`：Bouncy Castle 密码学库。
- `jjwt`：JSON Web Token 实现库。
- `emoji-java`：Emoji 处理工具库。
- `thumbnailator`：Java 图片缩略图库。
- `spring-boot-starter-freemarker`：Spring Freemarker 模板引擎快速集成启动器。
- `freemarker`：Freemarker 模板引擎。

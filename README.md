## 1.环境说明:

* JDK 8
* mysql 5.7/(8.x)+  项目文件中有数据库结构yizhi_db.sql文件,创建库后导入即可
* Redis 6.x +
* Maven 3.6 +
* 数据库脚本在项目中

配置文件说明:

1.项目启动 默认加载 application-dev.yml
2.MySql , Redis 连接配置需要修改为你本地连接

程序访问入口:

http://localhost:8080/index
平台登录帐号: admin 密码: 111111



## 2.项目依赖库说明

拿到一个新项目我一般是先看pom文件，主要是看用到了什么技术

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

所以对于学生管理模块模块功能的增删改查我们使用mybatis即可。



## 2.统一返回处理类R

- 操作成功code返回0

```json
{
    code: 0,
    msg: "操作成功消息"
}
```

- 操作失败code返回其他（如500）

```json
{
    code: 500,
    msg: "操作失败消息"
}
```



## 3.新增工具类

src/main/java/com/yizhi/common/utils/IdCardUtil.java 判断身份证合法性
src/main/java/com/yizhi/common/utils/PhoneUtil.java 判断手机号合法性



## 4.报错总结

- SQL导入
  - 导入报错，原因是mysql版本是5.6没有utf8mb4字符集
    - 解决方法替换为utf8mb3



- 分页查询

  - currPage和pagesize类型为String，在Mybatis中类型报错
    - 解决方法1：在controller中修改了currPage和pagesize的类型为Integer
    - 解决方法2：在xml配置中指定类型，（我这里配置不行）
  - 条件查询其他有部分内容未填写转化成空字符串
    - 解决方法：在查询条件中添加空字符串判断

- 新增学生

  - Post请求没有请求到服务器，返回400错误
    - 解决方法：
  
  

## 5.改进建议

1.批量删除可以使用Async异步处理

2.

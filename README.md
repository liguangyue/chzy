

前期准备
在idea安装lombok插件
在idea安装MybatisX Plugin插件(选装)
准备好数据库5.7+或8.0.14+
初始化数据库
脚本路径：根目录 mallcloud.sql
准备好Redis
准备好注册中心Nacos
启动命令地址：mall-register\nacos\bin
Linux/Unix/Mac
启动命令(standalone代表着单机模式运行，非集群模式):
sh startup.sh -m standalone
Windows
启动命令：
cmd startup.cmd
或者双击startup.cmd运行文件
修改mall-config/src/main/resources/application-dev.properties里面的配置参数
数据库配置
redis配置
elasticsearch配置
非必须，如果不启用日志功能可不管
sentinel配置
非必须，主要是用于展示应用吞吐量
修改每个工程的bootstrap.yml文件里的nacos地址参数，如nacos是在本机启动的话就改为以下地址
mall:
nacos:
 server-addr: 127.0.0.1:8848

项目启动：

启动认证中心mall-uaa
启动用户中心mall-bussiness/user-center
启动网关mall-gateway/zuul-gateway
下面是业务模块，不一定需要全部启动
启动订单中心mall-bussiness/order-center
启动会员中心mall-bussiness/member-center
启动商品中心mall-bussiness/goods-center
启动营销中心mall-bussiness/marking-center
启动内容中心mall-bussiness/cms-center
启动前端工程： 解压跟目录的mallcloud-admin-vue.zip,为后台管理的vue前端，
需要安装nodejs环境，然后进入此目录，npm install ,成功后执行 npm run dev

模块介绍

1.文件中心 工程目录：mall-business/file-center 需要搭配云平台的oss，修改application.yml的oss相关配置 启动file-center


2.微服务应用监控 工程目录：mall-monitor/sc-admin 启动sc-admin


3.统一配置中心 详情请看 alibaba/nacos部署使用详解 在Nacos里添加公共配置或者项目的配置 本项目的配置虽然对接了nacos但是并不依赖它，可以使用nacos统一管理配置，在nacos添加的配置会覆盖本地的配置


4.统一日志中心 工程目录：mall-monitor/log-center 启动log-center 需要自行部署ELK+Filebeat，具体搭建请查看 统一日志中心详解 并结构化日志数据为以下格式存在ES中 { "timestamp": "时间", "message": "具体日志信息", "threadName": "线程名", "serverPort": "服务端口", "serverIp": "服务ip", "logLevel": "日志级别", "appName": "工程名称", "classname": "类名" }


5.慢查询sql 工程目录：mall-monitor/log-center 启动log-center 需要自行部署ELK+Filebeat，具体搭建请查看 统一日志中心详解 和 慢查询sql详解 并结构化日志数据为以下格式存在ES中 { "id": "id", "timestamp": "时间", "query_str": "查询语句", "user": "数据库登录账号", "clientip": "客户端ip", "query_time": "查询时间", "lock_time": "锁等待时间", "rows_sent": "返回行数", "rows_examined": "优化器扫描行数" }


6.分布式任务调度 工程目录 mall-job/job-admin：任务中心的控制台 mall-job/job-executor-samples：任务的执行器例子 启动job-admin和job-executor-samples 访问地址 http://localhost:8081/


7.服务限流、降级熔断控制台和应用吞吐量监控 服务降级功能自动开启的，具体使用方法和hystrix一样在FeignClient里添加fallback参数就可以了 可以参考：com.central.common.feign.UserService 启动 Sentinel 控制台 具体详情请查看 sentinel部署使用详解


8.APM监控 具体详情请查看 APM监控-SkyWalking，提供以下主要功能：

9.分布式追踪和上下文传输 应用、实例、服务性能指标分析 根源分析 应用拓扑分析 应用和服务依赖分析 慢服务检测 性能优化
10.分布式事务(tx-lcn) 初始化TxManager的数据
11.修改TxManager的配置 工程目录：mall-transaction\txlcn-tm，修改nacos、数据库和redis 启动TxManager(事务管理器) 工程目录：mall-transaction\txlcn-tm

1.mallplus技术介绍
前言
mallplus项目致力于打造一个完整的电商系统，采用现阶段流行技术实现。
项目介绍
mallplus项目是一套电商系统，包括前台商城系统及后台管理系统，小程序，h5，基于SpringBoot+MyBatis实现。
前台商城系统包含首页门户、商品推荐、商品搜索、商品展示、购物车、订单流程、会员中心、客户服务、帮助中心等模块。
后台管理系统包含商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、财务管理、权限管理、代码生成设置等模块。
后端技术
技术	说明	官网
https://github.com/macrozheng/mall
Spring Boot | 容器+MVC框架 | https://spring.io/projects/spring-boot
Spring Security | 认证和授权框架 | https://spring.io/projects/spring-security
MyBatis | ORM框架 | http://www.mybatis.org/mybatis-3/zh/index.html
MyBatisGenerator | 数据层代码生成 | http://www.mybatis.org/generator/index.html
PageHelper | MyBatis物理分页插件 | http://git.oschina.net/free/Mybatis_PageHelper
Swagger-UI | 文档生产工具 | https://github.com/swagger-api/swagger-ui
Hibernator-Validator | 验证框架 | http://hibernate.org/validator/
Elasticsearch | 搜索引擎 | https://github.com/elastic/elasticsearch
RabbitMq | 消息队列 | https://www.rabbitmq.com/
Redis | 分布式缓存 | https://redis.io/
MongoDb | NoSql数据库 | https://www.mongodb.com/
Docker | 应用容器引擎 | https://www.docker.com/
Druid | 数据库连接池 | https://github.com/alibaba/druid
OSS | 对象存储 | https://github.com/aliyun/aliyun-oss-java-sdk
JWT | JWT登录支持 | https://github.com/jwtk/jjwt
LogStash | 日志收集 | https://github.com/logstash/logstash-logback-encoder
Lombok | 简化对象封装工具 | https://github.com/rzwitserloot/lombok
前端技术
技术	说明	官网
Vue	前端框架	https://vuejs.org/
Vue-router	路由框架	https://router.vuejs.org/
Vuex	全局状态管理框架	https://vuex.vuejs.org/
Element	前端UI框架	https://element.eleme.io/
Axios	前端HTTP框架	https://github.com/axios/axios
v-charts	基于Echarts的图表框架	https://v-charts.js.org/
Js-cookie	cookie管理工具	https://github.com/js-cookie/js-cookie
nprogress	进度条控件	https://github.com/rstacruz/nprogress
环境搭建
开发工具
工具	说明	官网
IDEA	开发IDE	https://www.jetbrains.com/idea/download
RedisDesktop	redis客户端连接工具	https://redisdesktop.com/download
Robomongo	mongo客户端连接工具	https://robomongo.org/download
SwitchHosts	本地host管理	https://oldj.github.io/SwitchHosts/
X-shell	Linux远程连接工具	http://www.netsarang.com/download/software.html
Navicat	数据库连接工具	http://www.formysql.com/xiazai.html
PowerDesigner	数据库设计工具	http://powerdesigner.de/
Axure	原型设计工具	https://www.axure.com/
MindMaster	思维导图设计工具	http://www.edrawsoft.cn/mindmaster
ScreenToGif	gif录制工具	https://www.screentogif.com/
ProcessOn	流程图绘制工具	https://www.processon.com/
PicPick	屏幕取色工具	https://picpick.app/zh/
开发环境
工具	版本号	下载
JDK	1.8	https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
Mysql	5.7	https://www.mysql.com/
Redis	3.2	https://redis.io/download
Elasticsearch	2.4.6	https://www.elastic.co/downloads
MongoDb	3.2	https://www.mongodb.com/download-center
RabbitMq	5.25	http://www.rabbitmq.com/download.html
nginx	1.10	http://nginx.org/en/download.html

2.mallplus本地部署

搭建步骤
本地环境搭建
本地安装开发环境中的所有工具并启动，具体参考
需要安装lombok 插件 启动redis
安装最新的数据库mallplus.sql，解压 前端vue mallplsu-admin-web.zip
克隆源代码到本地，使用IDEA或Eclipse打开，并完成编译;
启动mall-admin项目：直接运行com.zscat.mallplus.MallAdminApplication的main方法即可，
接口文档地址：http://localhost:8080/swagger-ui.html;
启动mall-search项目：直接运行com.zscat.mallplus.search.MallSearchApplication的main方法即可，
接口文档地址：http://localhost:8081/swagger-ui.html;
启动mall-portal项目：直接运行com.zscat.mallplus.portal.MallPortalApplication的main方法即可，
接口文档地址：http://localhost:8085/swagger-ui.html;
下载群文件uniapp项目 uni-app 是一个使用 Vue.js 开发跨平台应用的前端框架，开发者编写一套代码，可编译到iOS、Android、H5、小程序等多个平台。需要下载开发工具https://uniapp.dcloud.io/
https://uniapp.dcloud.io/quickstart
3.linux部署
. 项目地址 https://gitee.com/zscat/mallplus
1.后台springboot 项目 打成jar包
2.后台vue项目build为静态文件 npm run build
3.uniapp 微信小程序打包 打开hbuildx工具，选择菜单 发行-小程序微信
版，然后在打开的微信小程序开发工具中点击上传
4.uniapp h5打包 打开hbuildx工具，选择菜单 发行-网站h5手机版
输出框 项目 'uniapp'导出h5成功，路径为：F:/code/uniapp/unpackage/dist/build/h5 然后
后把生成的h5目录 挂载到nginx，如下图
1.项目路径，可以改为自己的路径

后台启动命令
nohup java -jar /root/jm/mall-portal-0.0.1-SNAPSHOT.jar >web.log 2>&1 &
nohup java -jar /root/jm/mall-admin-0.0.1-SNAPSHOT.jar >admin.log 2>&1 &
1.nginx配置
#user nobody;
worker_processes 1;
#error_log logs/error.log;
#error_log logs/error.log notice;
#error_log logs/error.log info;
#pid logs/nginx.pid;
events {
worker_connections 1024;
}
http {
include mime.types;
default_type application/octet-stream;
sendfile on;
#tcp_nopush on;
#keepalive_timeout  0;
keepalive_timeout  65;

#gzip  on;

server {
    listen       8090;
    server_name  39.106.212.32;
    #charset koi8-r;
    #access_log  logs/host.access.log  main;
    location / {
    root /root/jm/dist;
   index index.html;
  }
    #error_page  404              /404.html;

    # redirect server error pages to the static page /50x.html
    #
    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   html;
    }}
server {
listen 8082;
server_name _;
root /root/jm/h5;
index index.html;}
}
4.商户入驻
1.登录

2.商户入驻

创建商户的时候会创建一个有所有权限的账号，
账号为店铺名，此账号不能删除，
SELECT * from sys_user ;
SELECT * from sys_store;
然后登录时候的会把登录账store_id注入到MybatisPlusConfig，
此后所有的sql查询都会带上参数
FROM sys_user WHERE sys_user.store_id = 13 AND id = 28
store_id) VALUES (?, ?, ?, ?, ?, ?, ?, 13)
5.权限配置
1.后台管理接口上面都有个注解 @PreAuthorize("hasAuthority('sys:SysPermission:read')")
如果去掉注解，这个接口就不需要任何权限都可以访问；
2.如果有注解，则需要在权限表的value字段添加对应的值，uri代码路由，在前端vue页面配置

1.可以先在菜单管理添加数据
2.然后在角色管理添加角色，并设置权限
3.在用户管理添加用户，并设置角色

模块说明
mallcloud -- 父项目，公共依赖
│  ├─mall-business -- 业务模块一级工程
│  │  ├─user-center -- 用户中心[7000]
│  │  ├─file-center -- 文件中心[5000]
│  │  ├─member-center -- 会员中心[7001]
│  │  ├─goods-center -- 商品中心[7002]
│  │  ├─order-center -- 订单中心[7003]
│  │  ├─marking-center -- 营销中心[7004]
│  │─mall-commons -- 通用工具一级工程
│  │  ├─mall-auth-client-spring-boot-starter -- 封装spring security client端的通用操作逻辑
│  │  ├─mall-common-spring-boot-starter -- 封装通用操作逻辑
│  │  ├─mall-db-spring-boot-starter -- 封装数据库通用操作逻辑
│  │  ├─mall-log-spring-boot-starter -- 封装log通用操作逻辑
│  │  ├─mall-redis-spring-boot-starter -- 封装Redis通用操作逻辑
│  │  ├─mall-ribbon-spring-boot-starter -- 封装Ribbon和Feign的通用操作逻辑
│  │  ├─mall-sentinel-spring-boot-starter -- 封装Sentinel的通用操作逻辑
│  │  ├─mall-swagger2-spring-boot-starter -- 封装Swagger通用操作逻辑
│  ├─mall-config -- 配置中心
│  ├─mall-doc -- 项目文档
│  ├─mall-gateway -- api网关一级工程
│  │  ├─zuul-gateway -- netflix-zuul[8080]
│  ├─mall-job -- 分布式任务调度一级工程
│  │  ├─job-admin -- 任务管理器[8081]
│  │  ├─job-core -- 任务调度核心代码
│  │  ├─job-executor-samples -- 任务执行者executor样例[8082]
│  ├─mall-monitor -- 监控一级工程
│  │  ├─sc-admin -- 应用监控[6500]
│  │  ├─log-center -- 日志中心[6200]
│  ├─mall-uaa -- spring-security认证中心[8000]
│  ├─mall-register -- 注册中心Nacos[8848]
│  ├─mall-web -- 前端一级工程
│  │  ├─back-web -- 后台前端[8066]
│  ├─mall-transaction -- 事务一级工程
│  │  ├─txlcn-tm -- tx-lcn事务管理器[7970]
│  ├─mall-demo -- demo一级工程
│  │  ├─txlcn-demo -- txlcn的demo
│  │  ├─sharding-jdbc-demo -- sharding-jdbc的demo

演示地址
url： http://www.yjlive.cn:8090/#/login 
h5演示 http://www.yjlive.cn:8082 
账号密码：admin/admin
应用监控账号密码：admin/admin
配置中心账号密码：nacos/nacos
APM监控账号密码：admin/admin
Grafana账号：mall/mall
txlcn事务管理器密码：admin
任务管理账号密码：admin/123456
https://gitee.com/zscat/mallplus/wikis/pages/preview?sort_id=1609360&doc_id=326093

开发工具
1.redis 
2.Mysql
3.Mq
4.Nacos  sh startup.sh -m standalone
5.Elasticsearch /usr/local/elasticsearch/bin ./elasticesrarch -d
6.Sentinel java -jar sentinel-dashboard-1.4.0.jar --server.port=8888

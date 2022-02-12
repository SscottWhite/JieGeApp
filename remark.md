0, 对应依赖看xml
1, swagger 丝袜哥 , 添加swaggerconfig, 对应main类添加注解  -- 查看地址 http://localhost:8080/swagger-ui.html#
2, log  @Slf4j  添加logback-spring.xml和 yml相应配置  -- 日志记录看xml里的对应目录
3, jsp  添加资源文件夹webapp, yml相应配置
4, 用Druid池 连接mysql , 在yml中配置相应数据库数据    --选择最简单的springboot配置，省去了config
5, 用mybaits访问mysql  添加mapper,service等进行测试  --选择springBoot-mybatis连接， 配置yml
6, 在tool里面添加一些通用工具类
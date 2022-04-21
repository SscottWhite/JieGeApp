0, 对应依赖看xml
1, swagger 丝袜哥 , 添加swaggerconfig, 对应main类添加注解    -- 查看地址 http://localhost:8080/swagger-ui.html#
2, log  @Slf4j  添加logback-spring.xml和yml相应配置        -- 日志记录看xml里的对应目录
3, jsp  添加资源文件夹webapp, yml相应配置 编写jsp代码        -- 主要是登陆，跳转页面，等  -- 就当是复习一下jsp吧，最终我还是决定舍弃
4, 用Druid池 连接mysql , 在yml中配置相应数据库数据           -- 选择最简单的springboot配置，省去了config
5, 用mybaits访问mysql  添加mapper,service等进行测试         -- 选择springBoot-mybatis连接， 配置yml
6, 在tool里面添加一些通用工具类
7, 加入最简单的事务注解
8, 加入简单的pagehelper，注意包裹搜索                     -- 由于是在外层包裹limit, 所以要注意性能, 过万搜索估计有影响
9, 权限处理，单点登录， 加入cookie, 加入servlet, filter   -- 权限方面还是用security,切合spring
10, 加入任务管理器 Quartz                                -- 1:sql表  2:配置文件  3:配置类  4:全局属性配置  5:代码中加入运行方法
11, 拆分application分布, 条理更清晰                      --  -jdbc, -quartz
12, 理解权限验证框架security + jwt 
	12.1  通过配置securityConfig  其中包括很多情况的处理类, 
	12.2 简单的, 我们按着顺序看   
		1 先从登陆开始 -> 直接拦截到SecurityConfig里, 
		2 点击登录后 -> 在userAuthenticationProvider捕捉和验证登陆者信息 --> 在里面封装好一个用户类  --如果不加jwt, 其实这里就省了还原数据的过程
		3 上面的捕捉会产生数据 -> 成功责备成功的handler捕捉, 失败报错则被失败登陆的handler捕捉, 
		  3.1 成功的handler会返回新的token, 以便刷新时间  
		  3.2 失败的handler会根据报错信息返回一些内容
13, 在securityConfig中可以看到在User...Provider中 返回的User...Token
	而在JWT的拦截类 JWT...Filter中也返回 User...Token, 所以是先拦截这个, 返回数据, 就不需要再重新验证了
# JieGeApp
男神：杰哥、阿伟

1: 关闭SpringSecurity 只有在启动类里加上(exclude = SecurityAutoConfiguration.class)
    同时,在配置类上面把@EnableWebSecurity也注释掉, 因为springboot的sercurity里面自带@EnableWebSecurity,必须同时去掉
2: 关闭quartz: 首先要关闭sql, 其次再注释掉相关的类注解

2023.11.22
1: interceptor 拦截器和 filter 过滤器互不干涉, 有顺序
https://www.cnblogs.com/yangyongjie/p/15798410.html

  filter init
  filter doFilter
  interceptor preHandle
  aop start
  hello controller
  aop end
  interceptor postHandle
  interceptor afterCompletion



202410
1 Guava: https://mp.weixin.qq.com/s/_6GSMN346qMaShwjKN0qig
2 ItextPdf: https://mp.weixin.qq.com/s/FKGqjZaV66NJFHbXE5ROiA
            https://mp.weixin.qq.com/s/x9AriZPem6lQwuytNFNBBg 不好用
3 Jasypt: 数据库加密
4 Schild:  https://mp.weixin.qq.com/s?__biz=MzI1NDY0MTkzNQ==&mid=2247508701&idx=1&sn=abaa3740c8ede32c46e933145fa4ee69&chksm=e8627b4ce6c2fbe66386d0bb50d6364e2612e77204118f4608bf0c43f819dc69519ee218e3d2&scene=90&xtrack=1&sessionid=1726627926&subscene=93&clicktime=1726627928&enterid=1726627928&flutter_pos=0&biz_enter_id=4&ranksessionid=1726625223&ascene=56&devicetype=iOS17.6.1&version=1800332c&nettype=WIFI&abtest_cookie=AAACAA%3D%3D&lang=zh_CN&countrycode=CN&fontScale=100&exportkey=n_ChQIAhIQGFJFzcQ5w%2BRC1gf0L45WshLZAQIE97dBBAEAAAAAAAyUBlkDZKQAAAAOpnltbLcz9gKNyK89dVj0CquMDo0ABbMe7ZVd09IRor508KGl3scB25M41J3RvoRefFdhLmFg3gwjCK4MDjk1sagz5m4PwajgOptl6egynxMw71OPSQGlnruHEqvUktY37vueLByDNzTNMO5WPXuu0UHR8AFKrqfdgWudSqLSkUAqJ9%2Bt6jjM%2BHOtdMeTdz%2FhGH71OSEDGe2uS7srrM0dO48Aby6At6RsRvuu7FFu%2BdfZNU3dMdQlNeGA3XqTPzvS0No%3D&pass_ticket=mHxHNa5nLARMnXfCEH0SwQqrnWFjwO4tRuFBeifvHakNVQAW%2Bfw%2FIciQLR8xIh5l&wx_header=3
5 TiKa: https://juejin.cn/post/7252159509848899640
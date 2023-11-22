# JieGeApp
男神：杰哥、阿伟

1: 关闭SpringSecurity 只要把Security里面的代码注释掉就行
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

2: 
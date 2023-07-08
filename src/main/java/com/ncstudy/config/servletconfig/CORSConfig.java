package com.ncstudy.config.servletconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//本地跨域请求直接用这个,  如果用@CrossOrigin, 还要考虑在response里面加入header
@Configuration
public class CORSConfig implements WebMvcConfigurer {

    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOrigins("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 设置允许的header属性
                .allowedHeaders("*");
                // 跨域允许时间
//              .maxAge(3600);
    }
}

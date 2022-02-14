package com.ncstudy.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ncstudy.servlet.MyServlet;

@Configuration //该注解将此类定义为一个配置类（相当于一个xml配置文件）
public class ServletConfig {
 
    /**
     * @Bean 是一个方法级别上的注解，主要用在配置类里
     * 相当于一个 <beans>
     *              <bean id="..." class="..." />
     *          </beans>
     * @return
     */
    @Bean
    public ServletRegistrationBean myServletRegistrationBean() {
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(
                new MyServlet(),
              //  new ImageServlet(),
                "/*"
        );
        return servletRegistrationBean;
    }
}
package com.ncstudy.config.datasourceconfig;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;
import com.ncstudy.toolutils.DES3;

//@Component
public class CustomBeanPostProcessor extends ConfigurationClassPostProcessor implements  BeanPostProcessor  {
 
	@Autowired
    private ConfigurableListableBeanFactory  beanFactory;
 
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        super.postProcessBeanFactory(beanFactory);
        this.beanFactory=beanFactory;
    }
 
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    	
        DruidDataSource druidDataSourceOne = (DruidDataSource) beanFactory.getBean("dataSourceOne");
        
        druidDataSourceOne.setUsername(DES3.decryptThreeDESECB(druidDataSourceOne.getUsername(),DES3.DES3KEY));
        druidDataSourceOne.setPassword(DES3.decryptThreeDESECB(druidDataSourceOne.getPassword(),DES3.DES3KEY));
        
        return bean;
    }
}

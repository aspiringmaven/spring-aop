package me.sumitkawatra.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InitHook implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//System.out.println(beanName + " ...created !!!");
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		//System.out.println(beanName + " creation start...");
		return bean;
	}

}

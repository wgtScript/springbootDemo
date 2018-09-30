package com.kfit.test.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 普通类调用Spring bean对象：
 * 说明：
 *  不在 Spring Boot 的扫描包下方式一
 * @author Administrator
 */
@Component
public class SpringUtil2  implements ApplicationContextAware{
	private static ApplicationContext applicationContext = null;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(SpringUtil2.applicationContext == null){
			SpringUtil2.applicationContext = applicationContext;
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("---------------com.kfit.base.util.SpringUtil2------------------------------------------------------");
		System.out.println("========ApplicationContext配置成功,在普通类可以通过调用SpringUtils.getAppContext()获取applicationContext对象,applicationContext="+SpringUtil2.applicationContext+"========");
		System.out.println("---------------------------------------------------------------------");
	}
	//获取applicationContext
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	//通过name获取 Bean.
	public static Object getBean(String name){
		return getApplicationContext().getBean(name);
	}
	//通过class获取Bean.
	public static <T> T getBean(Class<T> clazz){
		return getApplicationContext().getBean(clazz);
	}
	//通过name,以及Clazz返回指定的Bean
	public static <T> T getBean(String name,Class<T> clazz){
		return getApplicationContext().getBean(name, clazz);
	}
}



package com.kfit.test.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 主要是@Configuration，实现接口：EnvironmentAware就能获取到系统环境信息;
 *
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@Configuration
public class MyEnvironmentAware implements EnvironmentAware {

	// 注入application.properties的属性到指定变量中.
	@Value("${spring.datasource.url}")
	private String myUrl;

	/**
	 * 注意重写的方法 setEnvironment 是在系统启动的时候被执行。
	 */
	@Override
	public void setEnvironment(Environment environment) {
		System.out.println("**********************MyEnvironmentAware********************************");
		System.out.println("************************************************************************");
		// 打印注入的属性信息.
		System.out.println("myUrl=" + myUrl);
		// 通过 environment 获取到系统属性.
		System.out.println(environment.getProperty("JAVA_HOME"));
		// 通过 environment 同样能获取到application.properties配置的属性.
		System.out.println(environment.getProperty("spring.datasource.url"));
		System.out.println("************************************************************************");
		// 获取到前缀是"spring.datasource." 的属性列表值.
//		RelaxedPropertyResolver relaxedPropertyResolver = new RelaxedPropertyResolver(environment,
//				"spring.datasource.");
//		System.out.println("spring.datasource.url=" + relaxedPropertyResolver.getProperty("url"));
//		System.out
//				.println("spring.datasource.driverClassName=" + relaxedPropertyResolver.getProperty("driverClassName"));
	}
}

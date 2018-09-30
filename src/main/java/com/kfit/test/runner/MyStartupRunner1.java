package com.kfit.test.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
* 服务启动执行
*使用@Order 注解来定义执行顺序。
* @author Angel(QQ:412887952)
*/
@Component
@Order(value=1)
public class MyStartupRunner1 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>>服务启动执行，执行加载数据等操作，这里值为1，小的先执行 <<<<");
	}

}

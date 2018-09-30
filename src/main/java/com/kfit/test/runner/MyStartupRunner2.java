package com.kfit.test.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
* 服务启动执行
*
* @author Angel(QQ:412887952)
*/
@Component
@Order(value=2)
public class MyStartupRunner2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(">>>>服务启动执行，执行加载数据等操作，这里@Order(value=2)值为2，大的后执行 <<<<");
	}

}

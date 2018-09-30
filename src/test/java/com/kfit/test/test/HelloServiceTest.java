package com.kfit.test.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kfit.test.web.DemoController;

////SpringJUnit支持，由此引入Spring-Test框架支持！
@RunWith(SpringJUnit4ClassRunner.class)
//// 指定我们SpringBoot工程的Application启动类
// @SpringApplicationConfiguration(classes = DemoController.class) 新版的包已不用
@SpringBootTest(classes = DemoController.class)
/// 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class HelloServiceTest {
	@Resource
	private HelloService helloService;

	@Test
	public void testGetName() {
		System.out.println(666);
		Assert.assertEquals("hello", helloService.getName());
	}
}

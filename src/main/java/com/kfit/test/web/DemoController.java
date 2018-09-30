package com.kfit.test.web;

import javax.annotation.Resource;
import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.kfit.test.base.properties.WiselySettings;
import com.kfit.test.bean.Demo;
import com.kfit.test.service.DemoService;

@SpringBootApplication
@RestController
@RequestMapping("/demo")
@ComponentScan(basePackages = { "com.kfit.test" })
@EnableJpaRepositories("com.kfit.test.dao")
@EntityScan("com.kfit.test.bean")
@ServletComponentScan("com.kfit.test.base.servlet")
@EnableConfigurationProperties({ WiselySettings.class })
public class DemoController {
	@Resource
	private DemoService demoService;

	@RequestMapping("/test")
	public @ResponseBody String test(){
		Demo loaded = demoService.findById(1);
		System.out.println("loaded="+loaded);
		Demo cached = demoService.findById(1);
		System.out.println("cached="+cached);
		loaded = demoService.findById(2);
		System.out.println("loaded2="+loaded);
		return"ok";
	}
	@RequestMapping("/delete")
	public@ResponseBody String delete(long id){
		demoService.deleteFromCache(id);
		return"ok";
	}
	@RequestMapping("/test1")
	public@ResponseBody String test1(){
		demoService.test();
		System.out.println("DemoInfoController.test1()");
		return"ok";
	}


	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//// 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
		factory.setMaxFileSize("128KB"); // KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("256KB");
		// Sets the directory location where files will be stored.
		// factory.setLocation("路径地址");
		return factory.createMultipartConfig();
	}

	@RequestMapping("/getDemo")
	public Demo getDemo() {
		Demo demo = new Demo();
		demo.setAge(18);
		demo.setName("小芳");

		return demo;
	}

	@RequestMapping("/getFastJson")
	public String getFastJson() {
		Demo demo = new Demo();
		demo.setAge(2);
		demo.setName("Angel2");
		return JSONObject.toJSONString(demo);
	}

	/**
	 * 测试保存数据方法.
	 * 
	 * @return
	 */
	@RequestMapping("/save")
	public String save() {
		Demo d = new Demo();
		d.setName("Angel");
		demoService.save(d);// 保存数据.
		return "ok.Demo2Controller.save";
	}

	@RequestMapping("/getByAge")
	public Demo getByAge(long age) {
		return demoService.getByAge(age);
	}

	@RequestMapping("/zeroException")
	public int zeroException() {
		return 100 / 0;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoController.class, args);
	}
}

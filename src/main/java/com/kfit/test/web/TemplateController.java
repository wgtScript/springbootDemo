package com.kfit.test.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 模板测试.
 * 
 * @author Administrator
 *
 */
@Controller
public class TemplateController {
	/**
	 * 返回 Thymeleaf   的  html模板.
	 */
	@RequestMapping("/helloHtml")
	public String helloHtml(Map<String, Object> map) {
		map.put("hello", "from TemplateController.helloHtml");
		return "/helloHtml";
	}
	@RequestMapping("/")
	public String index(Map<String, Object> map) {
		System.out.println(6666);
		return "/index";
	}
	/**
	 * 返回  ftl  的  html模板.
	 */
	@RequestMapping("/helloFtl")
	public String helloFtl(Map<String, Object> map) {
		map.put("hello", "from TemplateController.helloFtl");
		List<Map> list= new ArrayList();
		Map tempMap=new HashMap();
		Map tempMap2=new HashMap();
		Map tempMap3=new HashMap();
		Map tempMap4=new HashMap();
		tempMap.put("name", "wgt1");
		list.add(tempMap);
		System.out.println(list);
		tempMap2.put("name", "wgt2");
		System.out.println(list);
		list.add(tempMap2);
		System.out.println(list);
		tempMap3.put("name", "wgt3");
		list.add(tempMap3);
		System.out.println(list);
		tempMap4.put("name", "wgt4");
		list.add(tempMap4);
		map.put("test",list);
		System.out.println(map);
		return "/helloFtl";
	}
}

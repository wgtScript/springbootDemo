package com.kfit.test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kfit.test.base.properties.WiselySettings;

@RestController// 标记为：restful
public class HelloControoler {
	@Autowired
	WiselySettings wiselySettings;
	@RequestMapping("/test")
	public @ResponseBody String test(){
		String str=wiselySettings.getGender()+"---"+wiselySettings.getName();
		System.out.println(str);
		return str;
	}
}

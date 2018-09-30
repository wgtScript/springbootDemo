package com.kfit.test.base.scheduling;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulingConfig {

	@Scheduled(cron="0 30 * * * ?") // 每30分钟执行一次
	public void scheduling() {
		System.out.println(new Date()+"   >>>>>半个钟过去了，请注意休息");
	}

	
	
	public static void main(String args[]){
        String str = "﻿abc";
        System.out.println(str.substring(0,1));
    }
}

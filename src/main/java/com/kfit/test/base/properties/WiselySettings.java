package com.kfit.test.base.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
@Configuration
@ConfigurationProperties(prefix = "wisely")
@PropertySource("classpath:config/wisely.properties")
public class WiselySettings {
	private String name;
	private String gender;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "WiselySettings [name=" + name + ", gender=" + gender + "]";
	}

	public WiselySettings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WiselySettings(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}

}

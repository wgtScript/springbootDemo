package com.kfit.test.dao;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kfit.test.bean.Demo;
@Repository
public class DemoDao {
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public Demo getByAge(long age) {
		String sql="select * from Demo where age=?";
		RowMapper<Demo> rowMapper=new BeanPropertyRowMapper<Demo>(Demo.class);
		return jdbcTemplate.queryForObject(sql,rowMapper, age);
	}
}

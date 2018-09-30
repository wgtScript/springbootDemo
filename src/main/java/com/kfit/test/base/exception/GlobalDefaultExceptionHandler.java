package com.kfit.test.base.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@SpringBootApplication
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(value=Exception.class)
	public void defalutErrorHandler(HttpServletRequest request,Exception e) {
		System.out.println("报错了："+e);
	}
}

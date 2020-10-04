/*
 * 	주제(Subject): Proxy, InvocationHandler로 3단계 관점 프로그래밍
 * 	파일명(Filename): Controller.java
 * 	제작일자(Create Date): 2020-10-04
 * 	설명(Description):
 * 		JSP/Servlet 버전으로 작성함
 */
package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	
}

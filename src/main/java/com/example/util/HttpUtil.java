/*
 * 	주제(Subject): Proxy, InvocationHandler로 3단계 관점 프로그래밍
 * 	파일명(Filename): HttpUtil.java
 * 	제작일자(Create Date): 2020-10-04
 * 	설명(Description):
 *   
 * 
 */
package com.example.util;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public static void forward(HttpServletRequest req, HttpServletResponse res,
			String path) throws ServletException, IOException {

		try {
			RequestDispatcher dispatcher = req.getRequestDispatcher(path);
			dispatcher.forward(req, res);

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
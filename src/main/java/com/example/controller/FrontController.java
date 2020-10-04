/*
 * 	주제(Subject): Proxy, InvocationHandler로 3단계 관점 프로그래밍
 * 	파일명(Filename): FrontController.java
 * 	제작일자(Create Date): 2020-10-04
 * 	설명(Description):
 * 
 */
package com.example.controller;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.Calculator;
import com.example.service.CalculatorImpl;
import com.example.util.HttpUtil;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String charset = null;
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doAction(req, res, "GET");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doAction(req, res, "POST");
	}

	protected void doAction(HttpServletRequest req, 
							HttpServletResponse res,
							String flag) 
									throws ServletException, IOException {
		
		ServletConfig sc = this.getServletConfig();
		charset = sc.getInitParameter("charset");

		req.setAttribute("charset", charset);
		req.setCharacterEncoding(charset);
		res.setContentType("text/html; charset=" + charset);

		String uri = req.getRequestURI();
		String conPath = req.getContextPath();
		String command = uri.substring(conPath.length());

		Controller subController = null;

		// GET 전송방식만
		if(command.equals("/board/write.do") &&
				flag.contentEquals("GET")) {
			
			System.out.println("write - page");
			//HttpUtil.forward(req, res, "/WEB-INF/views/board/insert.jsp");
			
		}
		// POST 전송방식만
		else if(command.equals("/board/write_result.do") && 
				flag.contentEquals("POST")){
			
		}
		else if (command.equals("/index.do")){

			System.out.println("index.do");
			System.out.println("----------------");
			
			Calculator cal = new CalculatorImpl(1, 2, 3);
			
			Calculator proxy  = (Calculator) Proxy.newProxyInstance(Calculator.class.getClassLoader(),
					new Class[] { Calculator.class }, 
					new InvocationHandler() {

						@Override
						public Object invoke(Object proxy, Method method, Object[] args) 
								throws Throwable {
							
							long start = System.currentTimeMillis();
							System.out.println("시작:" + start );
							Object result = method.invoke(cal, args);
							//Thread.sleep(200);
							long end = System.currentTimeMillis();
							System.out.println("종료:" + end );
							return result;
						}
				}
			);
			
			long result = proxy.sum();
			System.out.printf("proxy:%d\n", result);
			
			HttpUtil.forward(req, res, "/WEB-INF/views/index.jsp");
			
		}
		
	}	

}

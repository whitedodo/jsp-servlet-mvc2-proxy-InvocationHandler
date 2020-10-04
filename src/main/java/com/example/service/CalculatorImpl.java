/*
 * 	주제(Subject): Proxy, InvocationHandler로 3단계 관점 프로그래밍
 * 	파일명(Filename): CalculatorImpl.java
 * 	제작일자(Create Date): 2020-10-04
 * 	설명(Description):
 *   
 * 
 */
package com.example.service;

public class CalculatorImpl implements Calculator {

	private long x;
	private long y;
	private long z;
	
	
	public CalculatorImpl(long x, long y, long z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public long sum() {
		
		long result = x + y + z;
		System.out.println("결과:" + result);
		return result;
	}
	
	
}

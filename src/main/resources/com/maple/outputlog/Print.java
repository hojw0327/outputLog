package com.maple.outputlog;

public class Print {
	
	private volatile static Print instance;

	private Print() {

	}

	public static Print getInstance() {
		if (instance == null) {
			synchronized (Print.class) {
				if (instance == null) {
					instance = new Print();
				}
			}
		}
		return instance;
	}
	public void print(String a,String b) {
		System.out.println(a+b);
	}
	public void print(String a) {
		System.out.print(a);
	}
	public void print(String a,int b) {
		System.out.println(a+b);
	}
	public void print(int a) {
		System.out.println(a);
	}
	public void print() {
		System.out.println();
	}
	
}

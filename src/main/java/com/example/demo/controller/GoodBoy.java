package com.example.demo.controller;

public class GoodBoy {
	
	static int test = 5;
	
	public GoodBoy() {
		test = 10;
	}
	
	public static void main() {
		GoodBoy boy = new GoodBoy();
		System.out.println(boy.test);
	}

}

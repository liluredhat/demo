package com.hnisi.basic;

public class XXTest {

	public static void main(String[] args) {
		System.out.println("1");
		//
		try {
			int i = 1/0;
			System.out.println("2");
		} catch (Exception e) {
			System.out.println("3");
		}finally {
			System.out.println("4");
		}
	}
}

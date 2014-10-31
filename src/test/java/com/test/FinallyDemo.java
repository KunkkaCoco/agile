package com.test;

public class FinallyDemo {
	static int value = 0;

	@SuppressWarnings("finally")
	static int getValue() {
		try {
			return value++;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally -> " + value);
			return value--;
		}
	}

	public static void main(String[] args) {
		System.out.println(getValue());
		System.out.println(value);
	}
}

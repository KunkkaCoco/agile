package com.test;

public class Random1 {
	public static void prt(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		for (int a = 0; a < 10; a++) {

			switch (a) {
			case 1:
				prt(String.valueOf(a) + "=" + 1);
				break;
			case 2:
				prt(String.valueOf(a) + "=" + 2);
				break;
			case 3:
				prt(String.valueOf(a) + "=" + 3);
				break;
			case 4:
				prt(String.valueOf(a) + "=" + 4);
				break;
			default:
				prt(String.valueOf(a) + "***");
			}
		}

	}
} // /:~
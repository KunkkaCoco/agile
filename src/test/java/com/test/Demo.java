package com.test;

import com.myutil.Prt;

public class Demo {

	public static void main(String[] args) {
		// // Send all output to the Appendable object sb
		// StringBuilder sb = new StringBuilder();
		// Formatter formatter = new Formatter(sb, Locale.US);
		// System.out.println(formatter.format("%4$2s %3$2s %2$2s %1$2s", "a", "b", "c", "d"));

		Prt.outln("---main---test===" + Demo.test());
		Prt.outln("---main---test1===" + Demo.test1());
		Prt.outln("---main---test2===" + Demo.test2());
	}

	public static int test() {
		// 测试return的值
		int value = 3;
		try {
			return value++;
		} catch (Exception e) {
		} finally {
			Prt.outln("---fianlly---test1--:" + value);
			value++;
		}
		return value = 111;

	}

	public static int test1() {
		// 测试return的值
		int value = 3;
		try {
			return value++;
		} catch (Exception e) {
		} finally {
			Prt.outln("---fianlly---test1--:" + value);
			value++;
			return value++;
		}
	}

	public static int test2() {
		// 测试return的值
		int value = 3;
		try {
			return ++value;
		} catch (Exception e) {
		} finally {
			Prt.outln("---fianlly---test2--:" + value);
			value++;
			return ++value;
		}
	}
}

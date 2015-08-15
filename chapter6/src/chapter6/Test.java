package chapter6;

class Test {
	public static String s = "in default class";

	// java文件中的每个类都会有一个输出文件，
	// 所以一个java文件最终可能有好多class文件。
	// 包括内部类，每个内部类也会输出一个class文件，外部类名$内部类名.class
	protected class A {

	}

	private class B {

	}

	public class C {

	}
}

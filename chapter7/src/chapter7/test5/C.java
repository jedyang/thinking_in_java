package chapter7.test5;

public class C extends A {
	B b = new B();

	public C() {
		System.out.println("constructor of C");
	}

	public static void main(String[] args) {
		C c = new C();
		/**
		 * constructor of A ����ִ�и���Ĺ�����
		 * constructor of B ִ�������Ե�new����
		 * constructor of C 
		 */
	}
}

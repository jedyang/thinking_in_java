package chapter7.test5;

public class C extends A {
	B b = new B();

	public C() {
		System.out.println("constructor of C");
	}

	public static void main(String[] args) {
		C c = new C();
		/**
		 * constructor of A 最先执行父类的构造器
		 * constructor of B 执行类属性的new方法
		 * constructor of C 
		 */
	}
}

package chapter7.test18;

public class Test {
	static final double m = Math.random();
	final double n = Math.random();

	@Override
	public String toString() {
		return "Test [m="+ m +",n=" + n + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
	}

}

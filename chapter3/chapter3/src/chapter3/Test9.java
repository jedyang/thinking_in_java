package chapter3;

public class Test9 {

	public static void main(String[] args) {
		float f1 = Float.MAX_VALUE;
		float f2 = Float.MIN_NORMAL;
		float f3 = Float.MIN_VALUE;
		float f4 = Float.NaN;
		float f5 = Float.NEGATIVE_INFINITY;
		float f6 = Float.POSITIVE_INFINITY;
		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);
		System.out.println(f4);
		System.out.println(f5);
		System.out.println(f6);
		
		// int值得大小在正负21亿之间
		System.out.println("========================");
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.SIZE);

	}

}

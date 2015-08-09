package chapter3;

public class Test8 {

	// int和long有对应的转换成二进制输出的方法
	public static void main(String[] args) {
		int i1 = 0x2f;
		System.out.println("i1:"+Integer.toBinaryString(i1));
		
//		float f1 = 0x2f;
//		System.out.println("f1:"+Float.toHexString(f1));
		
		long l1 = 0x2f;
		System.out.println("f1:"+Long.toBinaryString(l1));
	}

}

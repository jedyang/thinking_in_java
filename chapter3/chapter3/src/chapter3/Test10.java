package chapter3;

public class Test10 {

	public static void main(String[] args) {
		int i1 = 0x5;     //0101
		int i2 = 0xa;     //1010
		int i3 = i1 & i2;
		System.out.println(Integer.toBinaryString(i3));
		System.out.println(Integer.toBinaryString(i1 | i2));
		System.out.println(Integer.toBinaryString(i1 ^ i2));
	}

}

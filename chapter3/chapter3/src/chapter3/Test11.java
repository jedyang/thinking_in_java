package chapter3;

public class Test11 {

	public static void main(String[] args) {
		int i = 0xff;
		printBinaryInt(i);
		for (int j = 0; j < 10; j++) {
			printBinaryInt(i >>= 1);
		}
	}

	static void printBinaryInt(int i) {
		System.out.println("i:"+i+"     binary:"+Integer.toBinaryString(i));
	}
}

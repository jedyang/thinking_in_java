package chapter3;

import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			generatorRandom(47);
		}
	}

	// ���֤����ֻҪ��һ����ÿ�����������ж���һ����
	private static void generatorRandom(int m) {
		Random r = new Random(m);
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(100));
		}
		System.out.println("========================");
	}

}

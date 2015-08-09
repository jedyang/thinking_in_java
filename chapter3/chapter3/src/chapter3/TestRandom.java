package chapter3;

import java.util.Random;

public class TestRandom {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			generatorRandom(47);
		}
	}

	// 结果证明：只要种一样。每次生产的序列都是一样的
	private static void generatorRandom(int m) {
		Random r = new Random(m);
		for (int i = 0; i < 10; i++) {
			System.out.println(r.nextInt(100));
		}
		System.out.println("========================");
	}

}

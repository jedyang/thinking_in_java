package chapter4;

import java.util.Random;

public class Test2 {
	public static void main(String[] args) {
		Random r = new Random(47);
		int m = r.nextInt();
		for (int i = 0; i < 25; i++) {
			System.out.println("times:"+(i+1));
			int n = r.nextInt();
			System.out.println("m : " + m + "  n: " + n);
			if (m > n) {
				System.out.println("m > n");
			} else if (m == n) {
				System.out.println("m == n");
			} else {
				System.out.println("m < n");
			}

			m = n;
		}
	}
}

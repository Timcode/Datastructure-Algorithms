import java.util.Scanner;

class Main {

	static long result = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (int i = scanner.nextInt(); i > 0; i--) {

			int depth = scanner.nextInt();
			long A = scanner.nextInt();
			long B = scanner.nextInt();
			int C = scanner.nextInt();
			int D = scanner.nextInt();

			if (depth == 0)
				result = A;
			else if (depth == 1)
				result = B;
			else
				result = calculateSum(depth, A, B, C, D);

			System.out.println(result);
		}
		scanner.close();
	}

	private static long calculateSum(int depth, long A, long B, int C, int D) {
		long temp = 0;
		for (int j = 2; j <= depth; j++) {
			temp = C * B + D * A;
			A = B;
			B = temp;
		}
		return B;
	}

}
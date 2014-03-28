import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {

			//Read input
			char[] a = scanner.next().toCharArray();
			char[] b = scanner.next().toCharArray();

			int[][] table = buildTable(a, b);
			int maxCommonSequence = getLongestCommonSubsequenceLength(table);
			String result = getLongestCommonSubsequence(table, a, b);
			//Printing result
			System.out.println(maxCommonSequence + " " + result);
		}

		scanner.close();
	}

	private static String getLongestCommonSubsequence(int[][] table, char[] a, char[] b) {
		int i = a.length;
		int j = b.length;
		StringBuilder common = new StringBuilder();

		while (i > 0 && j > 0) {
			if (a[i - 1] == b[j - 1]) {
				common.append(a[i-1]);
				j--;
				i--;
			} else if (table[i][j] == table[i - 1][j]) {
				i--;
			} else {
				j--;
			}
		}
		return common.reverse().toString();
	}
	

	private static int getLongestCommonSubsequenceLength(int[][] table) {
		return table[table.length-1][table[0].length-1];
	}

	private static int[][] buildTable(char[] a, char[] b) {
		int[][] A = new int[a.length + 1][b.length + 1];

		// Init
		for (int i = 0; i <= a.length; i++) {
			A[i][0] = 0;
		}
		for (int j = 0; j <= b.length; j++) {
			A[0][j] = 0;
		}

		// Compute the table
		for (int x = 1; x <= a.length; x++) {
			for (int y = 1; y <= b.length; y++) {
				if (a[x - 1] == b[y - 1]) {
					A[x][y] = A[x - 1][y - 1] + 1;
				} else {
					A[x][y] = Math.max(A[x - 1][y], A[x][y - 1]);
				}
			}
		}
		return A;
	}
}
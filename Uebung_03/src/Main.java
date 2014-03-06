import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int n = scanner.nextInt();

			int[][] matrix = new int[n][n];

			for (int j = 0; j < n; j++) {
				for (int p = 0; p < n; p++) {
					int value = scanner.nextInt();
					matrix[j][p] = value;
				}
			}

			int sum = MaxSubMatrixFast(matrix);
//			int sum = MaxSubMatrixSlow(matrix);
			System.out.println(sum);
		}

		scanner.close();
	}

	/**
	 * Performance is O(n^6)
	 * @param matrix
	 * @return
	 */
	private static int MaxSubMatrixSlow(int[][] matrix) {
		int maxSum = 0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				for (int u = i; u < matrix.length; u++) {
					for (int v = j; v < matrix.length; v++) {
						
						int temp = 0;
						for (int t = i; t <= u; t++) {
							for (int s = j; s <= v; s++) {
								temp += matrix[t][s];
							}
						}
						if (temp > maxSum)
							maxSum = temp;
					}
				}
			}

		}
		return maxSum;
	}

	/**
	 * Performance is o(n^2) and is based on the Kadane algorithm
	 * 
	 * @param matrix
	 * @return
	 */
	public static int MaxSubMatrixFast(int[][] matrix) {
		int LENGTH = matrix.length;
		int maxSum = 0;
		int[][] tempMatrix = new int[LENGTH + 1][LENGTH];

		// init temp matrix with 0's
		for (int i = 0; i < LENGTH + 1; i++) {
			for (int j = 0; j < LENGTH; j++) {
				tempMatrix[i][j] = 0;
			}
		}

		// Sum up each column until i-th row
		for (int row = 1; row < LENGTH + 1; row++) {
			for (int column = 0; column < LENGTH; column++) {
				tempMatrix[row][column] = tempMatrix[row - 1][column] + matrix[row - 1][column];
			}
		}

		for (int i = 1; i < LENGTH + 1; i++) {
			for (int j = i; j < LENGTH + 1; j++) {
				
				int[] subArray = new int[LENGTH];
				for (int column = 0; column < LENGTH; column++) {
					subArray[column] = tempMatrix[j][column] - tempMatrix[i - 1][column];
				}

				// Max sum of the subarray (Kadane)
				int max = 0;
				for (int c = 0; c < LENGTH; c++) {
					max = subArray[c] + max;
					if (max <= 0) {
						max = 0;
					}
					if (max > maxSum) {
						maxSum = max;
					}
				}
			}
		}
		return maxSum;
	}
}
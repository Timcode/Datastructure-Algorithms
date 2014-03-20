import java.util.Scanner;

class Main {
	static int N = 2005;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int test = in.nextInt();
		int[] result = new int[test];

		for (int t = 0; t < test; t++) {
			int n = in.nextInt();
			int[] Bucket = new int[N];
			int[] Bucket1 = new int[N];

			int max = 0, sum = 0;

			for (int i = 0; i < n; i++) {
				int a = in.nextInt();
				if (max < a)
					max = a;
				sum += a;
				Bucket[a]++;
			}

			if (sum >= 3 * max) {
				System.out.println(sum / 3);
				continue;
			}
			Bucket[0] = 0;
			for (int i = 0; i < N; i++)
				Bucket1[i] = Bucket[i];
			int max1 = -1, max2 = -1, max3 = -1;
			for (int i = max; i >= 0; i--) {
				if (Bucket1[i] > 0) {
					if (max1 == -1) {
						max1 = i;
					} else if (max2 == -1) {
						max2 = i;
					} else {
						max3 = i;
					}
					if (max3 != -1)
						break;
					Bucket1[i]--;
					i++;
				}
			}
			int answer = 0;
			while (max3 > 0) {
				answer++;
				Bucket[max1]--;
				Bucket[max2]--;
				Bucket[max3]--;
				Bucket[max1 - 1]++;
				Bucket[max2 - 1]++;
				Bucket[max3 - 1]++;
				while (max1 > 0 && Bucket[max1] == 0)
					max1--;
				while (max2 > 0 && Bucket[max2] == 0)
					max2--;
				if (Bucket[max2] == 1 && max1 == max2) {
					max2--;
					while (max2 > 0 && Bucket[max2] == 0)
						max3--;
				}
				while (max3 > 0 && Bucket[max3] == 0)
					max3--;
				if (Bucket[max3] == 1 && max3 == max1) {
					max3--;
					while (max3 > 0 && Bucket[max3] == 0)
						max3--;
				}
				if (Bucket[max3] == 1 && max3 == max2) {
					max3--;
					while (max3 > 0 && Bucket[max3] == 0)
						max3--;
				}

				if (Bucket[max3] == 2 && max3 == max2 && max3 == max1) {
					max3--;
					while (max3 > 0 && Bucket[max3] == 0)
						max3--;
				}
			}
			System.out.println(answer);
		}
	}
}


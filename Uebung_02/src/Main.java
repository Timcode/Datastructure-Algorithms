import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTestCases = scanner.nextInt();
		
		for(int i = 0; i < numberOfTestCases; i++){
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			
			List<Integer> values = new LinkedList<Integer>();
			for(int j = 0; j < n; j++){
				int value = scanner.nextInt();
				values.add(value);
			}
			
			print(new HashMap(m, values, new LineareInsertionStrategy()));
			print(new HashMap(m, values, new QuadraticInsertionStrategy()));
			print(new HashMap(m, values, new DoubleHashInsertionStrategy()));
		}
		
		scanner.close();
	}
	
	
	
	private static void print(HashMap hashMap) {
		int[] v = hashMap.getValues();
		System.out.print(hashMap.getTotalCollisions() + " ");
		for (int i = 0; i < v.length; i++) {
			System.out.print(v[i]);
			if ((i + 1) != v.length)
				System.out.print(" ");
		}
		System.out.println();		
	}


	/**
	 * HashMap which can be configured with a InsertStrategy to fill the array
	 * Remove(), size() and other methods are not impl.
	 * @author tbruellm
	 *
	 */

	private static class HashMap{
		
		private InsertStrategy strategy;
		private int m;
		private int numberOfCollisions;
		private int[] values;
		
		public HashMap(int m, List<Integer> insertValues, InsertStrategy strategy){
			
			this.strategy = strategy;
			this.m = m;
			values = new int[m];
			
			for(Integer i: insertValues){
				push(i);
			}
		}

		private void push(Integer i) {
			int position = findFreePosition(i);
			values[position] = i;
			
		}

		private int findFreePosition(Integer i) {
			int mod = i % m;
			int position = mod;
			int localCollisions = 0;
			while(values[position] != 0){
				int delta = strategy.insert(++localCollisions, i, m);
				position = positivModulo(mod - delta, m); //negative Modulo calculation
			}
			
			this.numberOfCollisions+=localCollisions;
			return position;
		}

		private int positivModulo(int n, int m) {
			return (n < 0) ? (m - (Math.abs(n) % m) ) %m : (n % m);
		}
		
		public int getTotalCollisions(){
			return numberOfCollisions;
		}
		
		public int[] getValues(){
			return values;
		}
	}
	
	
	
	private interface InsertStrategy {
		
		public int insert(int j, int k, int m);
	}
	
	
	private static class LineareInsertionStrategy implements InsertStrategy{

		@Override
		public int insert(int j, int k, int m) {
			return j;
		}	
	}
	
	private static class QuadraticInsertionStrategy implements InsertStrategy{

		@Override
		public int insert(int j, int k, int m) {
			int x = (j+1) / 2;
			int sign = (j % 2) == 0 ? 1 : -1;
			return x * x * sign;
		}
		
	}
	
	private static class DoubleHashInsertionStrategy implements InsertStrategy{

		@Override
		public int insert(int j, int k, int m) {
			int h = 1 + (k % (m-2));
			return j * h;
		}
		
	}
	
}
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int lines = scanner.nextInt();
		
		for(int i = 0; i < lines; i++){
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
			if((i+1)!=v.length)
				System.out.print(" ");
		}
		System.out.println();		
	}



	private static class HashMap{
		
		private InsertStrategy strategy;
		private int m;
		private int NumberOfCollisions;
		int[] values;
		
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
			while(values[position] != 0)
				position = positivModulo(mod - strategy.insert(++localCollisions, i, m), m); //negative index, build circular array
			
			this.NumberOfCollisions+=localCollisions;
			return position;
		}

		private int positivModulo(int n, int m) {
			return (n < 0) ? (m - (Math.abs(n) % m) ) %m : (n % m);
		}
		
		public int getTotalCollisions(){
			return NumberOfCollisions;
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
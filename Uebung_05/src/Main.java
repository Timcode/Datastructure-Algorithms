import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int n = scanner.nextInt();

			MinHeap heap = new MinHeap(n);

			//Looking for the last element in the heap
			for (int j = 0; j < n; j++) {
				heap.insert(scanner.nextInt());
				System.out.print(heap.query_last());

				// Space between results
				if (j < (n - 1))
					System.out.print(" ");
			}
			System.out.println();

			//Unbuild the heap by removing the minElement
			while (!heap.isEmpty()) {
				System.out.print(heap.extractMin());
				// Space between results
				if (heap.size() > 0)
					System.out.print(" ");
			}
			System.out.println();
		}

		scanner.close();
	}

}

class MinHeap {

	int[] heap;
	int counter;
	final int MIN_HEAP_POSITION = 1;

	MinHeap(int size) {
		heap = new int[size+1];
		counter = 0;
	}

	public void insert(int value) {
		heap[++counter] = value;
		bubbleUp(counter);
	}

	public int query_last() {
		return heap[counter];
	}

	public int extractMin() {
		int min = heap[MIN_HEAP_POSITION];
		delete(MIN_HEAP_POSITION);
		return min;
	}

	public void delete(int index) {
		heap[index] = heap[counter];
		bubbleDown(index);
		counter--;

	}

	private void bubbleUp(int index) {

		while (index != MIN_HEAP_POSITION) {
			int parent = getParent(index);
			if (heap[index] > heap[parent])
				break;
			swap(index, parent);
			index = parent;
		}
	}

	private void bubbleDown(int index) {

		int rightChild;
		int leftChild;
		int smaller;

		while (index < counter) {

			leftChild = getLeftChild(index);
			rightChild = getRightChild(index);

			//Left is already a leaf node
			if (leftChild >= counter)
				break;

			if (rightChild >= counter) {
				smaller = leftChild;
			} else if (heap[leftChild] < heap[rightChild]) {
				smaller = leftChild;
			} else
				smaller = rightChild;

			if (heap[smaller] < heap[index]) {
				swap(index, smaller);
				index = smaller;
			} else
				break;

		}
	}
	

	private int getParent(int index) {
		return (index) / 2;
	}

	private int getLeftChild(int index) {
		return 2 * index;
	}

	private int getRightChild(int index) {
		return 2 * index + 1;
	}

	private void swap(int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;
	}

	public int size() {
		return counter;
	}

	public boolean isEmpty() {
		return counter == 0;
	}

}
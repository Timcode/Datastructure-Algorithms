import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int n = scanner.nextInt();

			MinHeap heap = new MinHeap(n);

			// Looking for the last element in the heap
			for (int j = 0; j < n; j++) {
				heap.insert(scanner.nextInt());
				System.out.print(heap.queryLast());

				// Space between results
				if (j < (n - 1))
					System.out.print(" ");
			}
			System.out.println();

			// Unbuild the heap by removing the minElement
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
	int elementCounter;
	final int MIN_HEAP_POSITION = 1;

	public MinHeap(int size) {
		heap = new int[size + 1];
		elementCounter = 0;
	}

	public void insert(int value) {
		heap[++elementCounter] = value;
		bubbleUp(elementCounter);
	}

	public int queryLast() {
		return heap[elementCounter];
	}

	public int extractMin() {
		int min = heap[MIN_HEAP_POSITION];
		delete(MIN_HEAP_POSITION);
		return min;
	}

	public void delete(int index) {
		heap[index] = heap[elementCounter];
		bubbleDown(index);
		elementCounter--;

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

		while (index < elementCounter) {

			leftChild = getLeftChild(index);
			rightChild = getRightChild(index);

			// Left is already a leaf node
			if (leftChild >= elementCounter)
				break;

			if (rightChild >= elementCounter) {
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
		return elementCounter;
	}

	public boolean isEmpty() {
		return elementCounter == 0;
	}

}
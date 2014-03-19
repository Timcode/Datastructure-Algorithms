import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numberOfTestCases = scanner.nextInt();

		for (int i = 0; i < numberOfTestCases; i++) {
			int n = scanner.nextInt();

			MinHeap heap = new MinHeap(n);

			for (int j = 0; j < n; j++) {
				heap.insert(scanner.nextInt());
				System.out.print(heap.query_last());

				//Space between results
				if (j < (n - 1))
					System.out.print(" ");
			}
			System.out.println();

			while (!heap.isEmpty()) {
				System.out.print(heap.extractMin());
				//Space between results
				if (heap.size() > 0)
					System.out.print(" ");
			}
			System.out.println();
		}

		scanner.close();
	}

}

class MinHeap {

	int[] elements;
	int counter;

	MinHeap(int size) {
		elements = new int[size];
		counter = 0;
	}

	public void insert(int value) {
		elements[counter] = value;
		restoreHeapCondition(counter);
		counter++;
	}

	private void restoreHeapCondition(int childIndex) {
		if (childIndex == 0)
			return;

		int parentIndex = (childIndex - 1) / 2;
		if (elements[childIndex] > elements[parentIndex])
			return;
		else
			swap(childIndex, parentIndex);

		if (parentIndex != 0)
			restoreHeapCondition(parentIndex);
	}

	public int query_last() {
		return elements[counter - 1];
	}

	public int extractMin() {
		int out = elements[0];
		delete(0);
		return out;
	}

	public void delete(int index) {
		elements[index] = elements[--counter];
		bubbleDown(index);
	}

	private void bubbleDown(int index) {
		int leftChild = 2 * index + 1;
		int rightChild = 2 * index + 2;

		// No children
		if (leftChild >= counter)
			return;

		// Only one left child
		if (rightChild >= counter) {
			if (elements[index] > elements[leftChild]) {
				swap(index, leftChild);
				return;
			}
		}

		int minIndex = elements[leftChild] < elements[rightChild] ? leftChild : rightChild;
		if (elements[index] < elements[minIndex]) {
			return;
		}
		swap(index, minIndex);
		bubbleDown(minIndex);

	}


	private void swap(int child, int parent) {
		int temp = elements[child];
		elements[child] = elements[parent];
		elements[parent] = temp;
	}

	public int size() {
		return counter;
	}

	public boolean isEmpty() {
		return counter == 0;
	}

}
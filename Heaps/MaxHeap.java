/*
 * @Author: Marcelo Sanchez
 * @Version: 2/4/20
 * @CSCI 333: Algorithms & Data Structures
 * @MaxHeap implementation
 */

public class MaxHeap {
	
	private int[] heap;
	private int heapSize;
	
	
	public MaxHeap(int[] heapAsArray){
		this.heap = heapAsArray;
		int heapS = heapAsArray.length - 1;
		this.heapSize = heapS;
		printMaxHeap();
	}
	
	//returns the left child of the heap at the given index
	private int leftChildOf(int index) {
		if(index > heapSize) {
			return -1;
		}
		return index * 2;
	}
	//returns the right child of the heap at the given index
	private int rightChildOf(int index) {
		if(index > heapSize) {
			return -1;
		}
		return (index * 2) + 1;
	}
	
	//prints the heap as an array
	public void printMaxHeap() {
		for(int i = 1; i <= heapSize; i++) {
			System.out.print(heap[i] + ", ");
		}
		System.out.println();
	}
	
	//performs the max heapify function on the given index
	private void maxHeapify(int index) {
		int left = leftChildOf(index);
		int right = rightChildOf(index);
		int largest = 0;
		//---for debugging
//		System.out.println("index: " + index);
//		System.out.println("left: " + left);
//		System.out.println("right: " + right);
//		System.out.println("---------------");
		//1 <= 7 && 4 > 2
		if(left <= heapSize && heap[left] > heap[index]) {
			largest = left;
		}else {
			largest = index;
		}
		if(right <= heapSize && heap[right] > heap[largest]) {
			largest = right;
		}
		if(largest != index) {
			int a = heap[largest];
			int b = heap[index];
			//ensuring the swap was performed appropriately by printing the values.
//			System.out.println("a: " + a);
//			System.out.println("b: " + b);
			int c = 0;
			c = a;
			a = b;
			b = c;
//			System.out.println("a: " + a);
//			System.out.println("b: " + b);
			heap[index] = b;
			heap[largest] = a;
			maxHeapify(largest);
		}	
	}
	
	private void buildMaxHeap() {
	
		for(int i = (heapSize/2); i >= 1; i--) {
//			System.out.println("i: " + i);
			maxHeapify(i);
		}
	}
	
	public void heapsort() {
		buildMaxHeap();
		int backup = heapSize;
		for(int i = heapSize; i >= 2; i--) {
			int a = heap[1]; //indexing starts at 1 instead of 0
			int b = heap[i];
			int c = 0;
			c = a;
			a = b;
			b = c;
			heapSize--;
			maxHeapify(1);
		}
		heapSize = backup;
	}
}

/*
 * @Author: Marcelo Sanchez
 * @Version: 2/4/20
 * @CSCI 333: Algorithms & Data Structures
 * @Driver for MaxHeap class
 */

public class Driver {

	public static void main(String[] args) {
		
		int[] arrayOne = {0, 6, 8, 9, 13, 19};
		int[] arrayTwo = {0, 60, 70, 80, 90, 100};
		System.out.print("heapOne: ");
		MaxHeap heapOne = new MaxHeap(arrayOne);
		System.out.print("heapOne after heapSort(): ");
		heapOne.heapsort();
		heapOne.printMaxHeap();
		
		System.out.println("________________________________________________");
		System.out.println();
		
		System.out.print("heapTwo: ");
		MaxHeap heapTwo = new MaxHeap(arrayTwo);
		System.out.print("heapTwo after heapSort(): ");
		heapTwo.heapsort();
		heapTwo.printMaxHeap();
		
	}
}

import java.util.Random;
/*
 * @Author: Marcelo Sanchez
 * @Version: 2/12/20
 * HW3 Quicksort
 */
public class Driver {

	public static void main(String[] args) {
		//One indexed array(s) so we discard index arr[0];
		int[] arrayOne = {0, 5, 3, 2, 10, 11, 23, 57, 32};
		int[] arrayTwo = {0, 545, 342, 231, 112, 2, 1, 90};
		int[] arrayThree = {0, 9, 8, 7, 6, 3, 4, 1, 2};
		int[] arrayFour = {0, 54, 45, 34, 65, 76, 90};
		int[] arrayFive = {0, 455, 6564, 543, 23, 78, 3234};
		
		int[] arraySix = {0, 65, 23, 867, 34432, 4345, 52, 12};
		int[] arraySeven = {0, 70, 43, 76, 87, 33, 55, 65};
		int[] arrayEight = {0, 111, 22, 33, 44, 55, 999};
		int[] arrayNine = {0, 9000, 8887, 8888, 212};
		int[] arrayTen = {0, 5192, 750, 332, 864, 684};
		
		System.out.print("arrayOne BEFORE Quicksort: ");
		PrintArray(arrayOne);
		Quicksort(arrayOne, 1, arrayOne.length - 1);
		System.out.println();
		System.out.print("arrayOne AFTER Quicksort: ");
		PrintArray(arrayOne);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.print("arrayTwo BEFORE Quicksort: ");
		PrintArray(arrayTwo);
		Quicksort(arrayTwo, 1, arrayTwo.length - 1);
		System.out.println();
		System.out.print("arrayTwo AFTER Quicksort: ");
		PrintArray(arrayTwo);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.print("arrayThree BEFORE Quicksort: ");
		PrintArray(arrayThree);
		Quicksort(arrayThree, 1, arrayThree.length - 1);
		System.out.println();
		System.out.print("arrayThree AFTER Quicksort: ");
		PrintArray(arrayThree);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.print("arrayFour BEFORE Quicksort: ");
		PrintArray(arrayFour);
		Quicksort(arrayFour, 1, arrayFour.length - 1);
		System.out.println();
		System.out.print("arrayFour AFTER Quicksort: ");
		PrintArray(arrayFour);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.print("arrayFive BEFORE Quicksort: ");
		PrintArray(arrayFive);
		Quicksort(arrayFive, 1, arrayFive.length - 1);
		System.out.println();
		System.out.print("arrayFive AFTER Quicksort: ");
		PrintArray(arrayFive);
		
		System.out.println();
		System.out.println();
		System.out.println("********************************************************");
		System.out.println();
		
		System.out.print("arraySix BEFORE RandomizedQuicksort: ");
		PrintArray(arraySix);
		RandomizedQuicksort(arraySix, 1, arraySix.length - 1);
		System.out.println();
		System.out.print("arraySix AFTER RandomizedQuicksort: ");
		PrintArray(arraySix);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.print("arraySeven BEFORE RandomizedQuicksort: ");
		PrintArray(arraySeven);
		RandomizedQuicksort(arraySeven, 1, arraySeven.length - 1);
		System.out.println();
		System.out.print("arraySeven AFTER RandomizedQuicksort: ");
		PrintArray(arraySeven);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.print("arrayEight BEFORE RandomizedQuicksort: ");
		PrintArray(arrayEight);
		RandomizedQuicksort(arrayEight, 1, arrayEight.length - 1);
		System.out.println();
		System.out.print("arrayEight AFTER RandomizedQuicksort: ");
		PrintArray(arrayEight);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.print("arrayNine BEFORE RandomizedQuicksort: ");
		PrintArray(arrayNine);
		RandomizedQuicksort(arrayNine, 1, arrayNine.length - 1);
		System.out.println();
		System.out.print("arrayNine AFTER RandomizedQuicksort: ");
		PrintArray(arrayNine);
		
		System.out.println();
		System.out.println("--------------------------------------------------------");
		
		System.out.print("arrayTen BEFORE RandomizedQuicksort: ");
		PrintArray(arrayTen);
		RandomizedQuicksort(arrayTen, 1, arrayTen.length - 1);
		System.out.println();
		System.out.print("arrayTen AFTER RandomizedQuicksort: ");
		PrintArray(arrayTen);
		
		
		
	}
//Method to print the array before or after being sorted.
private static void PrintArray(int[] array) {
	for(int i = 1; i < array.length; i++) {
		System.out.print(array[i] + ", ");
	}
}
	
public static void Quicksort(int[] array, int index, int upperBound) {
	if(index < upperBound) {
		int q = Partition(array, index, upperBound);
		Quicksort(array, index, q - 1);
		Quicksort(array, q + 1, upperBound);
	} 
}

private static int Partition(int[] array, int index, int upperBound) {
	
	int pivot = array[upperBound];
	int i = index - 1;
	
	for(int j = index; j < (upperBound); j++) {
		if(array[j] < pivot) {
			//swap array[i] with array[j]
			//increment i loop variable
			i++;
			int a = array[j];
			array[j] = array[i];
			array[i] = a;
		}
	}
	//Swap array[i + 1] with array[upperBound]
	int a = array[i + 1];
	array[i +1] = array[upperBound];
	array[upperBound] = a;
	return (i + 1);
}

public static void RandomizedQuicksort(int[] array, int index, int upperBound) {
	if(index < upperBound) {
		//Choose a random pivot between the index and upperBound, then swap
		//the randomPivot with the upperBound
		int randomPivot = (int) (Math.random() * index + upperBound);
		randomPivot = upperBound;
		upperBound = randomPivot;
		int q = Partition(array, index, upperBound);
		RandomizedQuicksort(array, index, q - 1);
		RandomizedQuicksort(array, q + 1, upperBound);
	}
}
}

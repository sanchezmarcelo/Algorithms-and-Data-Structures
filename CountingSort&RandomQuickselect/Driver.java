import java.util.Arrays;
/*
 * @Author: Marcelo Sanchez
 * @Version: 2/21/20
 * HW4 RamSortnSelect
 * RAM Model Sorting Algorithms
 */
public class Driver {
	
	//1 indexex array(s) for Counting Sort
	static int[] aOne = {0, 7, 1, 3, 5, 3, 1, 4};
	static int[] aTwo = {0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
	static int[] aThree = {0, 32, 34, 65, 676, 893, 12, 3, 6};
	static int[] aFour = {0, 87, 999, 324, 1000, 333, 201, 894};
	static int[] aFive = {0, 740, 112, 343, 5, 873, 671, 344};
	
	
	public static void main(String[] args) {
		BestAttemptAtFormattingOutputRIP();
	}

	
private static void BestAttemptAtFormattingOutputRIP() {
	
	/*
	 * Call countsort on all five global arrays then call
	 * RandomizedQuickSelect on the same arrays AFTER being
	 * sorted to find the (n)th statistic.
	 */
	
	System.out.println("aOne BEFORE Countsort: ");
	PrintArray(aOne); 
	int[] outputOne = CountingSort(aOne, 7);
	System.out.println("aOne AFTER Countsort: ");
	PrintArray(outputOne);
	System.out.println("________________________________________________________");
	
	System.out.println("aTwo BEFORE Countsort: ");
	PrintArray(aTwo); 
	int[] outputTwo = CountingSort(aTwo, 9);
	System.out.println("aTwo AFTER Countsort: ");
	PrintArray(outputTwo);
	System.out.println("________________________________________________________");
	
	System.out.println("aThree BEFORE Countsort: ");
	PrintArray(aThree); 
	int[] outputThree = CountingSort(aThree, 893);
	System.out.println("aThree AFTER Countsort: ");
	PrintArray(outputThree);
	System.out.println("________________________________________________________");
	
	System.out.println("aFour BEFORE Countsort: ");
	PrintArray(aFour); 
	int[] outputFour = CountingSort(aFour, 1000);
	System.out.println("aFour AFTER Countsort: ");
	PrintArray(outputFour);
	System.out.println("________________________________________________________");
	
	System.out.println("aFive BEFORE Countsort: ");
	PrintArray(aFive); 
	int[] outputFive = CountingSort(aFive, 873);
	System.out.println("aFive AFTER Countsort: ");
	PrintArray(outputFive);
	System.out.println("________________________________________________________");
	
	System.out.print("aOne Order Statistic 4: ");
	int outputSix = RandomizedQuickSelect(outputOne, 1, 7, 4);
	System.out.println(outputSix);
	PrintArray(outputOne); 
	System.out.println("________________________________________________________");
	
	System.out.print("aTwo Order Statistic 2: ");
	int outputSeven = RandomizedQuickSelect(outputTwo, 1, 9, 2);
	System.out.println(outputSeven);
	PrintArray(outputTwo); 
	System.out.println("________________________________________________________");
	
	System.out.print("aThree Order Statistic 5: ");
	int outputEight = RandomizedQuickSelect(outputThree, 1, 8, 5);
	System.out.println(outputEight);
	PrintArray(outputThree); 
	System.out.println("________________________________________________________");
	
	System.out.print("aFour Order Statistic 7: ");
	int outputNine = RandomizedQuickSelect(outputFour, 1, 7, 7);
	System.out.println(outputNine);
	PrintArray(outputFour); 
	System.out.println("________________________________________________________");
	
	System.out.print("aFive Order Statistic 6: ");
	int outputTen = RandomizedQuickSelect(outputFive, 1, 7, 6);
	System.out.println(outputTen);
	PrintArray(outputFive); 
	System.out.println("________________________________________________________");		
	}



public static void PrintArray(int[] a) {
	for(int i = 1; i < a.length; i++) {
	System.out.print(a[i] + ", ");
	}
	System.out.println();
}


public static int[] CountingSort(int[] a, int k) {
	
	//initialize the required arrays
	int[] count = new int[k + 1];
	int[] b = new int[k + 1];
	
	/*
	 * Initialize 0s to every index of count array
	 */
	for(int i = 1; i < k + 1; i++) { 
		count[i] = 0;
	}
	/*
	 * Tally each occurrence of a[i] in c[i];
	 */
	for(int i = 1; i < a.length; i++) {
		count[a[i]]++;
	}
	/*
	 * Sum up count[i -1] in count [i]
	 */
	for(int i = 1; i < k + 1; i++) {
		count[i] = count[i] + count[i-1];
	}
	/*
	 * iterate left to right and place the num
	 * in the correct index
	 */
	for(int i = 1; i < a.length; i++) {
		b[count[a[i]]] = a[i];
		count[a[i]]--;
	}
	return b;
}

public static int RandomizedQuickSelect(int[] a, int p, int r, int i) {
	/*
	 * Pseudocode from slides
	 */
	if(p == r) {       //base case
		return a[p];
	}
	int pivot = (int) (Math.random() * p + r); //choose random pivot
	pivot = r;
	r = pivot;
	
	int q = Partition(a, p, r);
	int k = q - p + 1;
	if(i == k) {
		return a[q]; //check for the pivot being the statistic
	}
	
	/*
	 * checks for the earlier statistic
	 */
	if(i < k){
		return RandomizedQuickSelect(a, p, q - 1, i);
	}else {
		return RandomizedQuickSelect(a, q + 1, r, i - k);
	}
}

private static int Partition(int[] array, int index, int upperBound) {
	int pivot = array[upperBound];
	int i = index -1;
	
	for(int j = index; j < (upperBound); j++){
		if(array[j] < pivot) {
			/*
			 * swap array[i] with array[j]
			 * increment i
			 */
			i++;
			int a = array[i];
			array[j] = array[i];
			array[i] = a;
		}
	}
	/*
	 * swap array[i + 1] with array[upperBound]
	 */
	int a = array[i + 1];
	array[i + 1] = array[upperBound];
	array[upperBound] = a;
	return (i + 1);
}

}

package main;

public class Test {

	public static void main(String[] args) {
		int arr[] = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
		int n = arr.length;
		
		Radix.radixSort(arr, n);
		Radix.print(arr, n);
	}
}

package main;

import java.util.*;

public class Radix {
// Return max value in array
	static int maxValue(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max; 						
	}
// Perform counting sort of array according to "exp" digit	
	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
// Store count of occurrences of each digit		
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;
// Change count[i] so it contains position of digit in output[]		
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
// Build output array		
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
// Copy sorted numbers back into original array	
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}
// sort arr[] using Radix sort	
	static void radixSort(int arr[], int n) {
// find max value to determine number of digits		
		int m = maxValue(arr, n);
// Counting sort for each digit (ones, tens, hundreds, etc.)		
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}
// Function to print array	
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}

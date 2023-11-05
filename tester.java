// Java program to illustrate
// Randomised Quick Sort 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import sortingAlgorithms.RandomizedQsort;
import sortingAlgorithms.SelectionSort;
import sortingAlgorithms.ClusteredBIS;
import sortingAlgorithms.MergeSort;

class Tester {
	/* A utility function to print array of size n */
	static void printArray(int arr[]) { 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 

    public static int[] readFile(String filePath, int size)throws Exception {
        int[] array = new int[size];
        Scanner sc = new Scanner(new BufferedReader(new FileReader(new File(filePath))));
        for(int i=0;sc.hasNextLine();i++) 
        {
        array[i]=Integer.parseInt(sc.nextLine());
        }
        return array;
    }

    public static void test(String fileName, int size) throws Exception {
        int arr[] = readFile(fileName, size);
        int arr2[] = arr.clone();
        int arr3[] = arr.clone();
        int arr4[] = arr.clone();
        int n = arr.length;

        double qs_begin = System.nanoTime();
        RandomizedQsort.sort(arr, 0, n-1);
        double qs_end = System.nanoTime();
        double qs_time = (qs_end-qs_begin) / 1000000;
        System.out.println();
        System.out.println(fileName);
        System.out.println("Quicksort: "+ qs_time +" milli seconds");
        
        double cbis_begin = System.nanoTime();
        ClusteredBIS.sort(arr2);
        double cbis_end = System.nanoTime();
        double cbis_time = (cbis_end-cbis_begin) / 1000000;
        System.out.println("CBIS: "+ cbis_time +" milli seconds");

        double ss_begin = System.nanoTime();
        SelectionSort.sort(arr3);
        double ss_end = System.nanoTime();
        double ss_time = (ss_end-ss_begin) / 1000000;
        System.out.println("Selection Sort: "+ ss_time +" milli seconds");

        double ms_begin = System.nanoTime();
        MergeSort.sort(arr4, 0, n-1);
        double ms_end = System.nanoTime();
        double ms_time = (ms_end-ms_begin) / 1000000;
        System.out.println("Merge Sort: "+ ms_time +" milli seconds");
    }

	// Driver Code 
	public static void main(String args[]) throws Exception {   
        test("small_sorted.txt", 200);
        test("medium_sorted.txt", 2000);
        test("large_sorted.txt", 20000);

        test("small_random.txt", 200);
        test("medium_random.txt", 2000);
        test("large_random.txt", 20000);
        
        test("small_reversed.txt", 200);
        test("medium_reversed.txt", 2000);
        test("large_reversed.txt", 20000);
	} 
} 

package sortingAlgorithms;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*; 

public class RandomizedQsort {	 
    // Function to swap two elements in the array
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
 
    // Function to generate a random pivot index
    static int generateRandomPivot(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
 
    // Function to perform QuickSort
    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = generateRandomPivot(low, high);
            int pivotValue = arr[pivotIndex];
 
            // Swap the pivot element with the last element
            swap(arr, pivotIndex, high);
 
            int i = low - 1;
 
            for (int j = low; j < high; j++) {
                if (arr[j] < pivotValue) {
                    i++;
                    swap(arr, i, j);
                }
            }
 
            // Swap the pivot element back to its final position
            swap(arr, i + 1, high);
 
            // Recursively sort the left and right subarrays
            sort(arr, low, i);
            sort(arr, i + 2, high);
        }
    }

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
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

    public static void main(String[] args) throws Exception {
        int arr[] = readFile("small_sorted.txt", 200);
        // int arr[] = readFile("small_random.txt", 200);
        // int arr[] = readFile("small_reversed.txt", 200);
        // int arr[] = readFile("medium_sorted.txt", 2000);
        // int arr[] = readFile("medium_random.txt", 2000);
        // int arr[] = readFile("medium_reversed.txt", 2000);
        // int arr[] = readFile("large_sorted.txt", 20000);
        // int arr[] = readFile("large_random.txt", 20000);
        // int arr[] = readFile("large_reversed.txt", 20000);

        sort(arr, 0, arr.length-1);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is kilobytes: "
                + memory / 1024L);
    }
} 

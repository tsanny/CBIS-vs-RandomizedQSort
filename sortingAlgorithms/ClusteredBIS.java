package sortingAlgorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class ClusteredBIS {
    public static int binaryLocFinder(int[] aList, int start, int end, int key) {
        if (start == end) {
            if (aList[start] > key) {
                return start;
            } else {
                return start + 1;
            }
        }
        if (start > end) {
            return start;
        } else {
            int middle = (start + end) / 2;
            if (aList[middle] < key) {
                return binaryLocFinder(aList, middle + 1, end, key);
            }
            if (aList[middle] > key) {
                return binaryLocFinder(aList, start, middle - 1, key);
            }
            return middle;
        }
    }

    public static int[] placeInserter(int[] aList, int start, int end) {
        int temp = aList[end];
        for (int k = end; k > start; k--) {
            aList[k] = aList[k - 1];
        }

        aList[start] = temp;
        return aList;
    }

    public static void sort(int[] aList) {
        int pop = 0;

        for (int i = 1; i < aList.length; i++) {
            int cop = i;
            int key = aList[cop];
            int place;

            if (key >= aList[pop]) {
                place = binaryLocFinder(aList, pop + 1, cop - 1, key);
            } else {
                place = binaryLocFinder(aList, 0, pop - 1, key);
            }

            pop = place;
            aList = placeInserter(aList, place, cop);
        }
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
        // int arr[] = readFile("small_sorted.txt", 200);
        // int arr[] = readFile("small_random.txt", 200);
        // int arr[] = readFile("small_reversed.txt", 200);
        // int arr[] = readFile("medium_sorted.txt", 2000);
        // int arr[] = readFile("medium_random.txt", 2000);
        // int arr[] = readFile("medium_reversed.txt", 2000);
        // int arr[] = readFile("large_sorted.txt", 20000);
        int arr[] = readFile("large_random.txt", 20000);
        // int arr[] = readFile("large_reversed.txt", 20000);

        sort(arr);
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is kilobytes: "
                + memory / 1024L);
    }
}

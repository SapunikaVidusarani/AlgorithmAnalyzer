package algorithmanalysis;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchAnalysis {

    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void runAnalysis() {
        int[] sizes = {100, 500, 1000};
        Random rand = new Random();

        System.out.println("Algorithm: Binary Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = rand.nextInt(10000);

            Arrays.sort(arr);
            int key = arr[rand.nextInt(size)];

            long startTime = System.nanoTime();
            binarySearch(arr, key);
            long endTime = System.nanoTime();

            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-11d | %.5f%n", size, timeMs);
        }
        System.out.println();
    }
}

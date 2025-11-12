package algorithmanalysis;

import java.util.Random;

public class LinearSearchAnalysis {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static void runAnalysis() {
        int[] sizes = {100, 500, 1000};
        Random rand = new Random();

        System.out.println("Algorithm: Linear Search");
        System.out.println("Input Size | Time (ms)");
        System.out.println("----------------------");

        for (int size : sizes) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = rand.nextInt(10000);

            int key = arr[rand.nextInt(size)];

            long startTime = System.nanoTime();
            linearSearch(arr, key);
            long endTime = System.nanoTime();

            double timeMs = (endTime - startTime) / 1_000_000.0;
            System.out.printf("%-11d | %.5f%n", size, timeMs);
        }
        System.out.println();
    }
}

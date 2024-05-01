import java.util.Random;
public class QuickSortTime {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Different values of n
        int[] nValues = {100, 500, 1000, 5000, 10000};

        for (int n : nValues) {
            int[] arr = generateRandomArray(n);
            long startTime = System.nanoTime();
            quickSort(arr, 0, arr.length - 1);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1000000; // Convert nanoseconds to milliseconds

            System.out.println("Time taken to sort " + n + " elements: " + duration + " milliseconds");
        }
    }

    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(1000); // Generate random numbers between 0 and 999
        }
        return arr;
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = {7,3,6,2,8,9,21,35,13,58,14,25};
        int[] arr2 = {7,3,6,2,8,9,21,35,13,58,14,25};

        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        quickSort(arr2);
        System.out.println(Arrays.toString(arr2));
	}
    
    public static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length - 1; i++) {
            for (int j=0; j<arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = partition(arr, low, high);
        sort(arr, low, mid-1);
        sort(arr, mid, high);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];

        while (low <= high) {
            while (arr[low] < pivot) low ++;
            while (arr[high] > pivot) high--;
            if (low <= high) {
                swap(arr, low, high);
                low++;
                high--;
            }
        }
        return low;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
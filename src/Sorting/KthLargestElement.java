package Sorting;

import java.util.Random;

/**
 * @author zr
 * @date 2021.10.24
 */
public class KthLargestElement {
    /**
     * @param arr : a sorted array
     * @param k   : k-th largest num
     */
    public static int findKthLargest(int[] arr, int k) {
        //todo
        for (int i = 0; i < k; i++) {
            heapInsert(arr, i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                swap(arr, 0, i);
                heapify(arr, 0, k);
            }
        }
        return arr[0];
    }

//    public static void heapSort(int[] arr) {
//        //建堆
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
//        //堆化
//        int heapSize = arr.length;
//        swap(arr, 0, --heapSize);
//        while (heapSize > 0) {
//            heapify(arr, 0, heapSize);
//            swap(arr, 0, --heapSize);
//        }
//    }

    public static void heapInsert(int[] arr, int index) {
        int par = (index - 1) / 2;
        while (par >= 0 && arr[index] < arr[par]) {
            swap(arr, index, par);
            index = par;
            par = (index - 1) / 2;
        }
        return arr[0];
    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int min = left + 1 < heapSize && arr[left] > arr[left + 1] ? left + 1 : left;
            min = arr[min] < arr[index] ? min : index;
            if (min == index) {
                break;
            } else {
                swap(arr, index, min);
                index = min;
                left = 2 * index + 1;
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(100);
        }
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        int x = random.nextInt(9);
        int a = 0, b = 0;
//        a = arr[x] > arr[x + 1] ? x + 1 : x;
//        b = arr[x] < arr[x + 1] ? x : x + 1;
//        System.out.print(a + " " + b);
//        heapSort(arr);
//        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        int res = findKthLargest(arr, 6);
        System.out.print(res);
    }
}

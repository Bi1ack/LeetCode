package Algorithm;


import java.util.Random;

public class Sort {
    /**
     * @author zr
     * @date 2021.10.20
     */

    public static int[] bubbleSort(int[] nums) {
        //后面省略
        if (nums == null || nums.length < 2) {
            return nums;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[minIndex] > nums[j]) minIndex = j;
            }
            if (minIndex != i) {
                swap(nums, i, minIndex);
            }
        }
        return nums;
    }

    public static int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i, temp = nums[i];
            while (j > 0 && temp < nums[j - 1]) nums[j] = nums[--j];
            nums[j] = temp;
        }
        return nums;
    }

    //O(n^1.3)
    public static int[] shellSort(int[] nums) {
        return nums;
    }

    public static int[] quickSort(int[] nums) {
        return qSort(nums, 0, nums.length - 1);
    }

    public static int[] qSort(int[] nums, int l, int r) {
        if (l < r) {
            int index = partition(nums, l, r);
            qSort(nums, l, index - 1);
            qSort(nums, index + 1, r);
        }
        return nums;
    }

    public static int partition(int[] nums, int l, int r) {
        int pivot = l;
        int index = pivot + 1;
        for (int i = index; i <= r; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, index, i);
                index++;
            }
        }
        swap(nums, index - 1, pivot);
        return index - 1;
    }

    // O(N * logN) 求解小和问题
    public static int[] mergeSort(int[] nums) {
        mSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mSort(int[] nums, int l, int r) {
        if (l < r) {
            int mid = l + ((r - l) >> 1);
            mSort(nums, l, mid);
            mSort(nums, mid + 1, r);
            merge(nums, l , mid, r);
        }
    }

    public static void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            temp[i++] = nums[p1] < nums[p2] ? nums[p1++] : nums[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = nums[p1++];
        }
        while (p2 <= r) {
            temp[i++] = nums[p2++];
        }

        for (int k = 0; k < temp.length; k++) {
            nums[l + k] = temp[k];
        }
    }

    public static int[] heapSort(int[] nums) {
        //优先级队列 == 最小堆
//        for (int i = 0; i < nums.length; i++) {
//            heapInsert(nums, i);
//        }
        for (int i = nums.length - 1; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
        int heapSize = nums.length;
        swap(nums, 0, --heapSize);
        while (heapSize > 0) {
            heapify(nums, 0, heapSize);
            swap(nums, 0, --heapSize);
        }
        return nums;
    }

//    public static void heapInsert(int[] nums, int index){
//        while (nums[index] < nums[(index - 1)/2]) {
//            swap(nums, index, (index - 1)/2);
//            index = (index - 1)/2;
//        }
//    }

    public static void heapify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            largest = nums[largest] > nums[index] ? largest : index;
            if (largest == index) {
                break;
            } else {
                swap(nums, largest, index);
                index = largest;
                left = 2 * index + 1;
            }
        }
    }

    public static int[] radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
        return arr;
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[L..R]排序  ,  最大值的十进制位数digit
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
            // 10个空间
            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是(0和1)的数字有多少个
            // count[2] 当前位(d位)是(0、1和2)的数字有多少个
            // count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix]; // count[0..9]
            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }
    }

    //得到d位上的数字
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }


    public static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] n = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            n[i] = random.nextInt(100);
        }
        for (int i : n) System.out.print(i + " ");
        System.out.println();
        int[] res;
        res = radixSort(n);
        for (int i : res) System.out.print(i + " ");
    }
}

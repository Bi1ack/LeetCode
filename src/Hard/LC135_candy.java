package Hard;

import java.util.Arrays;
import java.util.Random;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-02 11:06
 **/
public class LC135_candy {

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] help = new int[n];
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (ratings[i] < ratings[i - 1] && help[i] >= help[i - 1]) {
                help[i - 1] = help[i] + 1;
            } else if (ratings[i] > ratings[i - 1] && help[i] <= help[i - 1]){
                help[i] = help[i - 1] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1] && help[i] >= help[i - 1]) {
                help[i - 1] = help[i] + 1;
            } else if (ratings[i] > ratings[i - 1] && help[i] <= help[i - 1]){
                help[i] = help[i - 1] + 1;
            }
            sum += help[i];
        }
        sum += help[0];
        return sum + n;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 8, 7, 4, 2, 3, 4, 0, 0, 0};
        int[] arr = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(10);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(candy(arr));
    }
}

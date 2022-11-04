package JavaBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: LeetCode
 * @description: Java基础学习
 * @author: zr
 * @date: 2021-12-04 15:58
 **/
public class javaBasic {
    public static int maxLoss(int[] arr) {
        int ans = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] > arr[i]) {
                ans += (arr[i - 1] - arr[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {

    }
}

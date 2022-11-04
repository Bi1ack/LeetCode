import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: zr
 * @date: 2022-07-16 11:07
 **/
public class Test {
    public static void main(String[] args) {
        //String[] nums = {"64333639502", "65953866768", "17845691654", "87148775908", "58954177897", "70439926174", "48059986638", "47548857440", "18418180516", "06364956881", "01866627626", "36824890579", "14672385151", "71207752868"};
        String s = "lee";
        System.out.println(reverseString(s, 11237, 912));
    }

    public static String reverseString(String s, int N, int K) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < N - K + 1; ++i) {
            int start = i;
            int end = Math.min(i + K - 1, s.length() - 1);
            while (start < end) {
                char c = sb.charAt(end);
                sb.setCharAt(end, sb.charAt(start));
                sb.setCharAt(start, c);
                ++start;
                --end;
            }
        }
        return sb.toString();
    }


}

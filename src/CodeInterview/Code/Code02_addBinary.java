package CodeInterview.Code;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-04-20 10:38
 **/
public class Code02_addBinary {

    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0 || carry != 0) {
            int sum;
            int ai = i >= 0? a.charAt(i) - '0' : 0;
            int bi = j >= 0? b.charAt(j) - '0' : 0;
            sum = (ai + bi + carry) % 2;
            carry = (ai + bi + carry) / 2;
            sb.append(sum);
            --i;
            --j;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "0";
        String b = "1";
        System.out.println(addBinary(a, b));
    }
}

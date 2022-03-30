package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-29 09:53
 **/
public class Code20_isNumber {

    public static boolean isNumber(String s) {
        // 有错 “ -.”测试不通过
        // 从 e 开始把 s1 分开， 判断前后是否是整数或小数
        s = s.trim();
        if (s.length() == 1 && (s.charAt(0) < '0' || s.charAt(0) > '9'))
            return false;
        if (s.contains("e") && s.contains("E")) return false;
        String[] s1;
        if (s.contains("e")) {
            if (s.indexOf("e") != s.lastIndexOf("e"))
                return false;
            s1 = s.split("e");
        } else if (s.contains("E")) {
            if (s.indexOf("E") != s.lastIndexOf("E"))
                return false;
            s1 = s.split("E");
        } else {
            s1 = new String[]{s};
        }
        if ((s.contains("e") || s.contains("E")) && s1.length != 2) return false;
        for (int i = 0; i < s1.length; ++i) {
            if (s1[i].length() == 0) return false;

            if (s1[i].contains(".")) {
                if (i != 0 || !isDecimal(s1[i]))
                    return false;
            } else {
                if (!isInteger(s1[i]))
                    return false;
            }
        }
        return true;
    }

    public static boolean isDecimal(String s) {

        if (s.split("\\.").length > 2 || s.split("\\.").length == 0) return false;

        boolean flag = false;
        for (int i = 0; i < s.length(); ++i) {
            if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-'))
                continue;
            if (!flag && s.charAt(i) == '.' && i != s.length() - 1) {
                flag = true;
                continue;
            }
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        }
        return true;
    }

    public static boolean isInteger(String s) {
        if (s.length() == 1 && (s.charAt(0) < '0' || s.charAt(0) > '9'))
            return false;
        for (int i = 0; i < s.length(); ++i) {
            if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-'))
                continue;
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "7e69e";
        System.out.println(isNumber(s));
        String[] ss = s.split("\\.");
        System.out.println(ss.length);
        for (String s1 : ss) {
            System.out.println(s1);
        }
    }
}

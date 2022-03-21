package Hot;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-21 14:14
 **/
public class LC394_DecodeString {

    int ptr;

    public String decodeString(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }

        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    public static String decodeString_ (String s) {

        StringBuffer sb = new StringBuffer(s);
        int idx = sb.lastIndexOf("[");
        while (idx != -1) {
            int end = idx + 1;
            StringBuffer sb1 = new StringBuffer();
            while (sb.charAt(end) != ']') {
                ++end;
            }
            int cnt = 1;
            while (idx >= cnt && Character.isDigit(s.charAt(idx - cnt))) {
                ++cnt;
            }
            int rep = Integer.parseInt(s.substring(idx - cnt + 1, idx));
            for (int j = 0; j < rep; ++j) {
                sb1.append(sb.substring(idx + 1, end));
            }
            sb.replace(idx - cnt + 1, end + 1, sb1.toString());
            idx = sb.lastIndexOf("[");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String s = "2[ac2[d]]";
        System.out.println(decodeString_(s));
    }

}

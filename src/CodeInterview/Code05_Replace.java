package CodeInterview;

/**
 * @program: LeetCode
 * @description:
 * @author: Ray
 * @date: 2022-03-25 10:42
 **/
public class Code05_Replace {

    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                sb.append(c);
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

}

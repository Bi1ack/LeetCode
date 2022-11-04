package JavaBasic;

/**
 * @program: LeetCode
 * @description: Integer常量池
 * @author: zr
 * @date: 2021-12-04 16:09
 **/
public class integerTest {

    public static void main(String[] args) {

        Integer a0 = 40;
        Integer b0 = 40;
        // 来自常量池的同一对象
        //as

        // true
        System.out.println(a0 == b0);

        Integer a = 40;
        Integer b = new Integer(40);
        // a 来自常量池， b 新创建的对象
        // false
        System.out.println(a == b);

        Integer a1 = 200;
        Integer b1 = 200;
        // 超出常量池范围， 两个新的对象
        // false
        System.out.println(a1 == b1);

        // note
        // Character [0, 127]
        // Boolean true / false
        // Float Double 无常量池

    }
}

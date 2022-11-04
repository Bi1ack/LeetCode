package Interview;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author: zr
 * @date: 2022-08-26 11:28
 **/
public class ThreadExample {
    public static void main(String[] args) {
//        ThreadPoolExecutor te =
//                new ThreadPoolExecutor(
//                        5,
//                        10,
//                        1,
//                        TimeUnit.HOURS,
//                        new LinkedBlockingQueue(100),
//                        new ThreadPoolExecutor.DiscardPolicy());

        StringBuffer sb = new StringBuffer("1221");
        sb.insert(2, 3 * 10 + 3);
        //sb.insert(2, 3);
        System.out.println(sb);
    }


}

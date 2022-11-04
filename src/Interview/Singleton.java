package Interview;

/**
 * @author: zr
 * @date: 2022-08-21 21:27
 **/
public class Singleton {

    private static volatile Singleton instance;
    private Singleton(){}

    public Singleton newInstance() {
        if(instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

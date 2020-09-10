package 面试中的算法.单例模式;

/**
 * @author lupeng11@meituan.com
 * @date 2020/7/25 21:21
 */
public class DoubleCheckedSingleObject {

    private static volatile DoubleCheckedSingleObject instance;

    private DoubleCheckedSingleObject() {
    }

    ;

    public static DoubleCheckedSingleObject getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleObject.class) {
                if (instance == null) {
                    instance = new DoubleCheckedSingleObject();
                }
            }
        }
        return instance;
    }
}

package 面试中的算法.单例模式;

/**
 * @author lupeng11@meituan.com
 * @date 2020/7/25 20:59
 */
public class SingleObject {

    private static SingleObject instance = new SingleObject();

    private SingleObject() {
    }

    ;

    public static SingleObject getInstance() {
        return instance;
    }

}

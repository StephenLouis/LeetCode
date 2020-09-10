/**
 * @author lupeng11@meituan.com
 * @date 2020/8/11 17:40
 */
public class SingleObject {

  private volatile static SingleObject singleObject;

  private SingleObject() {
  }

  ;

  public static SingleObject getInstance() {
    if (singleObject == null) {
      synchronized (SingleObject.class) {
        if (singleObject == null) {
          SingleObject singleObject = new SingleObject();
        }

      }
    }
    return singleObject;
  }


}

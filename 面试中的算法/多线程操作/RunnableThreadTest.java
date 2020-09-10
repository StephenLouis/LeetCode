package 面试中的算法.多线程操作;

public class RunnableThreadTest implements Runnable{
    public static void main(String[] args) {

        RunnableThreadTest rtt = new RunnableThreadTest();
        new Thread(rtt).start();
        new Thread(rtt).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+ " "+i);
        }
    }
}

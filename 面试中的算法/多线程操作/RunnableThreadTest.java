package 面试中的算法.多线程操作;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableThreadTest implements Runnable {

    private final ReentrantLock reentrantLock;
    private final Condition thisConditin;
    private final Condition nextConditin;
    // 用static修饰后变成类之间共享的；所有改类的所有实例共用一个；
    private static int i = 0;

    public RunnableThreadTest(ReentrantLock reentrantLock, Condition thisConditin, Condition nextConditin) {
        this.reentrantLock = reentrantLock;
        this.thisConditin = thisConditin;
        this.nextConditin = nextConditin;
    }


    @Override
    public void run() {
        try {
            reentrantLock.lock();
            while (i < 11) {

                System.out.println(Thread.currentThread().getName() + " " + i++);
                nextConditin.signal();


                try {
                    thisConditin.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        } finally {
            reentrantLock.unlock();

        }

    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        Condition condition3 = lock.newCondition();
        int i = 0;


        Thread a = new Thread(new RunnableThreadTest(lock, condition1, condition2));
        a.setName("线程1：");
        Thread b = new Thread(new RunnableThreadTest(lock, condition2, condition3));
        b.setName("线程2：");
        Thread c = new Thread(new RunnableThreadTest(lock, condition3, condition1));
        c.setName("线程3：");

        a.start();
        Thread.sleep(100);
        b.start();
        Thread.sleep(100);
        c.start();


    }
}

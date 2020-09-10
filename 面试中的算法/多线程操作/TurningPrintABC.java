package 面试中的算法.多线程操作;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TurningPrintABC implements Runnable{

    private static final int PRINT_COUNT = 10;
    private final ReentrantLock reentrantLock;
    private final Condition thisCondition;
    private final Condition nextCondition;
    private final char printChar;

    public TurningPrintABC(ReentrantLock reentrantLock, Condition thisCondition, Condition nextCondition, char printChar) {
        this.reentrantLock = reentrantLock;
        this.thisCondition = thisCondition;
        this.nextCondition = nextCondition;
        this.printChar = printChar;
    }


    @Override
    public void run() {
        reentrantLock.lock();
        try {
            for (int i = 0; i < PRINT_COUNT; i++) {
                System.out.println(printChar);
                nextCondition.signal();
                if (i < PRINT_COUNT - 1) {
                    try {
                        // 本线程让出锁并等待唤醒
                        thisCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();

        // 实例化线程
        Thread a = new Thread(new TurningPrintABC(lock, conditionA, conditionB, 'A'));
        Thread b = new Thread(new TurningPrintABC(lock, conditionB, conditionC, 'B'));
        Thread c = new Thread(new TurningPrintABC(lock, conditionC, conditionA, 'C'));

        a.start();
        Thread.sleep(100);
        b.start();
        Thread.sleep(100);
        c.start();


    }
}

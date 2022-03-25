package com.wyl.singleton;

/**
 * Author:yanl.wang
 * Date:2022/3/25 22:55
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            /**
             * 第一个线程来了为空，先暂停。第二个线程来了依然为空。第二个线程申请锁，
             * 持有这把锁，new了对象，释放锁。
             * 第一个线程继续，持有锁new对象，返回。
             * 根源问题就是一个线程在上锁当中，另一个线程已经把值new了出来
             * 妄图通过减小同步代码块的方式提高效率，然后不行
             */
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Mgr05.class) {
                INSTANCE = new Mgr05();
            }
        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
    }
}

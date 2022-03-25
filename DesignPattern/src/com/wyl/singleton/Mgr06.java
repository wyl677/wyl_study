package com.wyl.singleton;

/**
 * Author:yanl.wang
 * Date:2022/3/25 23:00
 */
public class Mgr06 {
    private static Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //双重检查
            /**
             * Double Check Lock
             * 上锁是要消耗资源的，要竞争。如果不判断空先抢锁，有1万线程抢锁，
             * 最后其实1个线程new出了对象，但是1万个线程都要竞争锁。
             */
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
    }
}

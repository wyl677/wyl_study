package com.wyl.singleton;

/**
 * Author:yanl.wang
 * Date:2022/3/25 23:00
 *
 * 为啥要加volatile thread1半初始化 (0 new #2 <T> )m=0
 * 时发生了指令重排序 (7 astore_1和 4 invokespecial #3 <T.<init>>) thread2 if(t != null) xxx -> 使用了半初始化状态的对象。
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE;

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

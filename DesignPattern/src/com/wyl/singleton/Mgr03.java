package com.wyl.singleton;

/**
 * Author:yanl.wang
 * Date:2022/3/22 21:51
 * lazy loading
 * <p>
 * 懒汉试
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03() {
    }

    public static Mgr03 getInstance() {
        if (INSTANCE == null) {//第一个线程来了，你是不是空。第二个线程来了，你是不是依然为空。两个线程同时进入执行
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Mgr03.getInstance().hashCode());
            }).start();
        }

    }
}

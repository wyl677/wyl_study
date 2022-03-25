package com.wyl.singleton;

/**
 * Author:yanl.wang
 * Date:2022/3/25 23:08
 * 静态内部类方式
 * 在内部类被加载和初始化时，才创建INSTANCE实例对象
 * 静态内部类不会自动随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 用的时候才会加载和初始化
 * 因为是在内部类加载和初始化时创建的，因此是线程安全的，(是类加载器对他加载的)
 */
public class Mgr07 {
    private Mgr07(){}

    private static class Mgr07Holder{
        private static final Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}

package com.wyl.principle.singleresponsibility;

/**
 * Author:yanl.wang
 * Date:2022/3/15 0:24
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle3 vehicle3 = new Vehicle3();
        vehicle3.run("汽车");
        vehicle3.runWater("轮船");
        vehicle3.runAir("飞机");
    }
}

//方式3
//
class Vehicle3{
    public void run(String vehicle){
        System.out.println(vehicle + "在公里上运行....");
    }

    public void runAir(String vehicle){
        System.out.println(vehicle + "在天空上运行....");
    }

    public void runWater(String vehicle){
        System.out.println(vehicle + "在水中运行....");
    }
}

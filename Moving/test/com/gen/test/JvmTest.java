package com.gen.test;

import java.io.IOException;

/**
 * 对象分配调节 && 垃圾回收
 * link:https://blog.csdn.net/qq_33745799/article/details/89143712
 * @author Genge
 */
public class JvmTest {
    private static  final int _1MB=1024*1024;

    /**
     * 对象优先在Eden分配
     * 参数：-verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8
     */
    public static void testAllocation() {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2* _1MB];
        allocation2 = new byte[2* _1MB];
        allocation3 = new byte[2* _1MB];
        allocation4 = new byte[4* _1MB];
    }

    /**
     * 大对象直接进入老年代
     *参数：-verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4*_1MB];
    }

    /**
     * 长期存活的对象将进入老年代
     * 参数：-verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8
     */
    public static void testMaxTenuredThreshold() {
        byte[] allocation1;
        byte[] allocation2;
        byte[] allocation3;
        byte[] allocation4;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * 动态年龄判定 && 空间分配担保
     * 参数：-verbose:gc -XX:+PrintGCDetails -XX:+UseSerialGC -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:TargetSurvivorRatio=95
     */
    public static void testMaxTenuredThreshold2() {
        byte[] allocation1;
        byte[] allocation2;
        byte[] allocation3;
        byte[] allocation4;

        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];

    }

    public static void main(String[] args) throws IOException {
        testMaxTenuredThreshold2();
    }

}

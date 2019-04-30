package com.gen.test;

import com.gen.design.mode.DaoUser;
import com.gen.design.mode.DaoUserProxy;
import com.gen.design.mode.IdaoUser;
import com.gen.design.mode.ProxyFactory;

public class DaoTest {
    public static void main(String[] args) {
        IdaoUser target = new DaoUser();
        System.out.println("原始目标对象："+target.getClass());
        IdaoUser proxy = (IdaoUser) new ProxyFactory(target).getProxyInstance();
        System.out.println("内存中代理对象："+proxy.getClass());

        proxy.save();
        int a = 1;
        float b = 1.2f;
        double c = 1.3f;
//        float d = 1.2d;
        double e = 1.3d;
        long f = 2l;
        double g = 1.2f;
        long   l = 11;
        System.out.println(l);
        System.out.println("g = "+g);
        System.out.println("b = "+b+";; c = "+ c + ";;e = "+e+";;f = "+ f);
    }
}

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
    }
}

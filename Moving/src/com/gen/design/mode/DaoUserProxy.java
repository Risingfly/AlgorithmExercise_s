package com.gen.design.mode;

/**
 * 静态代理模式之代理类
 *
 * @author Genge
 */
public class DaoUserProxy implements IdaoUser {
    private DaoUser target;
    public DaoUserProxy(DaoUser target){
        this.target = target;
    }
    @Override
    public void save() {
        System.out.println("开始事务");
        target.save();
        System.out.println("提交事务");
    }
}

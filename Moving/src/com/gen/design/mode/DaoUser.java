package com.gen.design.mode;

/****
 *静态代理模式之目标类
 *
 * @author Genge
 */
public class DaoUser implements IdaoUser {
    @Override
    public void save() {
        System.out.println("-------已经保存数据--------");
    }
}

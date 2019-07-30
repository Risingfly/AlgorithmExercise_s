package com.gen.design.mode.sfactory;

/**
 * 简单工厂模式
 * 核心思路:工厂里创建的类需要实现共同的接口,工厂在创建时根据传入的实例名称,创建对应的对象
 *静态工厂模式(将上述方法改为静态方法)
 * 使用场景:需要创建的对象较少,客户端不关心对象的创建过程
 * @author Genge
 */
public class SimpleFactory {
    public DrawlTools getTools(String toolName){
        if (toolName.equals("Triangle")){
            return new Triangle();
        }
        if (toolName.equals("Circle")){
            return new Circle();
        }
        return null;
    }
}

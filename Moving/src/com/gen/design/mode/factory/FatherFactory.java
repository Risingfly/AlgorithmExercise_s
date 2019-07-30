package com.gen.design.mode.factory;

/**
 * 工厂模式
 * 核心思路:在简单工厂模式上进一步改进,每个实例对应一个工厂且这些工厂实现共同的基类工厂接口,
 * 每个工厂生产对应的实例
 * 抽象工厂模式(相当于工厂里生产的东西增加了,不止一样,比如除了生产工具还能生产炸弹啥的)
 *使用场景:客户端不需要知道它所创建的对象的类,可以通过子类来指定创建对应的对象
 * @author Genge
 */
public interface FatherFactory {
    DrawlTools getTools();
}

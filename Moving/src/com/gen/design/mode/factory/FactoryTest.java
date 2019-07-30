package com.gen.design.mode.factory;

public class FactoryTest {
    public static void main(String[] args) {
        FatherFactory factory = new TriangleFacoty();
        factory.getTools().draw();
        FatherFactory factory1 = new CircleFactory();
        Circle circle = (Circle) factory1.getTools();
        circle.draw();
    }
}

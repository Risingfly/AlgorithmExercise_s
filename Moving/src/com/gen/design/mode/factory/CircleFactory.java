package com.gen.design.mode.factory;

public class CircleFactory implements FatherFactory {
    @Override
    public DrawlTools getTools() {
        return new Circle();
    }
}

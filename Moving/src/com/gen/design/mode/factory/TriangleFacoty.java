package com.gen.design.mode.factory;

public class TriangleFacoty implements FatherFactory {
    @Override
    public DrawlTools getTools() {
        return new Triangle();
    }
}

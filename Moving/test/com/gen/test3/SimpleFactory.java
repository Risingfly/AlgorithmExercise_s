package com.gen.test3;

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

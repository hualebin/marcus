package com.marcus.designPattern.composite;

public class Button extends Component{

    public Button(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.printf("print %s(%s)\n", getClass().getSimpleName(), getName());
    }

}

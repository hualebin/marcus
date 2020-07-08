package com.marcus.designPattern.composite;

public class Picture extends Component{

    public Picture(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.printf("print %s(%s)\n", getClass().getSimpleName(), getName());
    }
}

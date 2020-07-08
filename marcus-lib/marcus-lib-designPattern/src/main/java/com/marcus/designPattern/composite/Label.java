package com.marcus.designPattern.composite;

public class Label extends Component {

    public Label(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.printf("print %s(%s)\n", getClass().getSimpleName(), getName());
    }

}

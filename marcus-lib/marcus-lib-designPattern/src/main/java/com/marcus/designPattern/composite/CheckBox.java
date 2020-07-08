package com.marcus.designPattern.composite;

public class CheckBox extends Component {

    public CheckBox(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.printf("print %s(%s)\n", getClass().getSimpleName(), getName());
    }

}

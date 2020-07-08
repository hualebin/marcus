package com.marcus.designPattern.composite;

public class PasswordBox extends Component {

    public PasswordBox(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.printf("print %s(%s)\n", getClass().getSimpleName(), getName());
    }

}

package com.marcus.designPattern.composite;


public class TextBox extends Component {

    public TextBox(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.printf("print %s(%s)\n", getClass().getSimpleName(), getName());
    }

}

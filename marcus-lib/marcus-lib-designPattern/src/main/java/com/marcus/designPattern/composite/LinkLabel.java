package com.marcus.designPattern.composite;

public class LinkLabel extends Component {

    public LinkLabel(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.printf("print %s(%s)\n", getClass().getSimpleName(), getName());
    }

}
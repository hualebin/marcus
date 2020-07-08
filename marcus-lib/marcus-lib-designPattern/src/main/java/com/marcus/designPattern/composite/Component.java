package com.marcus.designPattern.composite;

public abstract class Component {

    private String name;

    protected Component(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void print();

}

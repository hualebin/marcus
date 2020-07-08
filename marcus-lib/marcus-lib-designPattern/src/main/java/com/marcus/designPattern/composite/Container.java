package com.marcus.designPattern.composite;

import java.util.ArrayList;
import java.util.List;

public class Container extends Component {

    private List<Component> components = new ArrayList<>();

    public Container(String name) {
        super(name);
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public Component getComponent(int n) {
        try {
            return components.get(n);
        } catch (IndexOutOfBoundsException z) {
            throw new ArrayIndexOutOfBoundsException("No such child: " + n);
        }
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public void print() {
        System.out.printf("print %s(%s)\n", getClass().getSimpleName(), getName());
        printComponents();
    }

    public void printComponents() {
        for (Component component : components) {
            component.print();
        }
    }
}

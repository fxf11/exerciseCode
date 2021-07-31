package com.fxf.option;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/31 15:32
 */
public class Gril {

    private String name;

    public Gril() {
    }

    public Gril(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Gril{" +
                "name='" + name + '\'' +
                '}';
    }
}

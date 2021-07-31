package com.fxf.option;

/**
 * @author 饭小范
 * @version 1.0
 * @description: TODO
 * @date 2021/7/31 15:31
 */
public class Boy {

    private Gril gril;

    public Boy() {
    }

    public Boy(Gril gril) {
        this.gril = gril;
    }

    public Gril getGril() {
        return gril;
    }

    public void setGril(Gril gril) {
        this.gril = gril;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "gril=" + gril +
                '}';
    }
}

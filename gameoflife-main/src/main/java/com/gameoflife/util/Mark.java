package com.gameoflife.util;

/**
 * Created with IntelliJ IDEA.
 * User: eatttth
 * Date: 10/31/12
 * Time: 4:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mark {
    public Mark(int x, int y, int value) {
        this.x=x;
        this.y=y;
        this.value=value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }

    private int x;
    private int y;
    private int value;
}

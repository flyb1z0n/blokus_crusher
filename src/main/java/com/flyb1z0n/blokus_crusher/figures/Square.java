package com.flyb1z0n.blokus_crusher.figures;

public class Square {

    private static final int[][] figure = new int[][]{
        {1, 1},
        {1, 1}
    };

    public int[][] getFigure() {
        return figure;
    }

    public int getLength() {
        return figure.length;
    }

    public int getWidth() {
        return figure[0].length;
    }
}

package com.flyb1z0n.blokus_crusher.board;

public enum Color {

    GRAY(java.awt.Color.GRAY),
    RED(java.awt.Color.RED),
    BLUE(java.awt.Color.BLUE),
    GREEN(java.awt.Color.GREEN),
    YELLOW(java.awt.Color.YELLOW);

    public final java.awt.Color awtColor;

    Color(java.awt.Color awtColor) {
        this.awtColor = awtColor;
    }
}

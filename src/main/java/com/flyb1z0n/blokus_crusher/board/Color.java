package com.flyb1z0n.blokus_crusher.board;

public enum Color {

    WHITE(java.awt.Color.WHITE),
    GRAY(java.awt.Color.GRAY),
    RED(java.awt.Color.RED),
    BLUE(java.awt.Color.BLUE),
    GREEN(java.awt.Color.GREEN),
    YELLOW(java.awt.Color.YELLOW),

    BLACK(java.awt.Color.BLACK);

    public final java.awt.Color awtColor;

    Color(java.awt.Color awtColor) {
        this.awtColor = awtColor;
    }
}

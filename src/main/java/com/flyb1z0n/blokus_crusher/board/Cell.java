package com.flyb1z0n.blokus_crusher.board;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cell {
    public static final int EMPTY = -1;
    private Color color;
    private int figureId = EMPTY;

    public Cell() {
        this.color = Color.GRAY;
    }

    public Cell(Color color) {
        this.color = color;
    }
}

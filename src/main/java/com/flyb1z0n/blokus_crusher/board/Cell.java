package com.flyb1z0n.blokus_crusher.board;

import com.flyb1z0n.blokus_crusher.figures.FigureType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Cell {
    public static final int EMPTY = -1;
    private Color color;

    private FigureType type = FigureType.NONE;

    public Cell() {
        this.color = Color.GRAY;
    }

    public Cell(Color color) {
        this.color = color;
    }

}

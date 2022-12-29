package com.flyb1z0n.blokus_crusher;

import com.flyb1z0n.blokus_crusher.board.Board;
import com.flyb1z0n.blokus_crusher.board.Cell;
import com.flyb1z0n.blokus_crusher.board.Color;
import com.flyb1z0n.blokus_crusher.render.Window;


public class Main {
    public static void main(String[] args) {
        var board = new Board(10, 10);
        board.setCell(0,1, new Cell(Color.RED));
        Window w = new Window(board);
    }
}
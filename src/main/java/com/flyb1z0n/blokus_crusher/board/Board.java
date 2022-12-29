package com.flyb1z0n.blokus_crusher.board;

public class Board {
    private Cell[][] board;
    public final int width;
    public final int height;

    public Board(int height, int width) {
        this.width = width;
        this.height = height;
        board = new Cell[height][width];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setCell(int x, int y, Cell cell) {
        board[x][y] = cell;
    }
}

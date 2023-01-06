package com.flyb1z0n.blokus_crusher.board;

/**
 * Game board
 */
public class Board {
    private Cell[][] board;
    public final int width;
    public final int height;

    public Board(int height, int width) {
        this.width = width;
        this.height = height;
        board = new Cell[height+2][width+2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // paint
                if(i == 0 || j == 0 || i == board.length-1 || j == board[i].length -1) {
                    board[i][j] = new Cell(Color.WHITE);
                    continue;
                }
                board[i][j] = new Cell();
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }


    public int getRenderHeight(){
        return board.length;
    }

    public int getRenderWidth(){
        return board[0].length;
    }

    public void setCell(int x, int y, Cell cell) {
        board[y+1][x+1] = cell;
    }
}

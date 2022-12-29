package com.flyb1z0n.blokus_crusher.render;

import com.flyb1z0n.blokus_crusher.board.Board;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class Window {

    private final int CELL_SIZE = 20;

    private Canvas canvas;
    public Window(Board board) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                System.out.println("Error setting native LAF: " + ex);
            }

            JFrame frame = new JFrame("Testing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setLayout(new BorderLayout());
            canvas = new Canvas(board);
            frame.add(canvas);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }


    public void repaint(Board board){
        canvas.setBoard(board);
        canvas.repaint();
    }

    @Setter
    public class Canvas extends JPanel {

        private Board board;

        public Canvas(Board board) {
            this.board = board;
        }


        @Override
        public Dimension getPreferredSize() {
            return new Dimension(board.width*CELL_SIZE, board.height*CELL_SIZE);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (int i = 0; i < board.height; i++) {
                for (int j = 0; j < board.width; j++) {
                    g.setColor(board.getBoard()[i][j].getColor().awtColor);
                    g.fillRect(i*CELL_SIZE, j*CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }
    }
}

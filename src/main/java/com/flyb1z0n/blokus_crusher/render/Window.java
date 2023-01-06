package com.flyb1z0n.blokus_crusher.render;

import com.flyb1z0n.blokus_crusher.board.Board;
import com.flyb1z0n.blokus_crusher.board.Color;
import lombok.Setter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;


public class Window {

    private final int CELL_SIZE = 50;
    private final int BORDER_SIZE = 5;

    private Canvas canvas;
    public Window(Board board) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                     UnsupportedLookAndFeelException ex) {
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

        private int renderWidth;
        private int renderHeight;

        public Canvas(Board board) {
            this.board = board;
            renderWidth = board.getRenderWidth()*CELL_SIZE + (board.getRenderWidth()+1)*BORDER_SIZE;
            renderHeight = board.getRenderHeight()*CELL_SIZE + (board.getRenderHeight()+1)*BORDER_SIZE;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(renderWidth, renderHeight);
        }

        @Override
        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);

            // refill background
            g.setColor(getBackground());
            g.fillRect(0, 0, renderWidth, renderHeight);

            // render boarder default
//            g.setColor(Color.BLACK.awtColor);
//            var padding = CELL_SIZE + BORDER_SIZE;
//            g.fillRect(padding, padding, renderWidth- 2*padding, renderHeight - 2*padding);

            // render cells
            for (int y = 0; y < board.getRenderHeight(); y++) {
                for (int x = 0; x <  board.getRenderWidth(); x++) {
                    var color = board.getBoard()[y][x].getColor().awtColor;
                    g.setColor(color);
                    g.fillRect(x*CELL_SIZE + (x+1)*BORDER_SIZE, y*CELL_SIZE +  (y+1)*BORDER_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }

            // render boarders
            for (int y = 1; y < board.getRenderHeight()-1; y++) {
                for (int x = 1; x <  board.getRenderWidth()-1; x++) {
                   // render left boarder
                    g.setColor(Color.BLACK.awtColor);
                    //left border
                    renderCellBorder(x, y, x-1, y,
                            (midX, midY) -> g.fillRect(midX*(CELL_SIZE+ BORDER_SIZE), midY*(CELL_SIZE+ BORDER_SIZE), BORDER_SIZE, CELL_SIZE+2*BORDER_SIZE));
                    //right border
                    renderCellBorder(x, y, x+1, y,
                            (midX, midY) -> g.fillRect((midX+1)*(CELL_SIZE+ BORDER_SIZE), midY*(CELL_SIZE+ BORDER_SIZE), BORDER_SIZE, CELL_SIZE+2*BORDER_SIZE));
                    //top border
                    renderCellBorder(x, y, x, y-1,
                            (midX, midY) -> g.fillRect(midX*(CELL_SIZE+ BORDER_SIZE), midY*(CELL_SIZE+ BORDER_SIZE), CELL_SIZE+2*BORDER_SIZE, BORDER_SIZE));

                    //bottom border
                    renderCellBorder(x, y, x, y+1,
                            (midX, midY) -> g.fillRect(midX*(CELL_SIZE+ BORDER_SIZE), (midY +1)*(CELL_SIZE+ BORDER_SIZE), CELL_SIZE+2*BORDER_SIZE, BORDER_SIZE));


//                    renderCellBorder(x, y, x-1, y,
//                            (midX, midY) -> g.fillRect(midX*(CELL_SIZE+ BORDER_SIZE), midY*(CELL_SIZE+ BORDER_SIZE), BORDER_SIZE, CELL_SIZE+2*BORDER_SIZE));
//                    renderCellBorder(x, y, x-1, y,
//                            (midX, midY) -> g.fillRect(midX*(CELL_SIZE+ BORDER_SIZE), midY*(CELL_SIZE+ BORDER_SIZE), BORDER_SIZE, CELL_SIZE+2*BORDER_SIZE));
                }
            }
        }

        private void renderCellBorder(int midX, int midY, int targetX, int targetY, BorderRender renderFunction) {
            var midCell = board.getBoard()[midY][midX];
            var leftCell = board.getBoard()[targetY][targetX];
            if(midCell.getColor() != leftCell.getColor() || midCell.getType() != leftCell.getType()){
                renderFunction.renderBorder(midX, midY);
            }
        }
//        private void renderLeftCellBorder(Graphics g, int x, int y) {
//            var midCell = board.getBoard()[y][x];
//            var leftCell = board.getBoard()[y][x-1];
//
//            if(midCell.getColor() != leftCell.getColor() || midCell.getType() != leftCell.getType()){
//                g.setColor(Color.BLACK.awtColor);
//                g.fillRect(x*(CELL_SIZE+ BORDER_SIZE), y*(CELL_SIZE+ BORDER_SIZE), BORDER_SIZE, CELL_SIZE+2*BORDER_SIZE);
//            }
//
//        }
    }

    private interface BorderRender {
        void renderBorder(int x, int y);
    }
}

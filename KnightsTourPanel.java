import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

/*
 * This class will be the display and will get the starting position
 * of the knight using a mousePress.  It should also have the data
 * like the 2D array and the current location of the knight.  The
 * paintComponent method should redraw the view from the beginning, as it
 * always should.
 */

public class KnightsTourPanel extends JPanel {

    // This is a test to check if I can commit changes

    // what private data is needed?

    private static Cell[][] cellzz = new Cell[8][8];
    Timer t;
    Knight nite;
    boolean isClickedShowSqr;
    JButton randomMove;
    JButton randLong;


    public KnightsTourPanel(int w, int h) {
        this.setPreferredSize(new Dimension(w, h));
        this.setBackground(Color.WHITE);
//        addMouseListener();
        init();
        nite = new Knight(3, 4);
        isClickedShowSqr = false;
    }

    private void init() {
        boolean color = true;
        for (int r = 0; r < cellzz.length; r++) {
            for (int c = 0; c < cellzz[0].length; c++) {
                if (color) {
                    color = !color;
                    cellzz[r][c] = new Cell(r, c, Color.lightGray);

                } else {
                    color = !color;
                    cellzz[r][c] = new Cell(r, c, Color.darkGray);

                }
            }
            color = !color;
        }

        //init random move button
        randomMove = new JButton();
        randomMove.setText("Random Move");
        randomMove.setBounds(20, 550, 175, 45);
        randomMove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPossibleSquares(nite.getRow(), nite.getCol());
                repaint();
            }
        });
        this.setLayout(null);
        add(randomMove);
        randomMove.setVisible(true);

        randLong = new JButton();
        randLong.setText("Moves");
        randLong.setBounds(220, 550, 175, 45);
        randLong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                t.start();
            }
        });
        this.setLayout(null);
        add(randLong);
        randLong.setVisible(true);


        t = new Timer(800, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    randomMove.doClick();
                }
                catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }


    // add the mouse listener.  This will only work for the
    // first click, and then after the first click, there should
    // be no more mouse listening!
//    private void addMouseListener() {
//        this.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int x = e.getX();
//                int y = e.getY();
//                int row = ((y + 1) / 50);
//                int col = ((x + 1) / 50);
//                System.out.println(row + " " + col);
//                if (row == nite.getRow() && col == nite.getCol()) {
//
//                    showPossibleSquares(row, col);
//
//                }
//            }
//        });
//    }

    Timer z;

    public void showPossibleSquares(int r, int c) {
        z = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetBoard();
                z.stop();
            }
        });
        ArrayList<Cell> rowsCol = new ArrayList<Cell>();
        boolean boolar = false;
        for (int i = 0; i < Knight.rows.length; i++) {
            int checkRow = r - Knight.rows[i];
            int checkCol = c - Knight.cols[i];

            if (checkRow >= 0 && checkRow < cellzz.length && checkCol >= 0 && checkCol < cellzz[i].length && !isClickedShowSqr) {
                cellzz[checkRow][checkCol].setColor(Color.YELLOW);
                rowsCol.add(cellzz[checkRow][checkCol]);
                boolar = true;

            } else if (checkRow >= 0 && checkRow < cellzz.length && checkCol >= 0 && checkCol < cellzz[i].length && isClickedShowSqr) {
                cellzz[checkRow][checkCol].setToDefaultColor();
                boolar = false;
            }
        }
        isClickedShowSqr = boolar;
        int rand = (int) (Math.random() * rowsCol.size());
        if(!rowsCol.isEmpty()) {
            int y = rowsCol.get(rand).getRow();
            System.out.println(y);
            int x = rowsCol.get(rand).getCol();
            System.out.println(x);
            nite.move(y, x);
            repaint();
            z.start();
        }
    }

    public void resetBoard() {
        for (int r = 0; r < cellzz.length; r++) {
            for (int c = 0; c < cellzz[0].length; c++) {
                cellzz[r][c].setToDefaultColor();
            }
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // stuff to draw the board and knight
        for (int r = 0; r < cellzz.length; r++) {
            for (int c = 0; c < cellzz[0].length; c++) {
                cellzz[r][c].draw(g);
            }
        }
        nite.draw(g);
    }

    /* make random move just selects a new location at random
     * if the knight is trapped (no new locations to move to)
     * then false is returned.  Otherwise, true is returned.
     * The knight's location should be updated and the
     */
    public boolean makeRandomMove() {
        return false;
    }

    /* make a move to a new location that ensures the best chance
     * for a complete traversal of the board.
     * if the knight is trapped (no new locations to move to)
     * then false is returned.  Otherwise, true is returned.
     */
    public boolean makeThoughtfulMove() {
        return false;
    }

}

import java.awt.*;

/**
 * Created by home on 3/23/17.
 */
public class Cell {

    private int row, col;
    private boolean isOccupied;
    private static final int CELL_WIDTH = 50;
    private static final int CELL_HEIGHT = 50;
    private Color c;
    private Color defColor;

    boolean color = true;

    public Cell(int r, int c, Color co){
        this.row = r;
        this.col = c;
        this.c =co;
        this.defColor = co;
    }

    public void setToDefaultColor(){
        c = defColor;
    }

    public void setColor(Color c){
        this.c = c;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public int myX(){
        return col*CELL_WIDTH;
    }

    public int myY(){
        return row*CELL_HEIGHT;
    }


    public void draw(Graphics g){
        g.setColor(c);
        g.fillRect(myX()+col+1, myY()+row+1, CELL_WIDTH, CELL_HEIGHT);
    }

}

import javax.imageio.ImageIO;
import java.awt.*;
import java.net.URL;

/**
 * Created by home on 3/23/17.
 */
public class Knight {
    private int row, col;
    private static final int CELL_WIDTH = 50;
    private static final int CELL_HEIGHT = 50;
    private static final int DRAW_WIDTH = 40;
    private static final int DRAW_HEIGHT = 40;
    private Image img;

    public static final int[] rows = {2, 2, 1, 1, -1, -1, -2, -2};
    public static final int[] cols = {-1, 1, -2, 2, -2, 2, -1, 1};

    public Knight(int r, int c) {
        row = r;
        col = c;
        openImage();
    }

    public void move(int r, int c){
        row = r;
        col = c;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }
    private void openImage(){
        try{
            URL url = Knight.class.getResource("nite.png");
            img = ImageIO.read(url);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }



    public void draw(Graphics g){
        g.drawImage(img,col*CELL_HEIGHT+8, row*CELL_WIDTH+8, DRAW_WIDTH, DRAW_HEIGHT,null);
    }

}

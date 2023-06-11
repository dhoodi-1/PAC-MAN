import java.awt.*;
//import java.util.ArrayList;

public class Pellet extends Circle {
    private int x;  //x coordinate of top left corner
    private int y;
    private int r;

    public int posX(int xe){
        x = xe;
        return x;
    }

    public int posY(int ye){
        y = ye;
        return y;
    }

    // public Pellet(){
    //     super(5,  x,  y, Color.YELLOW);
    // }

    public Pellet(int xValue, int yValue){
        super(5,  xValue,  yValue, Color.YELLOW);
        //x = xx;
        //y = yy; 
    }

}

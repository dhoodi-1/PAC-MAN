import java.awt.Color;
import java.awt.Graphics;

public class Pacman extends Square implements Animatable {
   // private int x;
   // private int y; 
   private int dX;
   private int dY;
   private int side;

    public Pacman(int sideValue, int xValue, int yValue) {
        super(sideValue, xValue-(sideValue/2), yValue-(sideValue/2), Color.WHITE );
        dX = 0;
        dY = 0;
        side = 10;
     }
  
    public Pacman(int xValue, int yValue) {
        super(20, xValue-(10), yValue-(10), Color.WHITE);
        dX = 0;
        dY = 0;
        side = 10;
     }
  
    public void step(){
        setX(getX() + dX);  
        setY(getY() + dY);
    }
   //   public void drawMe(Graphics g){
   //       g.setColor(Color.WHITE);
   //       g.fillRect(x, y, side, side);
   // }
    public int getDX() {
        return dX;
     }
     public int getDY() {
        return dY;
     }
     //public int getSide() {
      //  return side;
     //}
     
     public void setDX(int dXValue) {
        dX = dXValue;
     }
     public void setDY(int dYValue) {
        dY = dYValue;
     }


}

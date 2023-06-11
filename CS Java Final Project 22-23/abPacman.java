import java.awt.Color;
//import java.util.ArrayList;
import java.util.ArrayList;

public abstract class abPacman extends Square implements Animatable{

    private int dX;
    private int dY;
    private int side;
    //private GamePanel world;
 
     public abPacman(int sideValue, int xValue, int yValue) {
         super(sideValue, xValue-(sideValue/2), yValue-(sideValue/2), Color.WHITE );
         dX = 0;
         dY = 0;
         side = 10;
      }
   
     public abPacman(int xValue, int yValue) {
         super(20, xValue-(10), yValue-(10), Color.WHITE);
         dX = 0;
         dY = 0;
         side = 20;
      }
      abstract void respawn(ArrayList<Walls> w);
      //abstract boolean comparePellet();

   public void step(){
         setX(getX() + dX);  
         setY(getY() + dY);
    }

     public int getDX() {
         return dX;
      }
      public int getDY() {
         return dY;
      }
      public int getSide() {
        return side;
      }
      
      public void setDX(int dXValue) {
         dX = dXValue;
      }
      public void setDY(int dYValue) {
         dY = dYValue;
      }
      

   public boolean checkOverPellet(Pellet pellet) {

        if(getX() < pellet.getX() && (getX() + getSide()) > pellet.getX()
        && getY() < pellet.getY() && (getY() + getSide()) > pellet.getY()){
         //System.out.println("true");
            return true;
        }
        return false;
    }

   public boolean checkInWall(Walls w){
      if(((getX()<=w.getX()+w.getW() && getX()>=w.getX())
         && (getY()<=(w.getY()+w.getH()) && getY() >= w.getY())) || 
         ((getX()+side<=w.getX()+w.getW() && getX()+side>=w.getX())
         && (getY()+side>=(w.getY()+w.getH()) && getY()+side<= w.getY()))){
         return true;
       }
       return false;
     }
 
 }

//getX() < pellet.getX() && getX() + getSide() > pellet.getX()
//&& getY() < pellet.getY() && getY() + getSide() > pellet.getY()
import java.awt.Color;
//import java.util.ArrayList;
import java.util.ArrayList;

public abstract class abPacman extends Square implements Animatable{

    private int dX;
    private int dY;
    private int side;
    private GamePanel world;
 
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
         side = 10;
      }
   
      abstract void eatPellet();
      //abstract boolean comparePellet();

    public void step(){
         setX(getX() + dX);  
         setY(getY() + dY);

        ArrayList<Pellet> pellets = GamePanel.getPellets();

        for (int i = 0; i < pellets.size(); i++) {
            Pellet pellet = pellets.get(i);
            
            if (checkOverPellet(pellet) == true) { 
                //System.out.println("you");
                pellets.remove(pellet);
                eatPellet();
                break; // Exit the loop since we found and removed a pellet
            }
        }
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
      
      public void setWorld(GamePanel world) {
        this.world = world;
    }

    public GamePanel getWorld() {
        return world;
    }

    //   public boolean checkOverPellet(Pellet pellet) {
    //         if ( ((getX()+(side/2)) == pellet.getX()) && 
    //             ((getY()+(side/2))==pellet.getY())){
    //             return true;
    //         }
    //     return false;
    // }

    public boolean checkOverPellet(Pellet pellet) {
        //System.out.println(getX() + (side/2));
        if(getX() < pellet.getX() && getX() + getSide() > pellet.getX()
        && getY() < pellet.getY() && getY() + getSide() > pellet.getY()){
            
            return true;
        }
        return false;
    }
 
 }

//getX() < pellet.getX() && getX() + getSide() > pellet.getX()
//&& getY() < pellet.getY() && getY() + getSide() > pellet.getY()
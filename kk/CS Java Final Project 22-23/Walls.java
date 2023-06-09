import java.awt.*;

public class Walls
{
   //fields
   private int x;
   private int y; 
   private int w; 
   private int h;
   
   //constructors
   public Walls()
   {
      x = 0;
      y = 0;
      w = 10;
      h = 20;
   }
   public Walls(int xValue, int yValue, int wValue, int hValue)
   {
      x = xValue;
      y = yValue;
      w = wValue;
      h = hValue;
   }
   
   //accessors
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public int getW()
   {
      return w;
   }
   public int getH()
   {
      return h;
   }
   
   //modifiers
   public void setX(int xValue)
   {
      x = xValue;
   }
   public void setY(int yValue)
   {
      y = yValue;
   }
   public void setW(int wValue)
   {
      w = wValue;
   }
   public void setH(int hValue)
   {
      h = hValue;
   }
   
   //instance methods
   public void drawMe(Graphics g)
   {
      g.setColor(Color.RED);
      g.fillRect(x, y, w, h);
   }
   
   //other useful Java methods
   
   //(leave this commented out until the assignment tells you to use it)
   
   public String toString()
   {
      return "Walls at " + x + ", " + y + " with width length " + w + " and height set to " + h;
   }
   
   
}


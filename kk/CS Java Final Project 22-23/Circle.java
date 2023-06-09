import java.awt.*;

public class Circle
{
   //fields
   private int r;
   private int x;  //x coordinate of top left corner
   private int y;  //y coordinate of top left corner
   private Color c;
   
   //constructors
   public Circle()
   {
      r = 10;
      x = 200;
      y = 20;
      c = Color.BLACK;
   }
   public Circle(int rValue, int xValue, int yValue, Color cValue)
   {
      r = rValue;
      x = xValue;
      y = yValue;
      c = cValue;
   }
   
   //accessors
   public int getRadius()
   {
      return r;
   }
   public int getX()
   {
      return x;
   }
   public int getY()
   {
      return y;
   }
   public Color getColor()
   {
      return c;
   }
   
   //modifiers
   public void setRadius(int radiusValue)
   {
      r = radiusValue;
   }
   public void setX(int xValue)
   {
      x = xValue;
   }
   public void setY(int yValue)
   {
      y = yValue;
   }
   public void setColor(Color cValue)
   {
      c = cValue;
   }
   
   //methods
   public void drawMe(Graphics g){
      g.setColor(c);
      g.fillOval(x-r,y-r,r*2,r*2);
   }
   
   public Circle(Square s)
   {
      r = s.getSide() / 2;
      x = s.getSide()/2 + s.getX();
      y = s.getSide()/2 + s.getY();
      c = s.getColor().darker();

   }

   public String toString()
   {
      return "Circle at " + x + ", " + y + " with radius " + r + " and color set to " + c;
   }

   


}

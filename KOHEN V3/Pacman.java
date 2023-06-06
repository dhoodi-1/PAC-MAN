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

// public class Pacman implements Animatable{
//     private int dX;
//     private int dY;
//     private double speed;
//     private double x;
//     private double y;
//     public void drawMe(Graphics g){
//         g.fillOval(40, 365, 20, 20);
//         dX = 0;
//         dY = 0;

//     }
//     public int getDX() {
//         return dX;
//     }
//     public int getDY() {
//         return dY;
//     }
//     public void setDX(int dXValue)
//    {
//       dX = dXValue;
//    }
//    public void setDY(int dYValue)
//    {
//       dY = dYValue;
//    }

//     public void step()  //Implement Animatable's required step()
//    {
//       setX(getX() + dX);
//       setY(getY() + dY);   
//    }
//     public void setY(int i) {
        
//     }
//     public void setX(int i) {
//     }
//     public int getY() {
//         return 0;
//     }
//     public int getX() {
//         return 0;
//     }
//     public void moveUp(int WIDTH, int HEIGHT) {
//         if (y > 0) {
//         y -= speed;
//         }
//     }
//     public void moveDown(int WIDTH, int HEIGHT) {
//         if (y < HEIGHT - height) {
//         y += speed;
//         }
//         }
        
//         public void moveLeft(int WIDTH, int HEIGHT) {
//         if (x > 0) {
//         x -= speed;
//         }
//         }
        
//         public void moveRight(int WIDTH, int HEIGHT) {
//         if (x < WIDTH - width) {
//         x += speed;
//         }
//         }
//         public boolean canMove(ArrayList<Walls> walls, int direction) {
//         double tempx = 0;
//         double tempy = 0;
//         if (direction == 1) {
//         tempx = x + speed;
//         tempy = y;
//         }
//         if (direction == 2) {
//         tempx = x;
//         tempy = y - speed;
//         }
//         if (direction == 3) {
//         tempx = x - speed;
//         tempy = y;
//         }
//         if (direction == 4) {
//         tempx = x;
//         tempy = y + speed;
//         }
//     }

// }

// public class Pacman extends JPanel{
//     BufferedImage img;
//     final static String imgPath = "New Piskel-1.png.png";
//     Pacman()
//     {
//         try
//         {
//         img = ImageIO.read(new File(imgPath));
//         }
//     catch(Exception e)
//     {
//         System.out.println("Exception in Loading Image: "+e.toString());
//     }
// }
// @Override
// public void paint(Graphics g){
//     super.paint(g);
//     g.drawImage(img, 20, 20, null);
// }
// }










// public class Pacman implements Animatable
// {
//         private int dX;
//         private int dY;
//         private int x;
//         private int y;
//         private int w;
//         private int h;
//         private int counter;

//         private ImageIcon pacman = new ImageIcon("New Piskel-1.png.png");
//         private ImageIcon pacman2 = new ImageIcon("New Piskel-2.png.png");

//         private BufferedImage img;
//         private Graphics bufG;

//         public Pacman(){
//             x = 10;
//             y = 150;
//             w = 32;
//             h = 32;
//             dX = 0;
//             dY = 0;

//             img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//             bufG = img.getGraphics();


//         }

//         public int getDX()
//         { return dX; }

//         public int getDY()
//         { return dY; }

//         public void setDX(int dXValue)
//         { dX = dXValue; }

//         public void setDY(int dYValue)
//         { dY = dYValue; }

//         public int getW()
//         { return w; }

//         public int getH()
//         { return h; }

//         public void setW(int dXValue)
//         { w = dXValue; }

//         public void setH(int dYValue)
//         { h = dYValue; }

//         public int getX()
//         { return x; }

//         public int getY()
//         { return y; }

//         public void setX(int xValue)
//         { x = xValue; }

//         public void setY(int yValue)
//         { y = yValue; }

//         public void step(){
//             setY(getY() + dY);
//             setX(getX() + dX);
//             counter++;
//         }

//         public void drawMe(Graphics g){
//             if(counter%50 < 25)
//             {
//                 bufG.drawImage(pacman.getImage(),0,0,w,h,null);
//             }
//             else if(counter%50 >= 25)
//             {
//                 bufG.drawImage(pacman2.getImage(),0,0,w,h,null);
//             }
//             g.drawImage(img,x,y,w,h,null);
//         }

        

// }

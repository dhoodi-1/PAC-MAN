import java.awt.*;
import java.util.ArrayList;


public class Pacman {
    private double x;
    private double y;
    private int width;
    private int height;
    private double speed;
    
    public Pacman(double x, double y, int width, int height, double speed) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.speed = speed;
    }
    
    public Pacman(int x, int y) {
    this.x = x;
    this.y = y;
    }
    
    public void setX(int x) {
    this.x = x;
    }
    
    public void setY(int y) {
    this.y = y;
    }
    
    public double getX() {
    return x;
    }
    
    public double getY() {
    return y;
    }
    
    public int getWidth() {
    return width;
    }
    
    public int getHeight() {
    return height;
    }
    
    public void setWidth(int width) {
    this.width = width;
    }
    
    public void setHeight(int height) {
    this.height = height;
    }

public void draw(Graphics g) {
    g.setColor(Color.yellow);
    g.fillOval((int)x, (int)y, width, height);
    }
    
    public void moveUp(int WIDTH, int HEIGHT) {
    if (y > 0) {
    y -= speed;
    }
    }
    
    public void moveDown(int WIDTH, int HEIGHT) {
    if (y < HEIGHT - height) {
    y += speed;
    }
    }
    
    public void moveLeft(int WIDTH, int HEIGHT) {
    if (x > 0) {
    x -= speed;
    }
    }
    
    public void moveRight(int WIDTH, int HEIGHT) {
    if (x < WIDTH - width) {
    x += speed;
    }
    }
    public boolean canMove(ArrayList<Walls> walls, int direction) {
    double tempx = 0;
    double tempy = 0;
    if (direction == 1) {
    tempx = x + speed;
    tempy = y;
    }
    if (direction == 2) {
    tempx = x;
    tempy = y - speed;
    }
    if (direction == 3) {
    tempx = x - speed;
    tempy = y;
    }
    if (direction == 4) {
    tempx = x;
    tempy = y + speed;
    }
    for (int i = 0; i < walls.size(); i++) {
        if (inWall(tempx, tempy, width, height, walls.get(i))) {
        return false;
        }
        }
        return true;
        }
        
        private boolean inWall(double x, double y, int width, int height, Walls f) {
        if (x < f.getX() + f.getW() && x + width > f.getX() && y < f.getY() + f.getH()
        && y + height > f.getY()) {
        return true;
        }
        return false;
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
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class Pacman implements Animatable
{
    private int dX;
        private int dY;
        private int x;
        private int y;
        private int w;
        private int h;
        private int counter;

        private ImageIcon pacman = new ImageIcon("New Piskel-1.png.png");
        private ImageIcon pacman2 = new ImageIcon("New Piskel-2.png.png");

        private BufferedImage img;
        private Graphics bufG;

        public Pacman(){
            x = 10;
            y = 150;
            w = 32;
            h = 32;
            dX = 0;
            dY = 0;

            img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            bufG = img.getGraphics();

        }

        public int getDX()
        { return dX; }

        public int getDY()
        { return dY; }

        public void setDX(int dXValue)
        { dX = dXValue; }

        public void setDY(int dYValue)
        { dY = dYValue; }

        public int getW()
        { return w; }

        public int getH()
        { return h; }

        public void setW(int dXValue)
        { w = dXValue; }

        public void setH(int dYValue)
        { h = dYValue; }

        public int getX()
        { return x; }

        public int getY()
        { return y; }

        public void setX(int xValue)
        { x = xValue; }

        public void setY(int yValue)
        { y = yValue; }

        public void step(){
            setY(getY() + dY);
            setX(getX() + dX);
            counter++;
        }

        public void drawMe(Graphics g){
            if(counter%50 < 25)
            {
                bufG.drawImage(pacman.getImage(),0,0,w,h,null);
            }
            else if(counter%50 >= 25)
            {
                bufG.drawImage(pacman2.getImage(),0,0,w,h,null);
            }
            g.drawImage(img,x,y,w,h,null);
        }

        

}
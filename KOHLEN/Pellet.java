import javax.swing.*;
import java.awt.*;

public class Pellet extends Circle{
    
    public Pellet(int xx, int yy){
        super(5,  xx,  yy, Color.YELLOW);
    }

    public boolean underPac(Pacman p){
        if(p.getX() == getX() && p.getY() == getY()){
            return true;
        }
        
        return false;
    }





}

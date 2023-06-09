import java.awt.*;
//import java.util.ArrayList;

public class Pellet extends Circle{
    
    public Pellet(int xx, int yy){
        super(5,  xx,  yy, Color.YELLOW);
    }

    // public boolean underPac(Pacman p, ArrayList<Pellet> pp){
    //     for(int i = 0; i<pp.size(); i++){
    //     if((p.getX() < pp.get(i).getX() && (p.getX()+p.getSide()) > pp.get(i).getX()) && 
    //     (p.getY() < pp.get(i).getY() && (p.getY()+p.getSide()) > pp.get(i).getY())){
    //         return true;
    //     }
        
    //     return false;
    // }
    //     return false;
    // }

    // public void remove(int i) {
    // }

    // boolean overlapsGhost(double x, double y, int width, int height, ArrayList<Ghost> ghosts) {
    //     for (int i = 0; i < ghosts.size(); i++) {
    //     if (x < ghosts.get(i).getX() + ghosts.get(i).getWidth() && x + width > ghosts.get(i).getX()
    //     && y < ghosts.get(i).getY() + ghosts.get(i).getHeight() && y + height > ghosts.get(i).getY()) {
    //     return true;
    //     }
    //     }
    //     return false;
    //     }



}

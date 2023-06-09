import java.util.ArrayList;

public class player2 extends abPacman{
    
    private int pelletCounter;

    public player2(){
        super(750,25);
        pelletCounter = 0;
    }

    public int getCount(){
        return pelletCounter; 
    }

    @Override
    void eatPellet() {
        //GamePanel bestie = (GamePanel) getWorld();
        ArrayList<Pellet> p = GamePanel.getPellets();
        for (int i = 0; i < p.size(); i++) {
            Pellet pp = p.get(i);
            if (checkOverPellet(pp)==true) {
                p.remove(pp);
                pelletCounter++;
                //System.out.println("eaten");
                break; // Exit the loop since we found and removed a pellet
            }
        }
    }

    boolean comparePellet(player2 p){
        if(getCount()>p.getCount()){
            return true;
        }
        
        return false;
    }
}

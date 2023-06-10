//import java.util.ArrayList;

import java.util.ArrayList;

public class player1 extends abPacman{

    private int pelletCounter;

    public player1(){
        super(50, 375);
        pelletCounter = 0;
    }

    public int getCount(){
        return pelletCounter;
    }

    //@Override
    // void eatPellet() {
    //     ArrayList<Pellet> p = GamePanel.getPellets();
    
    //     for (int i = 0; i < p.size(); i++) {
    //         Pellet pp = p.get(i);
    //         if (checkOverPellet(pp)) {
    //             p.remove(pp); // Remove the pellet from the ArrayList
    //             pelletCounter++;
    //             System.out.println("eaten");
    //             GamePanel.removePellet(pp); // Remove the pellet from the GamePanel's list
    //             break;
    //         }
    //     }
    // }

    void eatPellet() {
        ArrayList<Pellet> p = GamePanel.getPellets();
        //int indexToRemove = -1;
    
        for (int i = 0; i < p.size(); i++) {
            Pellet pp = p.get(i);
            //System.out.println(checkOverPellet(pp));
            if (checkOverPellet(pp) == true) {
                GamePanel.removePellet1(pp);
                pelletCounter++;
                System.out.println("eaten");
                System.out.println(pelletCounter);
                break;
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

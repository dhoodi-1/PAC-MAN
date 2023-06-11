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


    void eatPellet(ArrayList<Pellet> pellets) {
         for (int i = 0; i < pellets.size(); i++) {
            //Pellet pellet = pellets.get(i);
            
            if (checkOverPellet(pellets.get(i)) == true) { 
                System.out.println("pellet eat");
                pellets.get(i).setX(1000);
                pelletCounter++;
                break;
            }
            
        }
        //return neww;
     }

     void eatPellet1(ArrayList<Pellet> pellets) {
          for (int i = 0; i < pellets.size(); i++) {
            Pellet pellet = pellets.get(i);
            
            if (checkOverPellet(pellet) == true) { 
                System.out.println("pellet eat");
                pellet.setX(1000);
                pelletCounter++;
                break;
            }
            
        }
        //return neww;
     }

     void respawn(ArrayList<Walls> w){
        for (int i = 0; i < w.size(); i++) {
            //Walls pellet = pellets.get(i);
        
            if(checkInWall(w.get(i))){
                setX(40);
                setY(365);
            }
        }

     }

     void eatHardPellet(Pellet ppp){
        if(checkOverPellet(ppp)){    
            System.out.println("pellet eat");
            ppp.setX(getX()+800);
            pelletCounter++;
            //System.out.println(getCount());
        }
    }
    

    boolean comparePellet(player2 p){
        if(getCount()>p.getCount()){
            return true;
        }
        
        return false;
    }
    
}

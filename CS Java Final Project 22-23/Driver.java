import javax.swing.*;

public class Driver{
    public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Pac-Man");
      //frame.setSize(500, 500);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new HomeScreen(frame));
      frame.pack();
      frame.setVisible(true);
   }
}
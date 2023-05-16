import javax.swing.*;
import java.net.*;
  
public class RoundButton {
  
    public static void main(String[] args) throws MalformedURLException {
    URL yellow = new URL("http://www.wpclipart.com/small_icons/buttons/.cache/button_yellow.png");
    URL orange = new URL("http://www.wpclipart.com/small_icons/buttons/.cache/button_orange.png");
    URL purple = new URL("http://www.wpclipart.com/small_icons/buttons/.cache/button_purple.png");
  
        JButton b0 = new JButton("Stock");
  
        JButton b = new JButton("Round");
        b.setIcon(new ImageIcon(yellow));
        b.setRolloverIcon(new ImageIcon(orange));
        b.setPressedIcon(new ImageIcon(purple));
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setRolloverEnabled(true);
        b.setFocusPainted(false);
        b.setBorderPainted(false);
        b.setContentAreaFilled(false);
  
    JFrame f = new JFrame("round button test");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        p.add(b0);
        p.add(b);
        f.setContentPane(p);
        f.pack();
        f.setVisible(true);
    }
}
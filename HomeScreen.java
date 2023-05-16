import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

    public class HomeScreen extends JPanel
    {
        public HomeScreen()
        {   
            setLayout(new BorderLayout());


            // Makes Title
            JLabel title = new JLabel("Pac-Man");
            title.setFont(new Font("Serif", Font.BOLD, 50));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            // title.setBounds(200, 20, 50, 50);
            add(title, BorderLayout.NORTH);

            // Buttons
            JPanel buttons = new JPanel();
            buttons.setLayout(new GridLayout(8, 1, 5, 20));


            // Empty Buttons
            JPanel empty = new JPanel();
            empty.setOpaque(true);
            //play.addActionListener(new playListener);
            buttons.add(empty);

            JPanel empty2 = new JPanel();
            empty2.setOpaque(true);
            empty2.setPreferredSize(new Dimension(20, 20));
            //play.addActionListener(new playListener);
            buttons.add(empty2);
            // Play button
            JButton play = new JButton("Play");
            play.setBackground(Color.YELLOW);
            play.setOpaque(true);
            play.setBorderPainted(false);
            play.setContentAreaFilled(true);
            //play.addActionListener(new playListener);
            buttons.add(play);

            JButton score = new JButton("Score");
            score.setBackground(Color.BLUE);
            score.setOpaque(true);
            score.setBorderPainted(false);
            //play.addActionListener(new playListener);
            buttons.add(score); 

            JButton settings = new JButton("Settings");
            settings.setBackground(Color.RED);
            settings.setOpaque(true);
            settings.setBorderPainted(false);
            //play.addActionListener(new playListener);
            buttons.add(settings);

            add(buttons, BorderLayout.CENTER);

            // East Empty Panel
            JPanel empty3 = new JPanel();
            empty3.setOpaque(true);
            //empty3.setBackground(Color.BLACK);
            empty3.setPreferredSize(new Dimension(100, 100));
            //play.addActionListener(new playListener);
            add(empty3, BorderLayout.EAST);

            // West Empty Panel
            JPanel empty4 = new JPanel();
            empty4.setOpaque(true);
            //empty4.setBackground(Color.BLACK);
            empty4.setPreferredSize(new Dimension(100, 100));
            //play.addActionListener(new playListener);
            add(empty4, BorderLayout.WEST);

            
        
        }
        // This takes the player to the game from pressing play
        class ATNPanel extends JPanel{
            private JFrame owner;
            private ResultsPanel game;
            private AddPanel home;
            
            public ATNPanel(JFrame f){
                owner = f;
                setLayout(new BorderLayout());
                add(new JLabel("game"), BorderLayout.NORTH);

                home = new AddPanel(this);
                add(home);
                game = new ResultsPanel(home, this);
            }

            public void showResult(){
                remove(home);
                add(game);
                repaint();
                revalidate();
                owner.pack();

            }
        }
    
}


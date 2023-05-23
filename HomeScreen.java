import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;

    public class HomeScreen extends JPanel
    {
        private JFrame owner;
        private HomePanel home;
        private GamePanel game;
        private SettingsPanel settings;
        
        
        public HomeScreen(JFrame f)
        {   
            owner=f;
            setLayout(new BorderLayout());
            
            home = new HomePanel(this);
            add(home);
            game = new GamePanel(home,this);
            settings = new SettingsPanel(home, this);
        }
        // Used to tell the actionListener to switch panels
        public void showGame(){
            remove(home);
            add(game);
            repaint();
            revalidate();
            owner.pack();
         }
         // tells the settings action listener what to do
         public void showSettings()
         {
            remove(home);
            add(settings);
            repaint();
            revalidate();
            owner.pack();
         }
    }
    // Home screen
    class HomePanel extends JPanel{
        private HomeScreen owner;
        public HomePanel(HomeScreen homeScreen){
           owner=homeScreen;
           setPreferredSize(new Dimension(500,500));
           setLayout(new BorderLayout());
           

           // Makes Title
           JLabel title = new JLabel("Pac-Man");
           title.setFont(new Font("Serif", Font.BOLD, 50));
           title.setHorizontalAlignment(SwingConstants.CENTER);
           add(title, BorderLayout.NORTH);


           // Buttons
           JPanel buttons = new JPanel();
           buttons.setLayout(new GridLayout(8, 1, 5, 20));

           // Empty Buttons
           JPanel empty = new JPanel();
           empty.setOpaque(true);
           buttons.add(empty);


           JPanel empty2 = new JPanel();
           empty2.setOpaque(true);
           empty2.setPreferredSize(new Dimension(20, 20));
           buttons.add(empty2);

           // Play button
           JButton play = new JButton("Play");
           play.setBackground(Color.YELLOW);
           play.setOpaque(true);
           play.setBorderPainted(false);
           play.setContentAreaFilled(true);
           play.addActionListener(new PlayListener());
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
           settings.addActionListener(new SettingsListener());
           buttons.add(settings);


           add(buttons, BorderLayout.CENTER);


           // East Empty Panel
           JPanel empty3 = new JPanel();
           empty3.setOpaque(true);
           empty3.setPreferredSize(new Dimension(100, 100));
           add(empty3, BorderLayout.EAST);


           // West Empty Panel
           JPanel empty4 = new JPanel();
           empty4.setOpaque(true);
           empty4.setPreferredSize(new Dimension(100, 100));
           add(empty4, BorderLayout.WEST);
        }
        // plau button action listener
        private class PlayListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
               owner.showGame();
            }
         }
        // settings action listener
        private class SettingsListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                owner.showSettings();
            }
        }
}
    // Game #to be updated
    class GamePanel extends JPanel{
        private HomePanel a;
        private HomeScreen owner;

        public GamePanel(HomePanel a, HomeScreen HomeScreen){
           this.a=a;
           owner=HomeScreen;
           setPreferredSize(new Dimension(800, 400));
           setLayout(new BorderLayout());
        }
        // This draws the map and GamePanel calls this
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawMap(g);
        
            Toolkit t=Toolkit.getDefaultToolkit();  
            Image i=t.getImage("New Piskel-1.png.png");  
            g.drawImage(i, 30,360,this);  
        }
        public void drawMap(Graphics g){
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 400);           

            // Personal lines to help with drawing map // To be deleted later // start
            g.setColor(Color.GREEN);
            g.drawLine(400, 0, 400, 400); // vertical
            g.drawLine(0, 200, 800, 200); // Horizontal
            g.setColor(Color.BLUE);
            g.drawLine(0, 25, 800, 25); // Horizontal
            g.drawLine(0, 50, 800, 50); // Horizontal
            g.drawLine(0, 75, 800, 75); // Horizontal
            g.drawLine(0, 100, 800, 100); // Horizontal
            g.drawLine(0, 125, 800, 125); // Horizontal
            g.drawLine(0, 150, 800, 150); // Horizontal
            g.drawLine(0, 175, 800, 175); // Horizontal
            g.drawLine(0, 225, 800, 225); // Horizontal
            g.drawLine(0, 250, 800, 250); // Horizontal
            g.drawLine(0, 275, 800, 275); // Horizontal
            g.drawLine(0, 300, 800, 300); // Horizontal
            g.drawLine(0, 325, 800, 325); // Horizontal
            g.drawLine(0, 350, 800, 350); // Horizontal
            g.drawLine(0, 375, 800, 375); // Horizontal
            g.drawLine(0, 400, 800, 400); // Horizontal
            g.drawLine(25, 0, 25, 400);
            g.drawLine(50, 0, 50, 400);
            g.drawLine(75, 0, 75, 400);
            g.drawLine(100, 0, 100, 400);
            g.drawLine(125, 0, 125, 400);
            g.drawLine(150, 0, 150, 400);
            g.drawLine(175, 0, 175, 400);
            g.drawLine(200, 0, 200, 400);
            g.drawLine(225, 0, 225, 400);
            g.drawLine(250, 0, 250, 400);
            g.drawLine(275, 0, 275, 400);
            g.drawLine(300, 0, 300, 400);
            g.drawLine(325, 0, 325, 400);
            g.drawLine(350, 0, 350, 400);
            g.drawLine(375, 0, 375, 400);
            g.drawLine(425, 0, 425, 400);
            g.drawLine(450, 0, 450, 400);
            g.drawLine(475, 0, 475, 400);
            g.drawLine(500, 0, 500, 400);
            g.drawLine(525, 0, 525, 400);
            g.drawLine(550, 0, 550, 400);
            g.drawLine(575, 0, 575, 400);
            g.drawLine(600, 0, 600, 400);
            g.drawLine(625, 0, 625, 400);
            g.drawLine(650, 0, 650, 400);
            g.drawLine(675, 0, 675, 400);
            g.drawLine(700, 0, 700, 400);
            g.drawLine(725, 0, 725, 400);
            g.drawLine(750, 0, 750, 400);
            g.drawLine(775, 0, 775, 400);
            g.drawLine(800, 0, 800, 400);
            // end

            g.setColor(Color.RED);
            // middle box
            g.drawLine(325, 150, 475, 150);
            g.drawLine(325, 250, 475, 250);
            g.drawLine(325, 150, 325, 250);
            g.drawLine(475, 150, 475, 250);
            // middle 2 blocks
            g.fillRect(325, 50, 150, 50);
            g.fillRect(325, 300, 150, 50);
            // bottom right blocks 
            g.fillRect(525, 250, 50, 100);
            g.fillRect(525, 325, 100, 25);
            g.fillRect(675, 250, 50, 100);
            g.fillRect(625, 250, 100, 25);
            // top right middle blocks
            g.fillRect(525, 150, 200, 50);
            g.fillRect(600, 50, 50, 100);
            g.fillRect(625, 50, 100, 50);
            g.fillRect(525, 0, 25, 100);
            // far right wall
            g.fillRect(775, 0, 25, 400);
            // left side
            g.fillRect(75, 250, 50, 100);
            g.fillRect(75, 325, 100, 25);
            g.fillRect(225, 250, 50, 100);
            g.fillRect(175, 250, 100, 25);
            // top left blocks
            g.fillRect(75, 150, 200, 50);
            g.fillRect(75, 50, 50, 100);
            g.fillRect(250, 50, 100, 50);
            g.fillRect(175, 0, 25, 100);
            // far left wall
            g.fillRect(0, 0, 25, 400);
            // food/points
            g.setColor(Color.YELLOW);
            for (int x = 45; x < 750; x += 25){
                g.fillOval(x, 370, 10, 10);
            }
            for (int y = 20; y < 350; y += 25){
                g.fillOval(45, y, 10, 10);
            }
            for (int y = 20; y < 350; y += 25){
                g.fillOval(745, y, 10, 10);
            }
            for (int x = 70; x < 165; x += 25){
                g.fillOval(x, 20, 10, 10);
            }
            for (int x = 220; x < 500; x += 25){
                g.fillOval(x, 20, 10, 10);
            }
            for (int x = 570; x < 750; x += 25){
                g.fillOval(x, 20, 10, 10);
            }
            for (int x = 70; x < 280; x += 25){
                g.fillOval(x, 220, 10, 10);
            }
            for (int x = 520; x < 750; x += 25){
                g.fillOval(x, 220, 10, 10);
            }
            for (int y = 45; y < 125; y += 25){
                g.fillOval(145, y, 10, 10);
            }
            for (int x = 170; x < 575; x += 25){
                g.fillOval(x, 120, 10, 10);
            }
            for (int y = 45; y < 100; y += 25){
                g.fillOval(220, y, 10, 10);
            }
            for (int y = 45; y < 100; y += 25){
                g.fillOval(495, y, 10, 10);
            }
            for (int y = 45; y < 100; y += 25){
                g.fillOval(570, y, 10, 10);
            }
            for (int y = 145; y < 350; y += 25){
                g.fillOval(295, y, 10, 10);
            }
            for (int y = 145; y < 350; y += 25){
                g.fillOval(495, y, 10, 10);
            }
            for (int x = 320; x < 500; x += 25){
                g.fillOval(x, 270, 10, 10);
            }
            for (int y = 245; y < 300; y += 25){
                g.fillOval(145, y, 10, 10);
            }
            for (int y = 295; y < 350; y += 25){
                g.fillOval(195, y, 10, 10);
            }
            for (int y = 295; y < 350; y += 25){
                g.fillOval(645, y, 10, 10);
            }
            for (int y = 245; y < 300; y += 25){
                g.fillOval(595, y, 10, 10);
            }
            g.fillOval(170, 295, 10, 10);
            g.fillOval(620, 295, 10, 10);
            for (int x = 670; x < 745; x += 25){
                g.fillOval(x, 120, 10, 10);
            }
        }
    }
        // Settings Panel
        class SettingsPanel extends JPanel{
            private HomePanel a;
            private HomeScreen owner; 
            
            public SettingsPanel(HomePanel a, HomeScreen HomeScreen){
                this.a = a;
                owner=HomeScreen;
            setPreferredSize(new Dimension(400, 400));
            setLayout(new BorderLayout());
            }
        // calls the drawing
        @Override
        protected void paintComponent(Graphics s) {
            super.paintComponent(s);
            drawSettings(s);
        }
        // draws the settings menu
        public void drawSettings(Graphics s){
            s.setColor(Color.YELLOW);
            s.fillRect(0, 0, 500, 500);  
            JLabel title = new JLabel("Settings");
            title.setFont(new Font("Serif", Font.BOLD, 50));
            title.setHorizontalAlignment(SwingConstants.CENTER);
            add(title, BorderLayout.NORTH);
            s.setFont(new Font("Serif", Font.BOLD, 20));
            s.setColor(Color.BLACK);
            s.drawString("Controls -", 15, 100);
            s.drawString(" Use WASD to control Pac-Man", 100, 100);

        }
    }
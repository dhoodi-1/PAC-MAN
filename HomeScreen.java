import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;

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

        public static final int FRAME = 500;
        private BufferedImage myImage;  
        private Graphics myBuffer;

        private ArrayList<Walls> walls = new ArrayList<Walls>();

        private Timer t;
        private ArrayList<Pellet> p = new ArrayList<Pellet>();
        private ArrayList<Pacman> pac = new ArrayList<Pacman>();
        private ArrayList<Animatable> animationObjects;
        private int frame=0;

        public GamePanel(HomePanel a, HomeScreen HomeScreen){
           this.a=a;
           owner=HomeScreen;
           setPreferredSize(new Dimension(800, 400));
           setLayout(new BorderLayout());

            // myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB); //Make the image that will store each frame
            // myBuffer = myImage.getGraphics(); //Get the Graphics object we can use to manipulate the image
            //myBuffer.fillRect(0,0,FRAME,FRAME);

            animationObjects = new ArrayList<Animatable>();
            myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB); 
            myBuffer = myImage.getGraphics(); 
            myBuffer.fillRect(0,0,FRAME,FRAME);

            

            //animationObjects.add(pacman);
            

            // this makes the walls
            // middle 2 blocks
            walls.add(new Walls(325, 50, 150, 50));
            walls.add(new Walls(325, 300, 150, 50));
            // bottom right blocks
            walls.add(new Walls(525, 250, 50, 100));
            walls.add(new Walls(525, 325, 100, 25));
            walls.add(new Walls(675, 250, 50, 100));
            walls.add(new Walls(525, 0, 25, 100));
            // top right middle blocks
            walls.add(new Walls(525, 150, 200, 50));
            walls.add(new Walls(600, 50, 50, 100));
            walls.add(new Walls(625, 50, 100, 50));
            walls.add(new Walls(525, 0, 25, 100));
            // far right wall
            walls.add(new Walls(775, 0, 25, 400));
            // left side
            walls.add(new Walls(75, 250, 50, 100));
            walls.add(new Walls(75, 325, 100, 25));
            walls.add(new Walls(225, 250, 50, 100));
            walls.add(new Walls(175, 250, 100, 25));
            // top left blocks
            walls.add(new Walls(75, 150, 200, 50));
            walls.add(new Walls(75, 50, 50, 100));
            walls.add(new Walls(250, 50, 100, 50));
            walls.add(new Walls(175, 0, 25, 100));
            walls.add(new Walls(0, 0, 25, 400));
            walls.add(new Walls(625, 250, 50, 25));
        }
    
        // This draws the map and GamePanel calls this
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawMap(g); 
            
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

            // g.setColor(Color.RED);
            // // middle box
            // g.drawLine(325, 150, 475, 150);
            // g.drawLine(325, 250, 475, 250);
            // g.drawLine(325, 150, 325, 250);
            // g.drawLine(475, 150, 475, 250);
            
            // food/points
            g.setColor(Color.YELLOW);
            for (int x = 50; x < 755; x += 25){
                Pellet pp = new Pellet(x, 375);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 50; y < 370; y += 25){
                Pellet pp = new Pellet(50, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 25; y < 375; y += 25){
                Pellet pp = new Pellet(750, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int x = 50; x < 165; x += 25){
                Pellet pp = new Pellet(x, 25);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int x = 225; x < 500; x += 25){
                Pellet pp = new Pellet(x, 25);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int x = 575; x < 750; x += 25){
                Pellet pp = new Pellet(x, 25);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int x = 75; x < 280; x += 25){
                Pellet pp = new Pellet(x, 225);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int x = 525; x < 750; x += 25){
                Pellet pp = new Pellet(x, 225);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 50; y < 125; y += 25){
                Pellet pp = new Pellet(150, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int x = 150; x < 600; x += 25){
                Pellet pp = new Pellet(x, 125);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 50; y < 100; y += 25){
                Pellet pp = new Pellet(225, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 50; y < 100; y += 25){
                Pellet pp = new Pellet(500, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 50; y < 100; y += 25){
                Pellet pp = new Pellet(575, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 150; y < 350; y += 25){
                Pellet pp = new Pellet(300, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 150; y < 350; y += 25){
                Pellet pp = new Pellet(500, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int x = 325; x < 500; x += 25){
                Pellet pp = new Pellet(x, 275);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 250; y < 300; y += 25){
                Pellet pp = new Pellet(150, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 295; y < 350; y += 25){
                Pellet pp = new Pellet(200, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 300; y < 350; y += 25){
                Pellet pp = new Pellet(650, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for (int y = 250; y < 300; y += 25){
                Pellet pp = new Pellet(600, y);
                pp.drawMe(g);
                p.add(pp);
            }
            for(Walls wall : walls){
                wall.drawMe(g);
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
            s.drawString(" Use WASD or arrow keys to control Pac-Man", 100, 100);

        }
    }
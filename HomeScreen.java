import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JButton;

    public class HomeScreen extends JPanel
    {
        private JFrame owner;
        private HomePanel home;
        private GamePanel game;
        private SettingsPanel settings;
        private ScorePanel score;
        
        public HomeScreen(JFrame f)
        {   
            owner=f;
            setLayout(new BorderLayout());
            
            home = new HomePanel(this);
            add(home);
            game = new GamePanel(home,this);
            settings = new SettingsPanel(home, this);
            score = new ScorePanel(home, this);

        }
        // Used to tell the actionListener to switch panels
        public void showGame(){
            remove(home);
            add(game);
            game.requestFocusInWindow();
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
         // settings to home
        public void showHome(){
            remove(settings);
            remove(score);
            add(home);
            repaint();
            owner.pack();
        }
        // home to score
        public void showScore(){
            remove(home);
            add(score);
            repaint();
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
           score.addActionListener(new scoreListener());
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
        private class scoreListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                owner.showScore();
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
        private static ArrayList<Pellet> p = new ArrayList<Pellet>();
        private ArrayList<Animatable> animationObjects;
        private int frame=0;
        private boolean left;
        private boolean right;
        private boolean up;
        private boolean down;
        private Pacman pac;
        private boolean aa;
        private boolean d;
        private boolean w;
        private boolean s;

        //private Pacman pac;
        private player1 play1;
        private player2 play2;

        public static ArrayList<Pellet> getPellets() {
            return p;
        }

        public static void removePellet1(Pellet pp) {
            p.remove(pp);
        }

        public static void removePellet2(int index) {
            p.remove(index);
            System.out.println("removed pellet");
        }
        private int counter1 = 5;
        private int counter2 = 0;

        public GamePanel(HomePanel a, HomeScreen HomeScreen){
           this.a=a;
           owner=HomeScreen;
           setPreferredSize(new Dimension(800, 400));
           setLayout(new BorderLayout());

            animationObjects = new ArrayList<Animatable>();
            myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB); 
            myBuffer = myImage.getGraphics(); 
            myBuffer.fillRect(0,0,FRAME,FRAME);

            t = new Timer(100, new AnimationListener());
            t.start();

            addKeyListener(new Key());
            setFocusable(true);
      
            left = false;
            right = false;
            up = false;
            down = false;

            play1 = new player1(); 
            play2 = new player2();

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
            g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
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
            //  if (counter1 + counter2 == 5){
            //     if (counter1 > counter2){
            //         g.setColor(Color.BLACK);
            //         g.fillRect(0, 0, 800, 400);
            //         g.setColor(Color.BLUE);
            //         g.setFont(new Font("Serif", Font.BOLD, 50));
            //         g.drawString("Player 1 is the Winner", 150, 200);
            //     } else {
            //         g.setColor(Color.BLACK);
            //         g.fillRect(0, 0, 800, 400);
            //         g.setColor(Color.BLUE);
            //         g.setFont(new Font("Serif", Font.BOLD, 50));
            //         g.drawString("Player 2 is the Winner", 150, 200);
            //     }
            //  }
            
              play1.drawMe(g);
              play2.drawMe(g);
              //animationObjects.add(pac);
              animationObjects.add(play1);
              animationObjects.add(play2);
              
        }
        public void animate(){
            //pac.drawMe(g);
            myBuffer.fillRect(0,0,800,400);
            for(Animatable animationObject : animationObjects)
            {
                animationObject.step();  //Every Animatable object knows how to do one animation step
                animationObject.drawMe(myBuffer);  //Every Animatable object knows how to draw itself on a Graphics object
                play1.eatPellet();
                play2.eatPellet();
            }
            repaint();
        }
        private class AnimationListener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
            {
                animate();  //...hence animation!
            }
        }
        private class Key extends KeyAdapter 
        {
            public void keyPressed(KeyEvent e) 
            {
                if(e.getKeyCode() == KeyEvent.VK_LEFT && !left) {
                 //System.out.println("left");
                   //pac.setDX(-1);
                   //pac.setDY(0);
                   play1.setX(play1.getX() - 25);
                   left = true;
                   right = false;
                   up = false;
                   down = false;
                   //System.out.println(getPellets());
                 }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT && !right) {
                 //System.out.println("right");
                 //   pac.setDX(1);
                   //pac.setDY(0);
                   play1.setX(play1.getX() + 25);
                   right = true;
                   left = false;
                   up = false;
                   down = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP && !up) {
                 //System.out.println("up");
                   //pac.setDY(-1);
                   //pac.setDX(0);
                   play1.setY(play1.getY() - 25);
                   up = true;
                   left = false;
                   right = false;
                   down = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN && !down) {
                    //System.out.println("down");
                      //pac.setDY(1);
                      //pac.setDX(0);
                      play1.setY(play1.getY() + 25);
                      down = true;
                      left = false;
                      right = false;
                      up = false;
                   }
   
                   if(e.getKeyCode() == KeyEvent.VK_A && !left) {
                       //System.out.println("left");
                         //pac.setDX(-1);
                         //pac.setDY(0);
                         play2.setX(play2.getX() - 25);
                         aa = true;
                         d = false;
                         w = false;
                         s = false;
                         //System.out.println(getPellets());
                   }
                   if(e.getKeyCode() == KeyEvent.VK_D && !right) {
                       //System.out.println("right");
                       //   pac.setDX(1);
                         //pac.setDY(0);
                         play2.setX(play2.getX() + 25);
                         aa = false;
                         d = true;
                         w = false;
                         s = false;
                      }
                      if(e.getKeyCode() == KeyEvent.VK_W && !up) {
                        //System.out.println("up");
                          //pac.setDY(-1);
                          //pac.setDX(0);
                          play2.setY(play2.getY() - 25);
                          w = true;
                          aa = false;
                          d = false;
                          s = false;
                       }
                       if(e.getKeyCode() == KeyEvent.VK_S && !down) {
                        //System.out.println("down");
                          //pac.setDY(1);
                          //pac.setDX(0);
                          play2.setY(play2.getY() + 25);
                          s = true;
                          aa = false;
                          d = false;
                          w = false;
                       }
      }
      
      public void keyReleased(KeyEvent e) 
             {
                if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                   //play1.setDX(play1.getDX()+ 1);
                   left = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    //play1.setDX(play1.getDX() - 1); 
                   right = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    //play1.setDY(play1.getDY() + 1);
                   up = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    //play1.setDY(play1.getDY() - 1);
                   down = false;
                }    

                if(e.getKeyCode() == KeyEvent.VK_A) {
                    //play1.setDX(play1.getDX()+ 1);
                    aa = false;
                 }
                 if(e.getKeyCode() == KeyEvent.VK_D) {
                    //play1.setDX(play1.getDX() - 1); 
                    d = false;
                 }
                 if(e.getKeyCode() == KeyEvent.VK_W) {
                    //play1.setDY(play1.getDY() + 1);
                    w = false;
                 }
                 if(e.getKeyCode() == KeyEvent.VK_S) {
                    //play1.setDY(play1.getDY() - 1);
                    s = false;
                 }
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
            setLayout(null); // Set null layout
            
            ImageIcon back = new ImageIcon("CSback2.png");
            JButton backButton = new JButton(back);
            backButton.setBounds(15, 10, 80, 70); // Set the button's position and size
            backButton.addActionListener(new backListener());
            add(backButton); // Add the button to the frame

            setSize(400, 300); // Set the frame size
            setVisible(true); 
            }
            private class backListener implements ActionListener{
                public void actionPerformed(ActionEvent e){
                    owner.showHome();
                }
            }
            @Override
            protected void paintComponent(Graphics s) {
                super.paintComponent(s);
                drawSettings(s); 
                
            }
        //draws the settings menu
        public void drawSettings(Graphics s){
            s.setColor(Color.YELLOW);
            s.fillRect(0, 0, 500, 500);  
            s.setFont(new Font("Serif", Font.BOLD, 50));
            s.setColor(Color.BLACK);
            s.drawString("Settings", 130, 60);
            s.setFont(new Font("Serif", Font.BOLD, 20));
            s.drawString("Movement:", 8, 100);
            s.drawString("Player 1:", 8, 120);
            s.drawString(" Use Arrow keys to control Pac-Man", 3, 140);
            s.drawString("Player 2:", 8, 165);
            s.drawString("Use WASD to control Pac-Man", 8, 185);
            s.drawString("Gameplay:", 8, 220);
            s.drawString("Both players should avoid hitting walls", 8, 240);
            s.drawString("How to Win:", 8, 280);
            s.drawString("Players compete to see which player can", 8, 300);
            s.drawString("collect the most pellets", 8, 320);

            

        }
    }

    class ScorePanel extends JPanel{
        private HomePanel a;
        private HomeScreen owner; 
        JTextField sFields = new JTextField("0", 10);
        JTextField[] inputFields = new JTextField[3];

        
        public ScorePanel(HomePanel a, HomeScreen HomeScreen){
            this.a = a;
            owner=HomeScreen;
            setPreferredSize(new Dimension(600, 550));
            
            ImageIcon back = new ImageIcon("CSback2.png");
            JButton backButton = new JButton(back);
            backButton.setBounds(15, 10, 100, 100); // Set the button's position and size
            backButton.addActionListener(new backListener());
            add(backButton); // Add the button to the frame

            setSize(400, 300); // Set the frame size
            setVisible(true); 
            
            
            //Top
        JPanel topSubPanel = new JPanel();
        topSubPanel.setLayout(new GridLayout(1, 3));

        JLabel omLabel = new JLabel("Scores");
        omLabel.setFont(new Font("Arial", Font.BOLD, 15));
        topSubPanel.add(omLabel);

        JButton scvButton = new JButton("Show current values");
        JButton mfasButton = new JButton("Modify fields as shown");
        scvButton.addActionListener(new SCVListener());
        mfasButton.addActionListener(new MFASListener());
        topSubPanel.add(scvButton);
        topSubPanel.add(mfasButton);
      
        add(topSubPanel, BorderLayout.NORTH);

        //Bottom
        JPanel bottomSubpanel = new JPanel();
        bottomSubpanel.setLayout(new GridLayout(1,4));
      
        JLabel slLabel = new JLabel("Save/Load:");
        slLabel.setFont(new Font("Arial", Font.BOLD, 15));
        bottomSubpanel.add(slLabel);
      
        bottomSubpanel.add(sFields);
      
        JButton stfButton = new JButton("Save to file");
        JButton lffButton = new JButton("Load from file");
        stfButton.addActionListener(new STFListener());
        lffButton.addActionListener(new LFFListener());
        bottomSubpanel.add(stfButton);
        bottomSubpanel.add(lffButton);
        
        add(bottomSubpanel, BorderLayout.SOUTH);

        //Left
        JPanel westSubpanel = new JPanel();
        westSubpanel.setLayout(new GridLayout(3,1));
        
        JLabel[] wLabels = new JLabel[3];
        wLabels[0] = new JLabel("Your Name:");
        wLabels[1] = new JLabel("Score:");
        wLabels[2] = new JLabel("Date(mm/dd/yyyy):");
        
        for(int i=0; i<3; i++){
            wLabels[i].setFont(new Font("Arial", Font.BOLD, 15));
            westSubpanel.add(wLabels[i]);
        }
        
        add(westSubpanel, BorderLayout.WEST);
        
        //east
        JPanel eastSubpanel = new JPanel();
        eastSubpanel.setLayout(new GridLayout(3,1));
        
        for(int i=0; i<3; i++){
            inputFields[i] = new JTextField("0", 20);
            eastSubpanel.add(inputFields[i]);
        }
        
        add(eastSubpanel, BorderLayout.EAST);
    }
    Scores player = new Scores();
    private class SCVListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           inputFields[0].setText(""+player.getname());
           inputFields[1].setText(""+player.getscore());
           inputFields[2].setText(""+player.getdate());
        }
     }
     private class MFASListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           player.setname(inputFields[0].getText());
           player.setdate((inputFields[2].getText()));
           player.setscore(Integer.parseInt(inputFields[1].getText()));
        }
     }
     private class STFListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           try{
              player.save(sFields.getText());
           }catch(Exception ex){
              System.out.println("error " + ex);
           }
        }
     }
     private class LFFListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           try{
              player.load(sFields.getText());
           }catch(Exception ex){
              System.out.println("error " + ex);
           }
        }
     }
     private class backListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            owner.showHome();
        }
    }

  }
        
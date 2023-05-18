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

        
        
        public HomeScreen(JFrame f)
        {   
            owner=f;
            setLayout(new BorderLayout());
            
            home = new HomePanel(this);
            add(home);
            game = new GamePanel(home,this);
        }
        // Used to tell the actionListener to switch panels
        public void showGame(){
            remove(home);
            add(game);
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
        private class PlayListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
               owner.showGame();
            }
    }
}
    // Game #to be updated
    class GamePanel extends JPanel{
        private HomePanel a;
        private HomeScreen owner;
        
        private ArrayList<Animatable> animationObjects = new ArrayList<Animatable>();

        private Timer t;

        private BufferedImage myImage;
        private Graphics myBuffer;
        
        private int frame = 0;
        public GamePanel(HomePanel a, HomeScreen HomeScreen){
           this.a=a;
           owner=HomeScreen;
           setPreferredSize(new Dimension(800, 400));
           setLayout(new BorderLayout());
           animationObjects = new ArrayList<Animatable>();
           t = new Timer(5, new AnimationListener());
           t.start();
        //    Pacman paccyboi = new Pacman();
        //    animationObjects.add(paccyboi);
           
        }
        // This draws the map and GamePanel calls this
        @Override
        protected void paintComponent(Graphics g) {
            //g.drawImage(myImage,0,0,getWidth(), getHeight(),null);
            super.paintComponent(g);
            drawMap(g);
            Pacman paccyboi = new Pacman();
            animationObjects.add(paccyboi);
        }
        public void drawMap(Graphics g){
            g.drawImage(myImage,0,0,getWidth(), getHeight(),null);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 800, 400);
            g.setColor(Color.BLUE);
            g.fillRect(0, 150, 50, 20);
            g.fillRect(0, 200, 50, 20);
            
        }
        
        public void animate()
        {
            for(Animatable animationObject:animationObjects)
            {
                animationObject.step();
                animationObject.drawMe(myBuffer);
            }
            repaint();
        }
        private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         if(frame<=500){
            animate();  //...hence animation!
            frame+=1;
         }else{
            t.stop();
         }
      }
   }

        
    }    
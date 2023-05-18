import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelSwap{
   public static void main(String[] args){ 
      JFrame frame = new JFrame("Panal Swap");
      //frame.setSize(600, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new ATNPanel(frame));
      frame.pack();
      frame.setVisible(true);
   }
}



class ATNPanel extends JPanel{
   private JFrame owner;
   private AddPanel adder;
   private ResultsPanel results;
   
   public ATNPanel(JFrame f){
      owner=f;
      setLayout(new BorderLayout());
      add(new JLabel("Add two numbers!"), BorderLayout.NORTH);
      
      adder = new AddPanel(this);
      add(adder);
      results = new ResultsPanel(adder,this);
   }
   
   public void showResult(){
      remove(adder);
      add(results);
      repaint();
      revalidate();
      owner.pack();
      
      results.updateNumber();
   }
   public void showAdd(){
      remove(results);
      add(adder);
      repaint();
      revalidate();
      owner.pack();
      
      adder.reset();
   }
}



class AddPanel extends JPanel{
   private ATNPanel owner;
   private int total;
   private JTextField leftField, rightField;
   public AddPanel(ATNPanel atnPanel){
      owner=atnPanel;
      setPreferredSize(new Dimension(300,300));
      setLayout(new GridLayout(1,3));
      
      leftField = new JTextField("",1);
      leftField.setHorizontalAlignment(SwingConstants.CENTER);
      rightField = new JTextField("",1);
      rightField.setHorizontalAlignment(SwingConstants.CENTER);
      JButton addButton = new JButton("Add");
      addButton.addActionListener(new AddListener());
      
      add(leftField);
      add(addButton);
      add(rightField);
   }
   private class AddListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         total = Integer.parseInt(leftField.getText()) + Integer.parseInt(rightField.getText());
         owner.showResult();
      }
   }
   public int getTotal(){return total;}
   public void reset(){
      leftField.setText("");
      rightField.setText("");
   }
}



class ResultsPanel extends JPanel{
   private JLabel sumLabel;
   private int sum;
   private AddPanel a;
   private ATNPanel owner;
   
   public ResultsPanel(AddPanel a, ATNPanel atnPanel){
      this.a=a;
      owner=atnPanel;
      
      setPreferredSize(new Dimension(250, 250));
      setLayout(new GridLayout(2, 1));
      sumLabel =new JLabel(""+sum); 
      sumLabel.setHorizontalAlignment(SwingConstants.CENTER);
      add(sumLabel);
      
      JButton NNButton = new JButton("New Numbers");
      NNButton.addActionListener(new NNListener());
      add(NNButton);
   }
   
   public void updateNumber(){
      sumLabel.setText(""+a.getTotal());
   }
   
   private class NNListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         owner.showAdd();
      }
   }
}


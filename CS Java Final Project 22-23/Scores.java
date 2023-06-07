import java.io.File;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Scores {
    private String name;
    private int score;
    private String date;

    //Constructor
    public Scores(){
        name = "Shayan";
        score = 100;
        date = "6/5/2023";
    }

    //Read file
    public Scores(String filename) throws Exception{
        Scanner infile = new Scanner(new File(filename));
        name = infile.nextLine().strip();
        score = Integer.parseInt(infile.nextLine().strip());
        date = infile.nextLine().strip();
    }

    //Load
    public void load (String filename) throws Exception{
        Scanner infile = new Scanner(new File(filename));
        name = infile.nextLine().strip();
        score = Integer.parseInt(infile.nextLine().strip());
        date = infile.nextLine().strip();
    }

    public static void main(String[] args) throws Exception{
        Scores player = new Scores();
        player.save("7-Blue");
    }

    //Save
    public void save(String filename) throws Exception{
        PrintWriter outfile = new PrintWriter(new FileWriter(filename));
        outfile.println(name);
        outfile.println(score);
        outfile.println(""+date);
        outfile.close();
    }

    //Get
    public String getname(){
        return name;
    }    
    public int getscore(){
        return score;
    }
    public String getdate(){
        return date;
    }

    //Set
    public void setname(String input){
        name = input;
    }
    public void setscore(int input){
        score = input;
    }
    public void setdate(String input){
        System.out.println("Your score was " + score + " on " + date);
        date = input;
    }
}


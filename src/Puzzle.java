import java.io.*;
import java.util.ArrayList;

public class Puzzle {

 public static final String puzzleName = "";
 public static int puzzleID = 0;
 public static String puzzleAnswer = "";
 public static final String puzzleLocation = "";
 public static int floorNumber;
  public static String puzzleDescription = "";
 public static final String puzzleReward = "";
 public static ArrayList<String> hints;
	
	
// Make sure this is right
 	
 	Puzzle (){
 		hints = new ArrayList<String>();
 	}
 	
 	public void setAnswer(String s) {
 		this.puzzleAnswer = s;
 	}
 	
 	public void setID(int id) {
 		this.puzzleID = id;
 	}
 	
 	public void setQuestion(String s) {
 		this.puzzleDescription = s;
 	}
 	
 	public void addHint(String s) {
 		hints.add(s);
 	}
 	
 	public void setFloor(int floorNumber) {
 		this.floorNumber = floorNumber;
 	}
 	
 	public void setDescription(String s) {
 		this.puzzleDescription = s;
 	}
 	
 
	
	
}

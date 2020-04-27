import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PuzzleLoader {
	private static String PUZZLE_FILE_NAME = "puzzles.txt";
	private static File puzzleFile;
	private static Scanner fileScanner;
	private static ArrayList<Puzzle> puzzleList;
	
	/* initializing the file */
	public static void init() {
		puzzleList = new ArrayList<Puzzle>();
		File puzzleFile = new File(PUZZLE_FILE_NAME);
		try {
			fileScanner = new Scanner(puzzleFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void run() {
		
		while (fileScanner.hasNext()) {
			
			// next line of file
			String nextLine = fileScanner.nextLine();
			
			// set up string array for each room's csv line
			String[] splitLine = nextLine.split(";");
			ArrayList<String> temp = new ArrayList<String>();
			for (String s : splitLine) {
				temp.add(s);
			}
			
			
			Puzzle p = new Puzzle();
			p.setID(Integer.valueOf(temp.get(0)));
			temp.remove(0);
			p.setFloor(Integer.valueOf(temp.get(0)));
			temp.remove(0);
			p.setDescription(temp.get(0));
			temp.remove(0);
			p.setAnswer(temp.get(temp.size() - 1).toLowerCase());
			temp.remove(temp.size() - 1);
			
			for (String s : temp) {
				p.addHint(s);
			}
			
			Random r = new Random();
			p.setRoomNumber(((p.getFloor() * 10) + (r.nextInt(9) + 1)) - 10);
			
			if (p.getFloor() == 1) {
				p.setAttempts(5);
			}
			else if (p.getFloor() == 2) {
				p.setAttempts(4);
			}
			else if (p.getFloor() == 3) {
				p.setAttempts(3);
			}
			else {
				;
			}
			
			puzzleList.add(p);
			
		}
		
		
	}
	
	public static ArrayList<Puzzle> getPuzzles() {
		return puzzleList;
	}
	
	

}

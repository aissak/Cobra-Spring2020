import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PuzzleLoader {
	private static String PUZZLE_FILE_NAME = "puzzles.txt";
	private static Scanner fileScanner;
	private static ArrayList<Puzzle> puzzleList;
	private static File puzzleFile;
	
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
			//System.out.println(nextLine);
			
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
			p.setAnswer(temp.get(temp.size() - 1));
			System.out.println(temp.get(temp.size() - 1));
			temp.remove(temp.size() - 1);
			
			for (String s : temp) {
				p.addHint(s);
			}
			System.out.println(p.hints);
			
			
			
			//Room r = new Room(splitLine);
			//System.out.println(p);
			//puzzleList.add(p);
			//System.out.println("---");
				
		}
		
		
		//System.out.println(puzzleList.size());
		//for (Puzzle p : puzzleList) {
		//	System.out.println(p.toString());
		//}
		
	}
	
	

}

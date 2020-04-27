import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MonsterLoader {
	
	/* this is the ArrayList of Monsters we will return to MadMansionFX.java */
	private static ArrayList<Monster> monsterList;
	
	/* the file name */
	private static String MONSTER_FILE_NAME = "monsters.txt";
	
	/* the virtual file */
	private static File monsterFile;
	
	/* the scanner */
	private static Scanner fileScanner;
	
	
	
	
	
	/* just initializing the scanner and opening the file */
	public static void init() {
		monsterFile = null;
		monsterList = new ArrayList<Monster>();
		File monsterFile = new File(MONSTER_FILE_NAME);
		try {
			fileScanner = new Scanner(monsterFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/* where the magic happens: */
	public static void run() {
		
		/* while there's a next puzzle line: */
		while (fileScanner.hasNext()) {
			
			// get the next line of file 
			String nextLine = fileScanner.nextLine();
			
			if (nextLine.startsWith("//")) {
				;
			}
			else {
				System.out.println(nextLine);
				
				// separate out every phrase by semicolons;
				String[] splitLine = nextLine.split(";");
				
				// this is an ArrayList that holds the Puzzle's data
				ArrayList<String> tempData = new ArrayList<String>();
				
				// add said data
				for (String s : splitLine) {
					tempData.add(s);
					System.out.println(s);
				}
				
				
				
				/*
				 * The ArrayList of our Puzzle now looks like this:
				 * 
				 * puzzleData = [PuzzleID], [FloorNumber], [Description], ...[Any hints given]..., [PuzzleAnswer];
				 * 
				 * 
				 * 
				 * Monster(int monsterID, 
			String monsterName, 
			int playerHPGain, 
			int playerAPGain, 
			int[] monsterHP, 
			int[] monsterAD, 
			int[] monsterArmor) {
				 * 
				 * 
				 * 
				 * We don't know how many hints the Puzzle has, if it even has any, we have to work from both ends to get to them.
				 */
				
				
				// creating a new Puzzle object
				int[] tempMonsterHP = new int[2];
				int[] tempMonsterAD = new int[2];
				int[] tempMonsterArmor = new int[2];
				tempMonsterHP[0] = Integer.valueOf(tempData.get(3));
				tempMonsterHP[1] = Integer.valueOf(tempData.get(4));
				tempMonsterAD[0] = Integer.valueOf(tempData.get(5));
				tempMonsterAD[1] = Integer.valueOf(tempData.get(6));
				tempMonsterArmor[0] = Integer.valueOf(tempData.get(7));
				tempMonsterArmor[1] = Integer.valueOf(tempData.get(8));
				
				Monster monster = new Monster(Integer.valueOf(tempData.get(0)), // monster ID
						tempData.get(1), // monster name
						Integer.valueOf(tempData.get(2)), // health points given to the player
						Integer.valueOf(tempData.get(3)), // attack points given to the player
						tempMonsterHP, // monster HP range
						tempMonsterAD, // monster AD range
						tempMonsterArmor); // monster Armor range
				
			
			
				/*
				 * ASSIGNING THE PUZZLE ROOM:
				 * 
				 * There are 3 floors.
				 * Each puzzle was assigned to a certain floor in the data file.
				 * Each floor has one 'boss room' which cannot have a puzzle.
				 * It is the 10th room on each floor. So:
				 * - Floor 1: Room 10 cannot have a puzzle
				 * - Floor 2: Room 20 cannot have a puzzle
				 * - Floor 3: Room 30 cannot have a puzzle
				 * 
				 * Otherwise, the other 9 rooms have an equal chance to get the puzzle randomly.
				 */
				
				// random:
				Random r = new Random();
				
				/*
				 * Assigning the room number:
				 * 
				 * Example, let's say that p.getFloor() gives you Floor 2.
				 * 
				 * (p.getFloor() * 10) = 20;
				 * (r.nextInt(9) + 1) = random(1-9);
				 * 
				 * BEST CASE: 20 + 9 = 29;
				 * WORST CASE: 20 + 1 = 21;
				 * 
				 * Which is actually Floor 3, because Floor 1 is 1-9, Floor 2 is 11-19, Floor 3 is 21-29, excluding boss rooms.
				 * 
				 * So subtract to give you the Room range for the assigned floor in the text file.
				 */
				
				//p.setRoomNumber(((p.getFloor() * 10) + (r.nextInt(9) + 1)) - 10);
				
				// the document states that puzzles on floor 1 get 5 attempts, floor 2 gets 4, and floor 3 gets 3.
				//if (p.getFloor() == 1) {
				//	p.setAttempts(5);
				//}
				//else if (p.getFloor() == 2) {
				//	p.setAttempts(4);
				//}
				//else if (p.getFloor() == 3) {
				//	p.setAttempts(3);
				//}
				//else {
				//	;
				//}
				
				// add it to our Puzzle ArrayList that we send to the game, and all Puzzles are ready for use.
				monsterList.add(monster);
				
			}
		}
		
		
		
	}
	
	// method to get the Puzzle ArrayList.
	public static ArrayList<Monster> getMonsters() {
		return monsterList;	
		}
	
	

}

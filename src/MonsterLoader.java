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
	
	
	
	
	public static void run() {
		
		while (fileScanner.hasNext()) {
			
			String nextLine = fileScanner.nextLine();
			
			if (nextLine.startsWith("//")) {
				;
			}
			else {
				System.out.println(nextLine);
				
				String[] splitLine = nextLine.split(";");
				
				ArrayList<String> tempData = new ArrayList<String>();
				
				for (String s : splitLine) {
					tempData.add(s);
					System.out.println(s);
				}
				
				
			
		
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
				
			
			
			
				Random r = new Random();
				
		
				monsterList.add(monster);
				
			}
		}
		
		
		
	}
	
	public static ArrayList<Monster> getMonsters() {
		return monsterList;	
		}
	
	

}

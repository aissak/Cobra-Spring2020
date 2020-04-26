import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Room {
	private int roomID;
	private int floorNumber;
	private String roomDescription = "";
	
	
	
	
	// roomConnections order based on Never Eat Soggy Waffles; [N, E, S, W];
	private int[] roomConnections = new int[4];
	private boolean isSafePoint;
	private Set<Encounter> eventPool;
	private String toString = "";
	
	Room(String[] roomData) {
		this.roomID = Integer.valueOf(roomData[0]);

		this.floorNumber = Integer.valueOf(roomData[1]);

		this.isSafePoint = Boolean.valueOf(roomData[2]);

		this.roomDescription = roomData[3];

		/* North */
		this.roomConnections[0] = Integer.valueOf(roomData[4]);
		
		/* East */
		this.roomConnections[1] = Integer.valueOf(roomData[5]);

		/* South */
		this.roomConnections[2] = Integer.valueOf(roomData[6]);

		/* West */
		this.roomConnections[3] = Integer.valueOf(roomData[7]);
	}
	
	public String toString() {
		return "ID: " + roomID + "; " 
				+ "Floor: " + floorNumber + "; " 
				+ "Description: " + roomDescription + "; "
				+ "North: " + roomConnections[0] + "; "
				+ "East: " + roomConnections[1] + "; "
				+ "South: " + roomConnections[2]+  "; "
				+ "West: " + roomConnections[3] + ";";
	}
	

	public int getNorth() {
		return roomConnections[0];
	}
	
	public int getSouth() {
		return roomConnections[2];
	}
	
	public int getEast() {
		return roomConnections[1];
	}
	
	public int getWest() {
		return roomConnections[3];
	}
	
	public int getNumber() {
		return this.roomID;
	}
	
	public String getDescription() {
		return roomDescription;
	}
	
	
	
	

}

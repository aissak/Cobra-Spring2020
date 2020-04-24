import java.util.HashSet;
import java.util.Set;

public class Room {
	private int roomID;
	private String roomDescription = "";
	
	// roomConnections order based on Never Eat Soggy Waffles; [N, E, S, W];
	private int[] roomConnections = new int[4];
	private boolean isSafePoint;
	private Set<Encounter> eventPool;
	private String toString = "";
	
	Room(String[] roomData) {
		this.roomID = Integer.parseInt(roomData[0]);
		this.roomDescription = roomData[1];
		roomConnections[0] = Integer.parseInt(roomData[2]);
		roomConnections[1] = Integer.parseInt(roomData[3]);
		roomConnections[2] = Integer.parseInt(roomData[4]);
		roomConnections[3] = Integer.parseInt(roomData[5]);
		isSafePoint = Boolean.valueOf(roomData[6]);
		eventPool = new HashSet<>();
		toString = "Room ID: " + roomID 
				+ "\n" + "Room Description: " + roomDescription
				+ "\n" + "Room Connections: " + 
				"N" + roomConnections[0] + " " + 
				"E" + roomConnections[1] + " " + 
				"S" + roomConnections[2] + " " + 
				"W" + roomConnections[3] + "\n" + 
				"Safe: " + isSafePoint;
		
	}
	
	public String toString() {
		return toString;
	}
	
	public static void main(String[] args) {
		String[] s = new String[7];
		s[0] = "34";
		s[1] = "hello world";
		s[2] = "1";
		s[3] = "12";
		s[4] = "123";
		s[5] = "1234";
		s[6] = "false";
		Room r = new Room(s);
		System.out.println(r.toString());
		
		
				
		
	}
	
	
	
	

}

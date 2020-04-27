
public class Player {
	private int roomNumber;
	private int score;
	private int maxFloor;
	private String playerID = "";
	private Item[] inventory;
	
	public void setRoom(Room room) {
		this.roomNumber = roomNumber;
	}
	
	public int getRoom() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getPlayerID() {
		return playerID;
	}
	
	Player(String[] splitLine) {
		/* processing player text data */
		this.playerID = splitLine[0];
		this.score = Integer.valueOf(splitLine[1]);
		this.roomNumber = 1;
		
		inventory = new Item[10];
	}
	
	public String toString() {
		return "PlayerID: " + playerID
				+ "; " + "Score: " + score + "; " + "Room Number: " + roomNumber + ";";
	}
	

	
}


public class Player {
	private int roomNumber;
	private int score;
	private int maxFloor;
	private String playerID = "";
	
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
		this.playerID = splitLine[0];
		this.score = Integer.valueOf(splitLine[1]);
		this.roomNumber = 1;
		
	}
	
	public String toString() {
		return "PlayerID: " + playerID
				+ "; " + "Score: " + score + "; " + "Room Number: " + roomNumber + ";";
	}
	
	
	
	
	
	
	
}

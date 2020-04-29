
public class Player {
	private int roomNumber;
	private int score;
	private int maxFloor;
	private String playerID = "";
	private Item[] inventory;
	private int inventoryIndex;
	private int playerHealth;
	
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
		inventoryIndex = 0;
	}
	
	public String toString() {
		return "PlayerID: " + playerID
				+ "; " + "Score: " + score + "; " + "Room Number: " + roomNumber + ";";
	}
	
	public void setHealth(int i) {
		this.playerHealth = i;
	}
	
	public int getHealth() {
		return playerHealth;
	}
	
	public void addItem(Item i) {
		inventory[inventoryIndex] = i;
		inventoryIndex++;
	}
	
	public Item[] getInventory() {
		return inventory;
	}
	

	
}

import java.util.Set;

public abstract class Monster {
	private String monsterName = "";
	private String monsterDescription = "";
	private int[] monsterHP = new int[2];
	private int[] monsterAD = new int[2];
	private int[] monsterArmor = new int[2];
	private Set<Item> itemDropPool;
	
	
	/**
	 * 
	 */
	public Monster() {
	}


	/**
	 * @param monsterName
	 * @param monsterDescription
	 * @param monsterHP
	 * @param monsterAD
	 * @param monsterArmor
	 * @param itemDropPool
	 */
	public Monster(String monsterName, String monsterDescription, int[] monsterHP, int[] monsterAD, int[] monsterArmor,
			Set<Item> itemDropPool) {
		this.monsterName = monsterName;
		this.monsterDescription = monsterDescription;
		this.monsterHP = monsterHP;
		this.monsterAD = monsterAD;
		this.monsterArmor = monsterArmor;
		this.itemDropPool = itemDropPool;
	}


	/**
	 * @return the monsterName
	 */
	public String getMonsterName() {
		return monsterName;
	}


	/**
	 * @param monsterName the monsterName to set
	 */
	public void setMonsterName(String monsterName) {
		this.monsterName = monsterName;
	}


	/**
	 * @return the monsterDescription
	 */
	public String getMonsterDescription() {
		return monsterDescription;
	}


	/**
	 * @param monsterDescription the monsterDescription to set
	 */
	public void setMonsterDescription(String monsterDescription) {
		this.monsterDescription = monsterDescription;
	}


	/**
	 * @return the monsterHP
	 */
	public int[] getMonsterHP() {
		return monsterHP;
	}


	/**
	 * @param monsterHP the monsterHP to set
	 */
	public void setMonsterHP(int[] monsterHP) {
		this.monsterHP = monsterHP;
	}


	/**
	 * @return the monsterAD
	 */
	public int[] getMonsterAD() {
		return monsterAD;
	}


	/**
	 * @param monsterAD the monsterAD to set
	 */
	public void setMonsterAD(int[] monsterAD) {
		this.monsterAD = monsterAD;
	}


	/**
	 * @return the monsterArmor
	 */
	public int[] getMonsterArmor() {
		return monsterArmor;
	}


	/**
	 * @param monsterArmor the monsterArmor to set
	 */
	public void setMonsterArmor(int[] monsterArmor) {
		this.monsterArmor = monsterArmor;
	}


	/**
	 * @return the itemDropPool
	 */
	public Set<Item> getItemDropPool() {
		return itemDropPool;
	}


	/**
	 * @param itemDropPool the itemDropPool to set
	 */
	public void setItemDropPool(Set<Item> itemDropPool) {
		this.itemDropPool = itemDropPool;
	}
	
	
}

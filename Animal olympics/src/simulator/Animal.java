package simulator;

public class Animal {
	private int speed;
	private int strength;
	private int tactics;
	private int agility;
	private int skill;
	private int weight;

	public Animal(int speed, int strength, int tactics, int agility, int skill, int weight) {
		this.speed = speed;
		this.strength = strength;
		this.tactics = tactics;
		this.agility = agility;
		this.skill = skill;
		this.weight = weight;
	}

	public int getSpeed() {
		return speed;
	}

	public int getStrength() {
		return strength;
	}

	public int getTactics() {
		return tactics;
	}

	public int getAgility() {
		return agility;
	}

	public int getSkill() {
		return skill;
	}

	public int getWeight() {
		return weight;
	}
	

}

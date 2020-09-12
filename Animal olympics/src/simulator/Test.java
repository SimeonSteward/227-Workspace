package simulator;

public class Test {

	public static void main(String[] args) {
		Animal orangy = new Animal(34, 15, 12, 12, 15, 19);
		System.out.print("Speed: "+orangy.getSpeed()+ " Strength:" + orangy.getStrength() +" Tactics: "+ orangy.getTactics()+" Agility: "+orangy.getAgility()+" Skill: "+orangy.getSkill()+" Weight: "+orangy.getWeight());
	}
	public Test() {
		Animal orangy = new Animal(34, 15, 12, 12, 15, 19);
		System.out.print("Speed: "+orangy.getSpeed()+ " Strength: " + orangy.getStrength() +" Tactics: "+ orangy.getTactics()+" Agility: "+orangy.getAgility()+" Skill: "+orangy.getSkill()+" Weight: "+orangy.getWeight());
	}

}

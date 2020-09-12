package simulator;
import java.lang.*;

public class Battle {

	
	public static boolean battle(Animal fighter1, Animal fighter2) {
		int fighter1Wins=0;
		int fighter2Wins=0;
		while ((fighter1Wins < 2)&& (fighter2Wins < 2)) {
		fight(fighter1, fighter2);
		}
}//int speed, int strength, int tactics, int agility, int skill, int weight) 
	private static int fight(Animal fighter1, Animal fighter2) {
		switch ((int)Math.random()*6) {
		case 0:
			if(fighter1.getSpeed()<fighter2.getSpeed()) return (1);
			if(fighter1.getSpeed()>fighter2.getSpeed()) return (-1);
		case 1:
			if(fighter1.getStrength()<fighter2.getStrength()) return (1);
			if(fighter1.getStrength()>fighter2.getStrength()) return (-1);
		case 2:
			if(fighter1.getTactics()<fighter2.getTactics()) return (1);
			if(fighter1.getTactics()>fighter2.getTactics()) return (-1);
		case 3:
			if(fighter1.getAgility()<fighter2.getAgility()) return (1);
			if(fighter1.getAgility()>fighter2.getAgility()) return (-1);
		case 4:
			if(fighter1.getSkill()<fighter2.getSkill()) return (1);
			if(fighter1.getSkill()>fighter2.getSkill()) return (-1);
		case 5:
			if(fighter1.getWeight()<fighter2.getWeight()) return (1);
			if(fighter1.getWeight()>fighter2.getWeight()) return (-1);

		default:
			return 0;
		}
	}
}

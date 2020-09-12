package mini1;

public class Test {
	public static void main(String[] args) {
		
		//findNth Tests
		System.out.println(KeepMeInTheLoop.findNth("mississippi", 's', 1)); //2
		System.out.println(KeepMeInTheLoop.findNth("mississippi", 's', 4)); //6
		System.out.println(KeepMeInTheLoop.findNth("mississippi", 's', 5)); //-1
		System.out.println(KeepMeInTheLoop.findNth("mississippi", 'w', 1)); //-1
		System.out.println();
		
		//findStoppingTime Tests
		System.out.println(KeepMeInTheLoop.findStoppingTime(6)); //8
		System.out.println(KeepMeInTheLoop.findStoppingTime(0)); //-1
		System.out.println();
		
		//howLong Tests
		System.out.println(KeepMeInTheLoop.howLong(100, 20,0,0));
		
		//isIBeforeE
		System.out.println(KeepMeInTheLoop.isIBeforeE("banana")); //true
		System.out.println(KeepMeInTheLoop.isIBeforeE("conceive")); //true
		System.out.println(KeepMeInTheLoop.isIBeforeE("ieicei")); //false
		System.out.println(KeepMeInTheLoop.isIBeforeE("caei")); //false
		System.out.println(KeepMeInTheLoop.isIBeforeE("weigh")); //false
		System.out.println();
		
		//findSecondLargest
		System.out.println(KeepMeInTheLoop.findSecondLargest("42 137 -7 42 66 55"));
		System.out.println(KeepMeInTheLoop.findSecondLargest("5 5 5 3"));
		System.out.println();
		
		//doubleConstants
		System.out.println(KeepMeInTheLoop.doubleConsonants("rabbits44a"));
		
		//isPermutation
		System.out.println(KeepMeInTheLoop.isPermutation("apple","leppa" )); //true
		System.out.println(KeepMeInTheLoop.isPermutation("apple","leppap" )); //false
		System.out.println(KeepMeInTheLoop.isPermutation("apple","peppa" )); //false
		System.out.println();
		
		//containsWithGaps
		System.out.println(KeepMeInTheLoop.containsWithGaps("temperamental", "meme"));
		System.out.println(KeepMeInTheLoop.containsWithGaps("temperamental", "alarm"));
		System.out.println(KeepMeInTheLoop.containsWithGaps("temperamental", "total"));
		System.out.println(KeepMeInTheLoop.containsWithGaps("temperamental", "temperamental"));
		System.out.println(KeepMeInTheLoop.containsWithGaps("temperamental", "temperamentally"));
		System.out.println(KeepMeInTheLoop.containsWithGaps("temperamental", ""));
		
		
		
	}
}

package mini1;

import java.util.Arrays;
import java.util.Scanner;

public class KeepMeInTheLoop {
	private KeepMeInTheLoop() {
		
	}

	public static int findNth(String s, char ch, int n) {
		int b = 0;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == ch) {
				b++;
				if (b == n) {
					return i;
				}
			}
		}
		return -1;
	}

	public static String doubleConsonants(String s) {
		String newString = "";
		for (int i = 0; i < s.length() - 1; i++) {
			if (-1 < "aeiouAEIOU".lastIndexOf(s.charAt(i))) { // is a vowel?
				newString = newString + s.charAt(i);
			} else {
				newString = newString + s.charAt(i) + s.charAt(i);
				if (s.charAt(i) == s.charAt(i + 1)) {
					
					i++;
					if (i==s.length()-1) {
						return newString;
					}
				}
			}
		}
		if (-1 < "aeiouAEIOU".lastIndexOf(s.charAt(s.length() - 1))) { // is a vowel?
			newString = newString + s.charAt(s.length() - 1);
		} else {
			newString = newString + s.charAt(s.length() - 1) + s.charAt(s.length() - 1);
		}
		return newString;
	}

	public static int findStoppingTime(int n) {
		if (n > 0) {
			int i = 0;
			while (n != 1) {
				i++;
				if ((n % 2) == 0) {
					n /= 2;
				} else {
					n = 3 * n + 1;
				}
			}
			return i;
		} else {
			return -1;
		}
	}

	public static int howLong(double balance, double monthlyCost, double interestRate, double increase) {
		if (monthlyCost <=balance * (interestRate/12)){
			return 0;
		}
		double currentBalance = balance;
		int months = 0;
		while ((currentBalance - (monthlyCost + months * increase)) >= 0) {
			
			currentBalance -= monthlyCost + months * increase;
			currentBalance += (interestRate/12) * currentBalance;
			months++;
		}
		return months;
	}

	public static boolean isIBeforeE(String s) {
		if ((s.charAt(1) == 'i')&&(s.charAt(0) == 'e')) {
				return false;
			}
		for (int i = 1; i < s.length() - 1; i++) {
			if (s.charAt(i) == 'e') {
				if ((s.charAt(i + 1) == 'i') && ((s.charAt(i - 1) != 'c'))) {
					return false;
				}
			}
			if (s.charAt(i) == 'i') {
				if ((s.charAt(i + 1) == 'e') && ((s.charAt(i - 1) == 'c'))) {
					return false;
				}
			}
		}
		return true;
	}

	public static int findSecondLargest(String nums) {
		Scanner s = new Scanner(nums);
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		while (s.hasNextInt()) {
			int temp = s.nextInt();
			if (temp > largest) {
				secondLargest = largest;
				largest = temp;
			} else if (temp > secondLargest) {
				secondLargest = temp;
			}
		}
		s.close();
		return secondLargest;
	}

	public static boolean isPermutation(String s, String t) {
		if (t.length() != s.length()) {
			return false;
		}
		char[] sArr = new char[s.length()];
		char[] tArr = new char[t.length()];
		for (int i = 0; i < s.length(); i++) {
			sArr[i] = s.charAt(i);
		}
		for (int i = 0; i < s.length(); i++) {
			tArr[i] = t.charAt(i);
		}
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		for (int i = 0; i < tArr.length; i++) {
			if (sArr[i] != tArr[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean containsWithGaps(String source, String target) {
		int t = 0;
		if (target.length()==0) {
			return true;
		} else if(source.length()==0) {
			return false;
		}
		for (int i = 0; i < source.length(); i++) {
			if (source.charAt(i)==target.charAt(t)) {
				t++;
			}
			if (t==target.length()) {
				return true;
			}
		}
		return false;

	}

}

package exam2Review;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;


public class Exam2Tests {
	public static void main(String[] args) {
		System.out.println(findJumps(2));
		System.out.println(findJumps(3));
		System.out.println(findStreetCombinations(2, 2));
		System.out.close();
		System.out.print("itn");
		int[] nums = new int[] {1,3,1,4,3,9,8};
		sort(nums);
		System.out.println(Arrays.toString(nums));
		File file = new File("/Users/SimeonSteward/eclipse-workspace/227 Scratchpad/src");
		ArrayList<String> names = new ArrayList<String>();
		findJavaFiles(file,names);
		System.out.println(names.toString());
	}
	
	private static void sort(int[] nums) {
		for(int i = 0;i<nums.length; i++) {
			int index = i;
			for(int j = i;j<nums.length; j++) {
				if (nums[index]>nums[j]) {
					index = j;
				}
			}
			int temp = nums[i];
			nums[i] = nums[index];
			nums[index] = temp;
		}
	}
	private static int findJumps(int n) {
		if(n==0) {
			return 1;
		}else if (n<0){
			return 0;
		}else {
			return (findJumps(n-1)+findJumps(n-2)+findJumps(n-3));
		}
	}
	private static int findStreetCombinations(int r, int c) {
		if(r==0||c==0) {
			return 1;
		}else {
			return findStreetCombinations(r-1,c)+findStreetCombinations(r,c-1);
		}
	}
	
	private static void findJavaFiles(File file, ArrayList<String> results) {
		File[] files = file.listFiles();
		for(int i = 0; i<files.length;i++) {
			if (files[i].isDirectory()) {
				results.add(files[i].getName());
				findJavaFiles(files[i],results);
			}else if(files[i].getName().contains(".java")) {
				results.add(files[i].getName());
			}
		}
	}
	
	
}

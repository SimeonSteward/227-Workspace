package mini2;

import java.util.Arrays;
import java.util.ArrayList;

public class HipHipArray {
	private HipHipArray() {

	}

	public static int[] makeHistogram(double[] data, int numBins, double min, double max) {
		double binSize = (max-min)/numBins;
		int[]num = new int[numBins];
		for (int i = 0; i < num.length; i++) {
			int k = 0;
			for(int j = 0; j < data.length; j++) {
				if (min+(binSize*i)<=data[j] && min+(binSize*(i+1))>data[j]) {
					k++;
				}
			}
			num[i] = k;
		}
	return num;
	}
	public static boolean isPermutation(int[] arr) {
		int arr1[] = arr.clone();
		Arrays.sort(arr1);
		for (int i = 0; i < arr1.length; i++) {
			if(i!=arr1[i]) {
				return false;
			}
		}
		return true;
	}
	public static int[] createPalindrome(int[] arr) {
		int arr1[] = new int[Math.max(0,(arr.length*2-1))];
		for (int i = 0; i < arr.length; i++) {
			arr1[i] = arr[i];
		}
		for (int i = 0; i < arr.length; i++) {
			arr1[arr.length+i-1] = arr[arr.length-(i+1)];
		}
		return arr1;
	}
	public static boolean[] makeSieve(int size,
            int[] divisors) {
		boolean sieve[]= new boolean[size];
		for (int i = 0; i < sieve.length; i++) {
			sieve[i]=true;
			for (int j = 0; j < divisors.length; j++) {
				if (i%divisors[j]==0&&i!=divisors[j]) {
					sieve[i]=false;
				}
			}
		}
		return sieve;
	}
	public static void shift(int[] arr, int amount) {
		if (amount<0) {
			for (int i = 0; i < arr.length; i++) {
				if ((i + amount)>=0) {
					arr[i+amount] = arr[i];
				}
				arr[i]=0;
			}
		} else {
			for (int i = arr.length-1; i >= 0; i--) {
				if ((i + amount)<arr.length) {
					arr[i+amount] = arr[i];
				}
				arr[i]=0;
			}
			
		}
	}
	
	
	public static void rotate(int[] arr, int amount) {
		int temp[] = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {
			temp[i] = arr[(((i-amount)%(arr.length))+arr.length)%arr.length];
		}
		for (int i = 0; i < temp.length; i++) {
			arr[i] = temp[i];
		}
		
	}
	
	public static String[] removeDups(String[] arr){
		ArrayList temp = new ArrayList();
		for (int i = 0; i < arr.length; i++) {
			if(!(temp.contains(arr[i]))){
				temp.add(arr[i]);
			}
		}
		String output[] = new String[temp.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = (String)temp.get(i);
		}
		return output;
		
	}

	public static int[] longestRun(int[] arr) {
		ArrayList current = new ArrayList();
		ArrayList max = new ArrayList();
		current.add(arr[0]);
		max.add(arr[0]);
		for (int i = 0; i < arr.length-1; i++) {
			
			if(arr[i]<=arr[i+1]) {
				current.add(arr[i+1]);
			} else {
			current.clear();
			current.add(arr[i+1]);
			
			}
			if (current.size()>max.size()) {
				max.clear();
				max.addAll(current);
				}
			
		}
		int output[] = new int[max.size()];
		for (int i = 0; i < output.length; i++) {
			output[i] = (int)max.get(i);
		}
		return output;
	}


}

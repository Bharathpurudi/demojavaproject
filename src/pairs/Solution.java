package pairs;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static int getPairsFast(int k, int[] numbers) {
		HashSet<Integer> hLow = new HashSet<>();
		HashSet<Integer> hHigh = new HashSet<>();
		HashMap<Integer, Integer> pairMap = new HashMap<Integer, Integer>();
		for (int i : numbers) {
			hLow.add(i);
			hHigh.add(i + k);
		}
		for (int i : hHigh) {
			if (hLow.contains(i)) {
				pairMap.put(i - k, i);
			}
		}
		int noOfPairs = pairMap.size();
		return noOfPairs;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		String[] numString;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the k value: ");
		int k = scanner.nextInt();
		System.out.println("Enter the space separated integers: ");
		numString = bi.readLine().split(" ");
		int[] numsArray = new int[numString.length];
		for (int i = 0; i < numString.length; i++) {
			numsArray[i] = Integer.parseInt(numString[i]);
		}
		scanner.close();
		System.out.println("The Unique pairs in the given list are " + getPairsFast(k, numsArray));
	}
}

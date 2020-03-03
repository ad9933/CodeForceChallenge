package codeForce_B_Different_Rules;

import java.util.*;

/*
 * 
 * 		Problem : https://codeforces.com/problemset/problem/1313/B		
 * 
 * 		
 * */

public class Main {

	static int t;				//Number of Cases
	
	public static void main(String[] args) {
		
		//Store inputs
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Number of Cases : ");
		t = Integer.parseInt(scanner.nextLine());
		
		TestCase[] cases = new TestCase[t];
		
		for (int caseIdx = 0; caseIdx < t; caseIdx++) {
			
			String input = scanner.nextLine();
			cases[caseIdx] = new TestCase(input);
			
		}
		
		//Process inputs
		for (int caseIdx = 0; caseIdx < t; caseIdx++) {
			
			int myScore = cases[caseIdx].x + cases[caseIdx].y;
			int lastUsedX = -1;
			int lastUsedY = -1;						//-1 if no condition.
			boolean firstRun = true;
			
			//finds cases that better persons in first rounds scores more than theGuy.
			
			if(cases[caseIdx].x == 1)
				lastUsedX = 1;
			
			for(int betterPerson = cases[caseIdx].x - 1; betterPerson > 0; betterPerson--) {
				
				
				if(myScore + 1 - betterPerson <= cases[caseIdx].n) {
					lastUsedX = betterPerson;
					firstRun = false;
				} else {
					if (firstRun)
						lastUsedX = cases[caseIdx].x;
					break;
				}
			}
			
			//same goes to second round.
			if(cases[caseIdx].y == 1)
				lastUsedY = 1;
			
			firstRun = true;
			for(int betterPerson = cases[caseIdx].y - 1; betterPerson > 0; betterPerson--) {
				
				if(myScore + 1 - betterPerson <= cases[caseIdx].n) {
					lastUsedY = betterPerson;
					firstRun = false;
				} else {
					if(firstRun)
						lastUsedY = cases[caseIdx].y;
					break;
				}
			}
			
			System.out.println((lastUsedX < lastUsedY) ? lastUsedX : lastUsedY);
			
		}
	}

}

class TestCase {
	
	int n;
	int x;
	int y;
	
	int worst;
	int best;
	
	TestCase(String inputString) {
		String[] inputArray = inputString.split(" ");
		
		if(inputArray.length != 3)
			System.out.println("Error!!! Length not 3.");
		else {
			n = Integer.parseInt(inputArray[0]);
			x = Integer.parseInt(inputArray[1]);
			y = Integer.parseInt(inputArray[2]);
		}
		
	}
}
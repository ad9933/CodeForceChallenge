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
		
		t = Integer.parseInt(scanner.nextLine());
		
		TestCase[] cases = new TestCase[t];
		
		for (int caseIdx = 0; caseIdx < t; caseIdx++) {
			
			String input = scanner.nextLine();
			cases[caseIdx] = new TestCase(input);
			
		}
		
		//Process inputs
		for (int caseIdx = 0; caseIdx < t; caseIdx++) {
			
			if(cases[caseIdx].x == cases[caseIdx].n && cases[caseIdx].y == cases[caseIdx].n) {
				System.out.println(cases[caseIdx].n + " " + cases[caseIdx].n);
				continue;
			}
			
			int myScore = cases[caseIdx].x + cases[caseIdx].y;
			int lastUsedX = -1;
			int lastUsedY = -1;						//-1 if no condition.
			boolean firstRun = true;
			
			int bestCase = 0;
			int worstCase = 0;
			
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
			
			bestCase = (lastUsedX < lastUsedY) ? lastUsedX : lastUsedY;
			
			
			//Worst Case
			
			//Initialize
			firstRun = true;
			lastUsedX = -1;
			lastUsedY = -1;
			
			if(cases[caseIdx].x == cases[caseIdx].n)
				lastUsedX = cases[caseIdx].n;
			
			for(int betterPerson = cases[caseIdx].x + 1; betterPerson <= cases[caseIdx].n; betterPerson++) {
				
				
				if(myScore - betterPerson > 0) {
					lastUsedX = betterPerson;
					firstRun = false;
				} else {
					if (firstRun)
						lastUsedX = cases[caseIdx].x;
					break;
				}
			}
			
			//same goes to second round.
			if(cases[caseIdx].y == cases[caseIdx].n)
				lastUsedY = cases[caseIdx].n;
			
			firstRun = true;
			for(int betterPerson = cases[caseIdx].y + 1; betterPerson <= cases[caseIdx].n; betterPerson++) {
				
				if(myScore - betterPerson > 0) {
					lastUsedY = betterPerson;
					firstRun = false;
				} else {
					if(firstRun)
						lastUsedY = cases[caseIdx].y;
					break;
				}
			}
			
			worstCase = (lastUsedX - 1 < lastUsedY - 1) ? lastUsedX : lastUsedY;
			System.out.println(bestCase + " " + worstCase);
			scanner.close();
			
		}
	}

}

class TestCase {
	
	int n;
	int x;
	int y;
	
	TestCase(String inputString) {
		String[] inputArray = inputString.split(" ");
		
		n = Integer.parseInt(inputArray[0]);
		x = Integer.parseInt(inputArray[1]);
		y = Integer.parseInt(inputArray[2]);
		
	}
}
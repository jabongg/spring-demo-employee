package com.dsal.java;

public class MinimumJump {

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		int[] A = {2, 1, 3, 2, 3, 4, 5, 1, 2, 8};
		int[] minJumpArray = new int[A.length];
		
		// fill all elements with infinity
		for (int i = 0; i < minJumpArray.length; i++) {
			minJumpArray[i] = 1000;
		}
		
		// initialize first element jump as zero
		minJumpArray[0] = 0;
		
		// boundary conditions
		if (A.length == 0 || A[0] == 0) {
			System.out.println("Not proper array");
			return;
		}
		
		for (int i = 1; i < A.length; i++) {
		    for (int j = 0; j < i; j++) {
		        if (i <= j + A[j]) {
		            
		            minJumpArray[i] = Math.min(minJumpArray[i], minJumpArray[j] + 1);
		        }
		    }
		}
		print(A);
		System.out.println();
		print(minJumpArray);
		System.out.println();
        System.out.println(minJumpArray[A.length - 1]);	
        System.out.println(calculateJumpCount(A));
	}
	
	public static void print(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
	
	// linear solution to ladder problem
	public static int calculateJumpCount(int[] A) {
		if (A.length <= 1) {
			return 0;
		}
		int ladder = A[0]; // keep track of largest ladder that you have
		int stairs = A[0]; // keep track of stairs in the current ladder
		
		int jump = 1;
		
		for (int level = 1; level < A.length; level++) {
			// if reached to the end of the last element of the array i.e. end
			if (level == A.length - 1) {
				return jump;
			}
			
			if (level + A[level] > ladder) {
				ladder = level + A[level]; // build up the ladder
			}
			stairs--; // use up the stairs
			
			if (stairs == 0) {
				jump++; // no stairs left, now jump
				stairs = ladder - level;
			}
		}
		return jump;
	}
}

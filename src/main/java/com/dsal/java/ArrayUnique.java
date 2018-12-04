package com.dsal.java;

public class ArrayUnique {

	/* source : geeksforgeeks
	 * Given a sorted integer array. We need to make array elements distinct by increasing values and keeping array sum minimum possible. We need to print the minimum possible sum as output.

		Examples:
		
		Input : arr[] = { 2, 2, 3, 5, 6 } ; 
		Output : 20
		Explanation : We make the array as {2, 
		3, 4, 5, 6}. Sum becomes 2 + 3 + 4 + 
		5 + 6 = 20
		
		Input : arr[] = { 20, 20 } ; 
		Output : 41
		Explanation : We make {20, 21}
		
		Input :  arr[] = { 3, 4, 6, 8 };
		Output : 21
		Explanation : All elements are unique 
		so result is sum of each elements.  
	 */
	public static void main(String[] args) {
		// sorted array
		int[] A = {2, 2, 3, 5, 6};
		
		int sum = findArrayUniqueSum(A);
		System.out.println(sum);
	}

	private static int findArrayUniqueSum(int[] a) {
		int sum = 0;
		
		for (int i = 1; i < a.length; i++) {
			/*
			 * / if the elements at i and its previous are same, 
			// then increment the elements from i till the end
			// element is less than the next element.
			// While current element is same as  
            // previous or has become smaller 
            // than previous.
             * 
			*/
			if (a[i] == a[i - 1]) {
				// Start looping from the i
				
				int j = i;
				
				while (a[j] <= a[j - 1]) {
					a[j] = a[j] + 1;
					j++;
				}
			}
			
			sum = sum + a[i];
		}
		
		return sum;
	}
}

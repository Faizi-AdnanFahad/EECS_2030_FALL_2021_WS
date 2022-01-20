
public class RecursiveMethods {
	
	
	int factorial(int i) {
		//				 Base case: 
		//				 Problem that is small enough to solve right away.
		if(i == 0) {
			return 1;
		}
		// Recursive case:
		// Problem that is too big to be solved right away.
		else { // i > 0
			return i * factorial(i - 1);
		}
	}

	int fib(int n) {
		int result; 
		if(n == 1) { /* base case */ 
			result = 1; 
		} 
		else if(n == 2) { /* base case */ 
			result = 1; 
		} 
		else { /* recursive case */
			result = fib(n - 1) + fib(n - 2);
		} 
		return result; 
	}

	static boolean isPalindrome(String word) { 
		if(word.length() == 0 || word.length() == 1) { 
			/* base case */
			return true;
		} 
		else { 
			/* recursive case */
			char firstChar = word.charAt(0);
			char lastChar = word.charAt(word.length() - 1); 
			String middle = word.substring(1, word.length() - 1);
			return
					firstChar == lastChar 
					/* See the API of java.lang.String.substring. */
					&& isPalindrome(middle);
		}
	}

	String reverseOf (String s) { 
		if(s.isEmpty()) { /* base case 1 */  
			return "";
		} 
		else if(s.length() == 1) { /* base case */ 
			return s;
		} 
		else { /* recursive case */
			String tail = s.substring(1, s.length()); 
			String reverseOfTail = reverseOf(tail);  
			char head = s.charAt(0);  
			return reverseOfTail + head;
		}
	}

	int occurrencesOf(String s, char c) {
		if(s.isEmpty()) {
			/* Base Case */
			return 0;
		}
		else {
			/* Recursive Case */
			char head = s.charAt(0);
			String tail = s.substring(1, s.length());
			if(head == c) {
				return 1 + occurrencesOf(tail, c);
			}
			else {
				return 0 + occurrencesOf(tail, c);
			}
		}
	}

	boolean allPositive(int[] a) { 
		return allPositiveHelper(a, 0, a.length - 1);
	}

	boolean allPositiveHelper(int[] a, int from, int to) { 
		if(from > to) { /* base case 1: empty range */
			return true;
		} 
		else if(from == to) { /* base case 2: range of one element */
			return a[from] > 0;
		}
		else { /* recursive case */
			return a[from] > 0 && allPositiveHelper(a, from + 1, to);
		}
	}

	boolean isSorted(int[] a) {
		return isSortedHelper(a, 0, a.length - 1);
	}

	boolean isSortedHelper(int[] a, int from, int to) {
		if(from > to) { /* base case 1: empty range */
			return true;
		} 
		else if(from == to) { /* base case 2: range of one element */
			return true;
		}
		else {
			return a[from] <= a[from + 1] 
					&& isSortedHelper(a, from + 1, to);
		}
	}
	
	/*******************************************************************************************************************************************************/
	
	/*
	 * Adnan's implementations 
	 */
	
	public static boolean palindrom(String s) {		
		if (s.length() <= 1) {
			return true;
		}
		else {
			return s.charAt(0) == s.charAt(s.length() - 1) &&
			palindrom(s.substring(1, s.length() - 1));
		}
	}
	
	public static String reverse(String word) {
		if (word.length() <= 1) {
			return word;
		}
		else {
			return word.charAt(word.length() - 1) + reverse(word.substring(1, word.length() - 1)) + word.charAt(0);
		}
	}
	
	public static int occurance(String word, char c) {
		if (word.isEmpty()) {
			return 0;
		}
		else if (word.length() == 1) {
			if (word.charAt(0) == c) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return occurance(String.valueOf(word.charAt(0)), c) 
					+ occurance(word.substring(1, word.length()), c);
		}
	}
	
	/*
	 * Solving the problem is there at least one positive number in an array?
	 */
	
	public static boolean somePositive(int[] array) {
		return somePositiveHelper(array, 0, array.length - 1);
	}
	
	public static boolean somePositiveHelper(int[] array, int firstIndex, int lastIndex) {
		if (firstIndex > lastIndex) { // When array is empty
			return false;
		}
		else if (firstIndex == lastIndex) {
			return array[firstIndex] >= 0;
		}
		else {
			return array[firstIndex] >= 0 || somePositiveHelper(array, firstIndex + 1, lastIndex);
		}
	}
	
	/*
	 * non-descending order
	 */
	
	public static boolean nonDescending(int[] array) {
		return nonDescendingHelper(array, 0, array.length - 1);
	}
	
	public static boolean nonDescendingHelper(int[] array, int firstIndex, int lastIndex) {
		if (firstIndex >= lastIndex) {
			return true;
		}
		else {
			return (array[firstIndex] <= array[firstIndex + 1]) 
					&& nonDescendingHelper(array, firstIndex + 1, lastIndex);
 		}
	}
	
	/*
	 * Given an array of ints, is it possible to choose a group of some of the ints, 
	 * such that the group sums to the given target? This is a classic backtracking recursion problem. 
	 * Once you understand the recursive backtracking strategy in this problem, 
	 * you can use the same pattern for many problems to search a space of choices. 
	 * Rather than looking at the whole array, 
	 * our convention is to consider the part of the array starting at index start and continuing to the end of the array. 
	 * The caller can specify the whole array simply by passing start as 0. 
	 * No loops are needed -- the recursive calls progress down the array.
	 */
	
	public boolean groupSum(int start, int[] nums, int target) {
		return groupSumHelper(start, nums, 0, target);
	}
	
	public boolean groupSumHelper(int startIndex, int[] nums, int sumSoFar, int target) {
		
		if (startIndex >= nums.length) { // at the end of the array
			return sumSoFar == target;
		}
		else {
			if (sumSoFar == target) { // Base Case 1
				return true;
			}
			else if (sumSoFar > target) { // Base Case 2
				return false;
			}
			else {
				return 
					groupSumHelper(startIndex + 1, nums, sumSoFar + nums[startIndex], target)
					|| 
					groupSumHelper(startIndex + 1, nums, sumSoFar, target);
			}			
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
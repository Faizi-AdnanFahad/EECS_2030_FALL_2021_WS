
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

	boolean isPalindrome(String word) { 
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
			return true;
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
}
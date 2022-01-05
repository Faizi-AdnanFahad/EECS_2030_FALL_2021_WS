package model;

import java.util.ArrayList;

public class Solutions {

	/*
	 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
	 * You can return the answer in any order.
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		int[] input = nums;
		for (int i = 0; i < nums.length - 1; i ++) {
			for (int m = nums.length - 1; m > i; m --) {
				if (input[i] + input[m] == target) {
					result[0] = i;
					result[1] = m;
				}
			}
		}
		return result;
	}


	/*
	 * Given an integer x, return true if x is palindrome integer.
	 * An integer is a palindrome when it reads the same backward as forward.
	 * For example, 121 is a palindrome while 123 is not.
	 */
	/* With Numbers */
	public static boolean isPalindrome(int x) {

		if (x < 0) {
			return false;
		}

		ArrayList<Integer> arrayOfDigits = new ArrayList<Integer>();
		boolean palindrom = true;
		int digit = 0;

		while (x > 0) {
			digit = x % 10;
			x = x / 10;
			arrayOfDigits.add(digit);
		}

		for (int i = 0; i < arrayOfDigits.size(); i ++) {
			int valueAtFirstIndex = arrayOfDigits.get(i) ;
			int valueAtLastIndex = arrayOfDigits.get(arrayOfDigits.size() - (i + 1));
			palindrom = valueAtFirstIndex == valueAtLastIndex;
			if (!palindrom) {
				break;
			}
		}

		return palindrom;
	}

	public static boolean palindromInt2nd(int x) {
		boolean result = true;
		int originalNum = x;
		int remainder = 0;
		int reversedNum = 0;

		while (x != 0) {
			remainder = x % 10;
			reversedNum = reversedNum * 10 + remainder;
			x /= 10;
		}

		if (originalNum != reversedNum) {
			result = false;
		}
		return result;
	}


	/* Palindrom on Strings */
	public static boolean isPalindromString(String input) {
		boolean palindrom = true;

		for (int i = 0; i < input.length(); i ++) {
			int valueAtFirstIndex = input.charAt(i);
			int valueAtLastIndex = input.charAt(input.length() - (i + 1));
			palindrom = valueAtFirstIndex == valueAtLastIndex;
			if (!palindrom) {
				break;
			}
		}

		return palindrom;
	}

	/*
	 * Given a roman numeral, convert it to an integer.
	 */
	public static int romanToInt(String s) {

		int partSum = 0;
		String IV = "IV";
		String IX = "IX";
		String XL = "XL";
		String XC = "XC";
		String CD = "CD";
		String CM = "CM";

		while (true) {
			int indexFound = -1;
			if (s.contains(IV)) {
				indexFound = s.indexOf(IV);
				partSum += 5 - 1;
				s = s.substring(0, indexFound) + s.substring(indexFound + 2, s.length());
			}
			else  if (s.contains(IX)) {
				indexFound = s.indexOf(IX);
				partSum += 10 - 1;
				s = s.substring(0, indexFound) + s.substring(indexFound + 2, s.length());

			}
			else  if (s.contains(XL)) {
				indexFound = s.indexOf(XL);
				partSum += 50 - 10;
				s = s.substring(0, indexFound) + s.substring(indexFound + 2, s.length());

			}
			else  if (s.contains(XC)) {
				indexFound = s.indexOf(XC);
				partSum += 100 - 10;
				s = s.substring(0, indexFound) + s.substring(indexFound + 2, s.length());

			}
			else  if (s.contains(CD)) {
				indexFound = s.indexOf(CD);
				partSum += 500 - 100;
				s = s.substring(0, indexFound) + s.substring(indexFound + 2, s.length());

			}
			else  if (s.contains(CM)) {
				indexFound = s.indexOf(CM);
				partSum += 1000 - 100;
				s = s.substring(0, indexFound) + s.substring(indexFound + 2, s.length());
			}
			else {
				for (int i = 0; i < s.length(); i ++) {
					if (s.charAt(i) == 'I') {
						partSum += 1;
					}
					else if (s.charAt(i) == 'V') {
						partSum += 5;
					}
					else if (s.charAt(i) == 'X') {
						partSum += 10;
					}
					else if (s.charAt(i) == 'L') {
						partSum += 50;
					}
					else if (s.charAt(i) == 'C') {
						partSum += 100;
					}
					else if (s.charAt(i) == 'D') {
						partSum += 500;
					}
					else if (s.charAt(i) == 'M') {
						partSum += 1000;
					}
				}
				break;
			}
		}

		return partSum;
	}

	/*
	 * Write a function to find the longest common prefix string 
	 * amongst an array of strings.
	 * If there is no common prefix, return an empty string "".
	 */
	public static String longestCommonPrefix(String[] strs) {
		int shortestStirng = strs[0].length();
		int indexOfShotestChar = 0;
		for (int i = 1; i < strs.length; i ++) {
			if (strs[i].length() < shortestStirng) {
				shortestStirng = strs[i].length();
				indexOfShotestChar = i;
			}
		}

		String longestPrefixSorFar = "";
		boolean sameSofar = true;
		char charAtRow = 0;
		for (int charInString = 0; charInString < shortestStirng; charInString ++) {
			charAtRow = strs[indexOfShotestChar].charAt(charInString);
			for (int wordInArray = 0; sameSofar && wordInArray < strs.length; wordInArray ++) {
				sameSofar = strs[wordInArray].charAt(charInString) == charAtRow;
			}
			if (sameSofar) {
				longestPrefixSorFar += charAtRow;
			}
			else if (!sameSofar && charInString == 0) {
				break;
			}
		}
		return longestPrefixSorFar;
	}

	public static String longestCommonPrefix_2(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}	    
		return prefix;
	}

	/*
	 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
	 * An input string is valid if:
	 * 	1. Open brackets must be closed by the same type of brackets.
	 * 	2. Open brackets must be closed in the correct order.
	 */
	public static boolean isValid(String s) {
		boolean valid = false;		
		int counter = 0;

		for (int i = 0; i < s.length() - 1; i ++) {
			char chartAtHand = s.charAt(i);
			for (int m = 1; !valid && m < s.length(); m ++) {
				if (chartAtHand == '(') {
					valid = s.charAt(m) == ')';
					if (valid) {
						counter ++;
					}
				}
				else if (chartAtHand == '[') {
					valid = s.charAt(m) == ']';
					if (valid) {
						counter ++;
					}				}
				else if (chartAtHand == '{') {
					valid = s.charAt(m) == '}';
					if (valid) {
						counter ++;
					}				}
			}

			if (i < s.length() - 1 && valid == true) {
				valid = false;
			}
		}

		if (counter == s.length() / 2) { // Checks to see if all brackets have a pair which at maximum should be half of the total string 's' passed
			return true;
		}
		else {
			return false;
		}
	}


	/*
	 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
	 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
	 * Return k after placing the final result in the first k slots of nums.
	 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
	 * 
	 * Custom Judge:
	 * The judge will test your solution with the following code:
	 * int[] nums = [...]; // Input array
	 * int[] expectedNums = [...]; // The expected answer with correct length
	 * int k = removeDuplicates(nums); // Calls your implementation
	 * assert k == expectedNums.length;
		for (int i = 0; i < k; i++) {
		    assert nums[i] == expectedNums[i];
		}
		If all assertions pass, then your solution will be accepted.
	 */
	public static int removeDuplicates(int[] nums) {

		for (int i = 0; i < nums.length - 1; i ++) {
			int currentNum = nums[i];
			for (int m = i + 1; m < nums.length && nums[m] != 1000000;) {
				if (nums[m] == currentNum) {
					nums[m] = -1000000;
				}
				m ++;
			}
		}

		int counter = 0;
		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] != -1000000) {
				nums[counter] = nums[i];
				counter ++;
			}
		}
		return counter;
	}

	/*
	 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The relative order of the elements may be changed.
	Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
	Return k after placing the final result in the first k slots of nums.
	Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
	
	Custom Judge:
	The judge will test your solution with the following code:
	int[] nums = [...]; // Input array
	int val = ...; // Value to remove
	int[] expectedNums = [...]; // The expected answer with correct length.
	                            // It is sorted with no values equaling val.
	int k = removeElement(nums, val); // Calls your implementation
	assert k == expectedNums.length;
	sort(nums, 0, k); // Sort the first k elements of nums
	for (int i = 0; i < actualLength; i++) {
	    assert nums[i] == expectedNums[i];
	}
	If all assertions pass, then your solution will be accepted.
	 */
	public static int removeElement(int[] nums, int val) {		
		int counter = 0;

		if (nums.length != 0 && nums[nums.length - 1] == val) {
			nums[nums.length - 1] = -100000;
			counter ++;
		}
		

		for (int i = 0; i < nums.length; i ++) {
			if (nums[i] == val) {
				counter ++;
				for (int m = i; m < nums.length - 1; m ++) {
					nums[m] = nums[m + 1];
				}
				i --;
			}
		}
		
		return nums.length - counter;
	}



}



























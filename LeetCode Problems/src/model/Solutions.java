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
		//		boolean matched = false;
		//		
		//		for (int i = 0; i < s.length() - 1; i ++) {
		//			if (s.charAt(i) == '(') {
		//				matched = s.charAt(i + 1) == ')';
		//			}
		//			else if (s.charAt(i) == '[') {
		//				matched = s.charAt(i + 1) == ']';
		//			}
		//			else if (s.charAt(i) == '{') {
		//				matched = s.charAt(i + 1) == '}';
		//			}
		//			if (!matched) {
		//				break;
		//			}
		//		}
		//		return matched;

//		String seq = s;
//
//		while (!seq.isEmpty()) {
//			if (seq.length() == 2) {
//				if (seq.charAt(0) == '(' && seq.charAt(1) == ')') {
//					return true;
//				}
//				else if (seq.charAt(0) == '[' && seq.charAt(1) == ']') {
//					return true;
//				}
//				else if (seq.charAt(0) == '{' && seq.charAt(1) == '}') {
//					return true;
//				}
//				else {
//					return false;
//				}
//			}
//			else {
//				int startingIndex = (seq.length() / 2) - 1;
//				if (seq.charAt(startingIndex) == '(' && seq.charAt(startingIndex + 1) == ')'){
//					seq = seq.substring(0, startingIndex) + seq.substring(startingIndex + 2, s.length());
//				}
//				else if (seq.charAt(startingIndex) == '[' && seq.charAt(startingIndex + 1) == ']'){
//					seq = seq.substring(0, startingIndex) + seq.substring(startingIndex + 2, s.length());
//				}
//				else if (seq.charAt(startingIndex) == '{' && seq.charAt(startingIndex + 1) == '}'){
//					seq = seq.substring(0, startingIndex) + seq.substring(startingIndex + 2, s.length());
//				}
//				else {
//					return false;
//				}
//			}
//			
//		}
//		return true;
		
		String seq = s;
		while (!seq.isEmpty()) {
			char firstChar = seq.charAt(0);
			for (int i = 1; i < seq.length(); i ++) {
				if (firstChar == '(' && seq.charAt(i) == ')') {
					seq = seq.substring(1, i - 1) + seq.substring(i + 1)
				}
			}
		}
		
	}

}



























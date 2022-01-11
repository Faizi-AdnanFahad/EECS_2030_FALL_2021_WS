package model;

import java.rmi.server.RemoteServer;
import java.security.DrbgParameters.Reseed;
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

		//		for (int i = 0; i < nums.length - 1; i ++) {
		//			int currentNum = nums[i];
		//			for (int m = i + 1; m < nums.length && nums[m] != 1000000;) {
		//				if (nums[m] == currentNum) {
		//					nums[m] = -1000000;
		//				}
		//				m ++;
		//			}
		//		}
		//
		//		int counter = 0;
		//		for (int i = 0; i < nums.length; i ++) {
		//			if (nums[i] != -1000000) {
		//				nums[counter] = nums[i];
		//				counter ++;
		//			}
		//		}

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


	/*
	 * mplement strStr().
	Return the index of the first occurrence of needle in haystack, 
	or -1 if needle is not part of haystack.

	Clarification:
	What should we return when needle is an empty string? This is a great question to ask during an interview.
	For the purpose of this problem, we will return 0 when needle is an empty string. 
	This is consistent to C's strstr() and Java's indexOf().
	 */

	public static int strStr(String haystack, String needle) {
		int index = -1;

		if (needle.isEmpty()) {
			index = 0;
		}
		else {
			for (int i = 0; i < haystack.length() - (needle.length() - 1); i ++) {
				String currentSubstring = haystack.substring(i, i + needle.length());
				if (currentSubstring.equals(needle)) {
					index = i;
					break;
				}
			}
		}
		return index;
	}


	/*
	 * Given an integer array nums, find the contiguous subarray 
	 * (containing at least one number) which has the largest sum and 
	 * return its sum.
	 * A subarray is a contiguous part of an array.
	 */

	//	public static int maxSubArray(int[] nums) {
	//		
	//		int total = 0;
	//		
	//		int startingIndex = 0;
	//		int finalIndex = nums.length; // 4
	//
	//		int max = nums[0];
	//		
	//		for (int i = 0; i < nums.length; i ++) {
	//			for (; startingIndex < finalIndex; startingIndex ++) {
	//				total += nums[startingIndex];
	//			}
	//			if (total > max) {
	//				max = total;
	//			}
	//			
	//			if (startingIndex == finalIndex) {
	//				finalIndex --;
	//				startingIndex = i;
	//				total = 0;
	//			}
	//			
	//			if (finalIndex == 0) {
	//				finalIndex = nums.length;
	//			}
	//			
	//		}
	//		return max;
	//	}

	/*
	 * Given a string s consisting of some words separated by some number of spaces, 
	 * return the length of the last word in the string.
	 * A word is a maximal substring consisting of non-space characters only.
	 */
	public static int lengthOfLastWord(String s) {
		int result = -1;
		String trimedS = s.trim();


		for (int i = 0; i < trimedS.length(); i ++) {
			int indexBackWard = trimedS.length() - i - 1;
			if (trimedS.charAt(indexBackWard) == ' ') {
				result = trimedS.length() - (indexBackWard + 1);
				break;
			}
		}

		if (result == -1) {
			result = trimedS.length();
		}
		return result;
	}


	/*
	 * You are given a large integer represented as an integer array digits, 
	 * where each digits[i] is the ith digit of the integer. 
	 * The digits are ordered from most significant to least significant 
	 * in left-to-right order. The large integer does not contain any leading 0's.
	 * Increment the large integer by one and return the resulting array of digits.
	 */
	public static int[] plusOne(int[] digits) {

		int lastIndex = digits.length - 1;

		boolean allDigits9 = true;

		for (int i = 0; allDigits9 && i < digits.length; i ++) {
			allDigits9 = allDigits9 && digits[i] == 9;
		}

		if (digits[lastIndex] != 9) {
			digits[lastIndex] ++;
			return digits;
		}
		else {
			if (!allDigits9) {
				for (int i = 0; i < digits.length; i ++) {
					if (digits[lastIndex - i] == 9) {
						digits[lastIndex - i] = 0;
					}
					else {
						digits[lastIndex - i] ++;
						break;
					}
				}
				return digits;
			}
			else {
				int[] result = new int[digits.length + 1];
				result[0] = 1;
				for (int i = 1; i < result.length; i++) {
					result[i] = 0;
				}
				return result;
			}	
		}

		/*
		 * Solution #2
		 */
		//		String digitsInString = "";
		//		
		//		for (int i = 0; i < digits.length; i ++) {
		//			digitsInString += digits[i];
		//		}
		//		
		//		long digitsInInteger = Long.valueOf(digitsInString);
		//		digitsInInteger ++;
		//		
		//		String digitsInString2 = String.valueOf(digitsInInteger);
		//		
		//		int[] result = new int[digitsInString2.length()];
		//		for (int i = 0; i < digitsInString2.length(); i ++) {
		//			result[i] = Character.getNumericValue(digitsInString2.charAt(i));
		//		}
		//		
		//		
		//		return result;
	}


	/*
	 * Given two binary strings a and b, return their sum as a binary string.
	 */
	//		public static String addBinary(String a, String b) {
	//	
	//			String reversedOutput = "";
	//	
	//			if (a.length() > b.length()) {
	//				String newB = "";
	//				int extra0toAdd = a.length() - b.length();
	//				for (int i = 0; i < extra0toAdd; i ++) {
	//					newB += "0";
	//				}
	//				newB += b;
	//				b = newB;
	//			}
	//			else if (b.length() > a.length()) {
	//				String newA = "";
	//				int extra0toAdd = b.length() - a.length();
	//				for (int i = 0; i < extra0toAdd; i ++) {
	//					newA += "0";
	//				}
	//				newA += a;
	//				a = newA;
	//			}
	//	
	//	
	//			String addToNext = "";
	//	
	//			for (int i = 0; i < a.length(); i ++) {
	//				if (addToNext.isEmpty()) {
	//					if ((a.charAt(a.length() - i - 1) == '1' && b.charAt(b.length() - i - 1) == '0')
	//							||  (b.charAt(a.length() - i - 1) == '1' && a.charAt(b.length() - i - 1) == '0')){
	//						reversedOutput += "1";
	//					}
	//					else if ((a.charAt(a.length() - i - 1) == '0' && b.charAt(b.length() - i - 1) == '0')
	//							||  (b.charAt(a.length() - i - 1) == '0' && a.charAt(b.length() - i - 1) == '0')){
	//						reversedOutput += "0";
	//					}
	//					else { // "1" + "1" = "10"
	//						reversedOutput += "0";
	//						addToNext = "1";
	//					}
	//				}
	//				else {
	//					addToNext = "";
	//					if ((a.charAt(a.length() - i - 1) == '0' && b.charAt(b.length() - i - 1) == '0')
	//							||  (b.charAt(a.length() - i - 1) == '0' && a.charAt(b.length() - i - 1) == '0')){
	//						reversedOutput += "1";
	//					}
	//					else if ((a.charAt(a.length() - i - 1) == '1' && b.charAt(b.length() - i - 1) == '0')
	//							||  (b.charAt(a.length() - i - 1) == '1' && a.charAt(b.length() - i - 1) == '0')){
	//						reversedOutput += "0";
	//						addToNext = "1";
	//					}
	//					else { // 1 + 1
	//						reversedOutput += "1";
	//						addToNext = "1";
	//					}
	//				}
	//				if (i == a.length() - 1 && !addToNext.isEmpty()) {
	//					reversedOutput += "1";
	//				}
	//			}
	//	
	//			String output = "";
	//			for (int i = 0; i < reversedOutput.length(); i ++) {
	//				output += reversedOutput.charAt(reversedOutput.length() - i - 1);
	//			}
	//	
	//			return output;
	//		}

	//	/*
	//	 * Using Recursion - incompelete
	//	 */
	//	public static String addBinary(String a, String b) {
	//
	//		String result = "";
	//		result = result 
	//				+ addBinaryHelper(a, b, 0, a.length(), "");
	//
	//		return result;
	//	}
	//
	//	private static String addBinaryHelper(String a, String b, int from, int to, String extra) {
	//		String reversedOutput = "";
	//
	//		String newA = a.substring(from, to);
	//		String newB = b.substring(from, to);
	//
	//		if (extra.isEmpty()) {
	//			if (newA.equals("0") && newB.equals("0") || newB.equals("0") && newA.equals("0")) {
	//				reversedOutput += "0";
	//			}
	//			else if (newA.equals("1") && newB.equals("0") || newB.equals("1") && newA.equals("0")) {
	//				reversedOutput += "1";
	//			}
	//			else if (newA.equals("1") && newB.equals("1")) {
	//				reversedOutput += "0";
	//				extra += "1";
	//			}
	//			else {
	//				reversedOutput += 
	//						addBinaryHelper(newA, newB, 0, 1, extra) 
	//						+  addBinaryHelper(a, b, from + 1, a.length(), extra);
	//			}
	//		}
	//		else {
	//			if (newA.equals("0") && newB.equals("0") || newB.equals("0") && newA.equals("0")) {
	//				reversedOutput += "0";
	//			}
	//			else if (newA.equals("1") && newB.equals("0") || newB.equals("1") && newA.equals("0")) {
	//				reversedOutput += "1";
	//			}
	//			else if (newA.equals("1") && newB.equals("1")) {
	//				reversedOutput += "0";
	//				extra += "1";
	//			}
	//			else {
	//				reversedOutput += addBinary3(newA, newB);
	//			}
	//		}
	//		return reversedOutput;
	//	}
	//
	//	private static String addBinary3(String a, String b) {
	//		String result = "";
	//
	//		if (a.equals("0") && b.equals("0") || b.equals("0") && a.equals("0")) {
	//			result += "1";
	//		}
	//		else if (a.equals("1") && b.equals("0") || b.equals("0") && a.equals("1")) {
	//			result += "0";
	//		}
	//		else if (a.equals("1") && b.equals("1")) {
	//			result += "1";
	//		}
	//
	//		return result;
	//	}

	// Second version
	public static String addBinary(String a, String b) {

		if (a.equals("0") && b.equals("0") || b.equals("0") && a.equals("0")) {
			return "0";
		}
		else if (a.equals("1") && b.equals("0") || b.equals("1") && a.equals("0")) {
			return "1";
		}
		else if (a.equals("1") && b.equals("1")) {
			return "10";
		}	
		else {
			int firstBinaryNum = changeToBinary(a);
			int secondBinNum = changeToBinary(b);

			String result = changeToINT(firstBinaryNum + secondBinNum);

			return result;
		}

	}

	public static int changeToBinary(String a) {
		int result = 0;

		for (int i = 0; i < a.length(); i ++) {
			int digitINInt = Character.getNumericValue(a.charAt(a.length() - i - 1));
			result += Math.pow(2, i) * digitINInt;
		}

		return result;
	}

	public static String changeToINT(int a) {

		String result = "";
		while (a != 1) {
			result += a % 2;
			a = a / 2;
			if (a == 1) {
				result += 1;
			}
		}

		String output = "";
		for (int i = 0; i < result.length(); i ++) {
			output += result.charAt(result.length() - i - 1);
		}

		return output;
	}


	/*
	 * Given a non-negative integer x, compute and return the square root of x.
	 * Since the return type is an integer, the decimal digits are truncated, 
	 * and only the integer part of the result is returned.
	 * Note: You are not allowed to use any built-in exponent function or operator, 
	 * such as pow(x, 0.5) or x ** 0.5.
	 */
//	public static int mySqrt(int x) {
//		int result = 0;
//
//		if (x == 0) {
//			return 0;
//		}
//		
//		ArrayList<Integer> oddNums = new ArrayList<>();
//		
//		int counter = 0;
//		for (int i = 1; i < x + 1; i ++) {
//			counter ++;
//			
//			if (!isInList(oddNums, counter) && counter % 2 == 1) {
//				result ++;
//				oddNums.add(counter);
//				counter = 0;
//			}
//		}
//
//		return result;
//	}
//	
//	public static boolean isInList(ArrayList<Integer> list, int counter) {
//		boolean result = false;
//		for (int i = 0; i < list.size(); i ++) {
//			if (list.get(i) == counter) {
//				result = true;
//				break;
//			}
//		}
//		
//		return result;
//	}
	
	public static int mySqrt(int x) {
		
		int result = 0;
		for (int i = 1; i < x + 1; i += 2) {
			result ++;
		}
		return result;
	}
}





























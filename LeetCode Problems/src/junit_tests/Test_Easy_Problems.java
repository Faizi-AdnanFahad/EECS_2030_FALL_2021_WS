package junit_tests;

import static org.junit.Assert.*;

import org.junit.Assert;

import model.*;

import org.junit.Test;

public class Test_Easy_Problems {
	
	/*
	 * Tests related to 'twoSum'
	 */
	@Test
	public void test_twoSum_0() {
	int[] input = {2,7,11,15};
	int[] output = {0, 1};
	int target = 9;
	int[] expected = Solutions.twoSum(input, target);
	Assert.assertArrayEquals(output, expected);
	}
	
	@Test
	public void test_twoSum_1() {
	int[] input = {2,7,11,15};
	int[] output = {0, 3};
	int target = 17;
	int[] expected = Solutions.twoSum(input, target);
	Assert.assertArrayEquals(output, expected);
	}
	
	@Test
	public void test_twoSum_2() {
	int[] input = {2,7,11,15};
	int[] output = {1, 3};
	int target = 22;
	int[] expected = Solutions.twoSum(input, target);
	Assert.assertArrayEquals(output, expected);
	}
	
	
	
	/*
	 * Tests related to 'palindrom' numbers
	 */
	@Test
	public void palindrom_1() {
	int input = 121;
	boolean expected = Solutions.palindromInt2nd(input);
	assertTrue(expected);
	}
	
	@Test
	public void palindrom_2() {
	int input = 1242;
	boolean expected = Solutions.isPalindrome(input);
	assertFalse(expected);
	}
	
	@Test
	public void palindrom_3() {
	int input = 11;
	boolean expected = Solutions.isPalindrome(input);
	assertTrue(expected);
	}
	
	@Test
	public void palindrom_4() {
	int input = 12;
	boolean expected = Solutions.isPalindrome(input);
	assertFalse(expected);
	}
	
	@Test
	public void palindrom_5() {
	int input = 1;
	boolean expected = Solutions.isPalindrome(input);
	assertTrue(expected);
	}
	
	@Test
	public void palindrom_6() {
	int input = -121;
	boolean expected = Solutions.isPalindrome(input);
	assertFalse(expected);
	}
	

	
	/*
	 * Tests related to 'palindrom' numbers
	 */
	@Test
	public void palindrom_1_str() {
	String input = "aba";
	boolean expected = Solutions.isPalindromString(input);
	assertTrue(expected);
	}
	
	@Test
	public void palindrom_2_str() {
	String input = "abac";
	boolean expected = Solutions.isPalindromString(input);
	assertFalse(expected);
	}
	
	@Test
	public void palindrom_3_str() {
	String input = "";
	boolean expected = Solutions.isPalindromString(input);
	assertTrue(expected);
	}
	
	@Test
	public void palindrom_4_str() {
	String input = "a";
	boolean expected = Solutions.isPalindromString(input);
	assertTrue(expected);
	}
	
	
	/*
	 * Tests related to 'palindrom' numbers
	 */
	@Test
	public void romanToInt_1() {
	String input = "III";
	int calculation = Solutions.romanToInt(input);
	assertEquals(3, calculation);
	}
	
	@Test
	public void romanToInt_2() {
	String input = "LVIII";
	int calculation = Solutions.romanToInt(input);
	assertEquals(58, calculation);
	}
	
	@Test
	public void romanToInt_3() {
	String input = "MCMXCIV";
	int calculation = Solutions.romanToInt(input);
	assertEquals(1994, calculation);
	}
	
	
	/*
	 * Tests related to 'longestCommonPrefix'
	 */
	@Test
	public void longestCommonPrefix_1() {
	String[] input = {"flower","flow","flight"};
	String calculation = Solutions.longestCommonPrefix_2(input);
	assertEquals("fl", calculation);
	}
	
	@Test
	public void longestCommonPrefix_2() {
	String[] input = {"dog","racecar","car"};
	String calculation = Solutions.longestCommonPrefix(input);
	assertEquals("", calculation);
	}
	
	@Test
	public void longestCommonPrefix_3() {
	String[] input = {"reflower","flow","flight"};
	String calculation = Solutions.longestCommonPrefix(input);
	assertEquals("", calculation);
	}
	
	/*
	 * Tests related to 'isValid - paranthesis'
	 */
//	@Test
//	public void isValid_1() {
//	String input = "()";
//	boolean calculation = Solutions.isValid(input);
//	assertEquals(true, calculation);
//	}
//	
//	@Test
//	public void isValid_2() {
//	String input = "(]";
//	boolean calculation = Solutions.isValid(input);
//	assertEquals(false, calculation);
//	}
//	
//	@Test
//	public void isValid_3() {
//	String input = "()[]{}";
//	boolean calculation = Solutions.isValid(input);
//	assertEquals(true, calculation);
//	}
//	
//	@Test
//	public void isValid_4() {
//	String input = "(](]{}";
//	boolean calculation = Solutions.isValid(input);
//	assertEquals(false, calculation);
//	}
//	
//	@Test
//	public void isValid_5() {
//	String input = "(](]{}";
//	boolean calculation = Solutions.isValid(input);
//	assertEquals(false, calculation);
//	}
//	
//	@Test
//	public void isValid_6() {
//	String input = "{[]}";
//	boolean calculation = Solutions.isValid(input);
//	assertEquals(true, calculation);
//	}
//	
//	@Test
//	public void isValid_7() {
//	String input = "([)]";
//	boolean calculation = Solutions.isValid(input);
//	assertEquals(false, calculation);
//	}
	
	
	/*
	 * Test related to 'removeDuplicates'
	 */
	@Test
	public void removeDuplicates_1() {
	int[] input = {1, 1, 2};
	int calculation = Solutions.removeDuplicates(input);
	assertEquals(2, calculation);
	}
	
	@Test
	public void removeDuplicates_2() {
	int[] input = {0,0,1,1,1,2,2,3,3,4};
	int calculation = Solutions.removeDuplicates(input);
	assertEquals(5, calculation);
	}
	
	@Test
	public void removeDuplicates_3() {
	int[] input = {0, 1, 2, 2, 3, 4};
	int calculation = Solutions.removeDuplicates(input);
	assertEquals(5, calculation);
	}
	
	
	/*
	 * Test related to 'removeElement'
	 */
	@Test
	public void removeElement_1() {
	int[] input = {3,2,2,3};
	int calculation = Solutions.removeElement(input, 3);
	assertEquals(2, calculation);
	}
	
	@Test
	public void removeElement_2() {
	int[] input = {0,1,2,2,3,0,4,2};
	int calculation = Solutions.removeElement(input, 2);
	assertEquals(5, calculation);
	}
	
	@Test
	public void removeElement_3() {
	int[] input = {4, 5};
	int calculation = Solutions.removeElement(input, 4);
	assertEquals(1, calculation);
	}
	
	
	/*
	 * Test related to 'strStr'
	 */
	@Test
	public void strStr_1() {
	String needle = "";
	String haystack = "";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(0, calculation);
	}
	
	@Test
	public void strStr_2() {
	String needle = "ll";
	String haystack = "hello";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(2, calculation);
	}
	
	@Test
	public void strStr_3() {
	String needle = "bba";
	String haystack = "aaaaaaaaa";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(-1, calculation);
	}
	
	@Test
	public void strStr_4() {
	String needle = "";
	String haystack = "aaaaaaaaa";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(0, calculation);
	}
	
	@Test
	public void strStr_5() {
	String needle = "asdf";
	String haystack = "";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(-1, calculation);
	}
	
	@Test
	public void strStr_6() {
	String needle = "asdf";
	String haystack = "asdfwer";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(0, calculation);
	}
	
	@Test
	public void strStr_7() {
	String needle = "f";
	String haystack = "asdfwf";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(3, calculation);
	}
	
	@Test
	public void strStr_8() {
	String needle = "wf";
	String haystack = "asdfwf";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(4, calculation);
	}
	
	@Test
	public void strStr_9() {
	String needle = "issip";
	String haystack = "mississippi";
	int calculation = Solutions.strStr(haystack, needle);
	assertEquals(4, calculation);
	}

	
	
	/*
	 * Test related to 'maxSubArray'
	 */
//	@Test
//	public void maxSubArray_1() {
//	int[] input = {-2,1,-3,4,-1,2,1,-5,4};
//	int calculation = Solutions.maxSubArray(input);
//	assertEquals(6, calculation);
//	}
//	
//	@Test
//	public void maxSubArray_2() {
//	int[] input = {1};
//	int calculation = Solutions.maxSubArray(input);
//	assertEquals(1, calculation);
//	}
//	
//	@Test
//	public void maxSubArray_3() {
//	int[] input = {5,4,-1,7,8};
//	int calculation = Solutions.maxSubArray(input);
//	assertEquals(23, calculation);
//	}
	
//	@Test
//	public void maxSubArray_4() {
//	int[] input = {6, -1, 3, 2};
//	int calculation = Solutions.maxSubArray(input);
//	assertEquals(10, calculation);
//	}

	
	/*
	 * Test related to 'lengthOfLastWord'
	 */
	@Test
	public void lengthOfLastWord_1() {
	String input = "Hello World";
	int calculation = Solutions.lengthOfLastWord(input);
	assertEquals(5, calculation);
	}
	
	@Test
	public void lengthOfLastWord_2() {
	String input = "   fly me   to   the moon  ";
	int calculation = Solutions.lengthOfLastWord(input);
	assertEquals(4, calculation);
	}

	@Test
	public void lengthOfLastWord_3() {
	String input = 	"luffy is still joyboy";
	int calculation = Solutions.lengthOfLastWord(input);
	assertEquals(6, calculation);
	}
	
	@Test
	public void lengthOfLastWord_4() {
	String input = 	"";
	int calculation = Solutions.lengthOfLastWord(input);
	assertEquals(0, calculation);
	}
	
	@Test
	public void lengthOfLastWord_5() {
	String input = 	" ";
	int calculation = Solutions.lengthOfLastWord(input);
	assertEquals(0, calculation);
	}

	@Test
	public void lengthOfLastWord_6() {
	String input = 	"m";
	int calculation = Solutions.lengthOfLastWord(input);
	assertEquals(1, calculation);
	}

	
	/*
	 * Test related to 'plusOne'
	 */
	@Test
	public void plusOne_1() {
	int[] input = {1, 2, 3};
	int[] calculation = Solutions.plusOne(input);
	int[] output = {1, 2, 4};
	Assert.assertArrayEquals(output, calculation);
	}

	@Test
	public void plusOne_2() {
	int[] input = {1, 2, 3};
	int[] calculation = Solutions.plusOne(input);
	int[] output = {1, 2, 4};
	Assert.assertArrayEquals(output, calculation);
	}

	@Test
	public void plusOne_3() {
	int[] input = {4,3,2,1};
	int[] calculation = Solutions.plusOne(input);
	int[] output = {4,3,2,2};
	Assert.assertArrayEquals(output, calculation);
	}

	@Test
	public void plusOne_4() {
	int[] input = {9};
	int[] calculation = Solutions.plusOne(input);
	int[] output = {1, 0};
	Assert.assertArrayEquals(output, calculation);
	}
	
	@Test
	public void plusOne_6() {
	int[] input = {1, 2, 0, 5, 6, 8, 1, 3, 5, 6};
	int[] calculation = Solutions.plusOne(input);
	int[] output = {1, 2, 0, 5, 6, 8, 1, 3, 5, 7};
	Assert.assertArrayEquals(output, calculation);
	}
	
	@Test
	public void plusOne_5() {
	int[] input = {9,8,7,6,5,4,3,2,1,0};
	int[] calculation = Solutions.plusOne(input);
	int[] output = {9,8,7,6,5,4,3,2,1,1};
	Assert.assertArrayEquals(output, calculation);
	}
	
	@Test
	public void plusOne_7() {
	int[] input = {9, 9, 9, 9, 9};
	int[] calculation = Solutions.plusOne(input);
	int[] output = {1, 0, 0, 0, 0, 0};
	Assert.assertArrayEquals(output, calculation);
	}
	
	@Test
	public void plusOne_8() {
	int[] input = {9, 8, 9};
	int[] calculation = Solutions.plusOne(input);
	int[] output = {9, 9, 0};
	Assert.assertArrayEquals(output, calculation);
	}

	
	/*
	 * Test related to 'addBinary'
	 */
	@Test
	public void addBinary_1() {
	String a = "11";
	String b = "1";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("100", calculation);
	}
	
	@Test
	public void addBinary_2() {
	String a = "1010";
	String b = "1011";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("10101", calculation);
	}
	
	@Test
	public void addBinary_3() {
	String a = "11";
	String b = "00";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("11", calculation);
	}
	
	@Test
	public void addBinary_4() {
	String a = "11";
	String b = "01";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("100", calculation);
	}
	
	@Test
	public void addBinary_5() {
	String a = "1111";
	String b = "0101";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("10100", calculation);
	}
	
	@Test
	public void addBinary_6() {
	String a = "1111";
	String b = "1";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("10000", calculation);
	}
	
	@Test
	public void addBinary_7() {
	String a = "01";
	String b = "1111";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("10000", calculation);
	}
	
	@Test
	public void addBinary_8() {
	String a = "100110";
	String b = "110101";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("1011011", calculation);
	}
	
	@Test
	public void addBinary_9() {
	String a = "10110";
	String b = "01111";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("100101", calculation);
	}
	
	@Test
	public void addBinary_10() {
	String a = "0";
	String b = "0";
	String calculation = Solutions.addBinary(a, b);
	assertEquals("0", calculation);
	}
	
	
	/*
	 * Tests related to 'mySqrt'
	 */
	@Test
	public void mysqrt_1() {
	int calculation = Solutions.mySqrt(4);
	assertEquals(2, calculation);
	}
	
	@Test
	public void mysqrt_2() {
	int calculation = Solutions.mySqrt(8);
	assertEquals(2, calculation);
	}
	
	@Test
	public void mysqrt_3() {
 	int calculation = Solutions.mySqrt(9);
	assertEquals(3, calculation);
	}
	
	@Test
	public void mysqrt_4() {
 	int calculation = Solutions.mySqrt(0);
	assertEquals(0, calculation);
	}
	
	@Test
	public void mysqrt_5() {
 	int calculation = Solutions.mySqrt(123);
	assertEquals(11, calculation);
	}
	
	@Test
	public void mysqrt_6() {
 	int calculation = Solutions.mySqrt(1);
	assertEquals(1, calculation);
	}
	
	@Test
	public void mysqrt_7() {
 	int calculation = Solutions.mySqrt(25);
	assertEquals(5, calculation);
	}
	
	@Test
	public void mysqrt_8() {
 	int calculation = Solutions.mySqrt(2147395599);
	assertEquals(46339, calculation);
	}
}
































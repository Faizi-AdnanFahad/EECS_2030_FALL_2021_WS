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
}
































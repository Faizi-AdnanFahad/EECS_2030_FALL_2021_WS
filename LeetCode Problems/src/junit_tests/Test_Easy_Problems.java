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

}

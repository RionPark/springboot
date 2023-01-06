package com.ezen.demo;

import java.util.Arrays;

public class SortTest {

	public static void main(String[] args) {
		int[] nums = {1,10,2,7,4};
		for(int i=0;i<nums.length;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					int tmpNum = nums[i];
					nums[i] = nums[j];
					nums[j] = tmpNum;
				}
			}
		}
		for(int i=0;i<nums.length;i++) {
			System.out.println(nums[i]);
		}
	}
}

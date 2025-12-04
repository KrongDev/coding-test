package com.codingTest.leetcode.med;

import java.util.Arrays;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int len = nums.length;
        int l = 0, r = len - 1;

        while(l <= r) {
            int mid = l + (r - l)/2;

            if(nums[mid] < target) {
                l = mid + 1;
                continue;
            }

            if(nums[mid] > target) {
                r = mid - 1;
                continue;
            }

            res[0] = mid;
            res[1] = mid;

            while(res[0] > -1 &&  nums[res[0]] == target) {
                res[0]--;
            }
            res[0]++;

            while(res[1] < len &&  nums[res[1]] == target) {
                res[1]++;
            }
            res[1]--;
            break;
        }
        return res;
    }

    public static void main(String[] args) {
        Find_First_and_Last_Position_of_Element_in_Sorted_Array res = new Find_First_and_Last_Position_of_Element_in_Sorted_Array();
        int[] nums = {1};
        int target = 1;
        System.out.println(Arrays.toString(res.searchRange(nums, target)));
    }
}

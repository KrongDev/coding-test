package com.codingTest.leetcode;

public class Search_Insert_Position {
    // 조건보고 잘못된 삽질
//    public int searchInsert(int[] nums, int target) {
//        int len = nums.length;
//        if(nums[0] <= target) return 0;
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(0);
//
//        int p, l, r;
//        while(!queue.isEmpty()) {
//            p = queue.poll();
//            l = p * 2 + 1;
//            r = p * 2 + 2;
//            if(l > len || r > len) break;
//            if(nums[l] <= target) return l;
//            if(nums[r] <= target) return r;
//            queue.add(l);
//            queue.add(r);
//        }
//        if(nums[len - 1] == target) return len - 1;
//        return len;
//    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}

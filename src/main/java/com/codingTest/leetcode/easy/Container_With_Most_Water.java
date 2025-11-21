package com.codingTest.leetcode.easy;

public class Container_With_Most_Water {
    private int[] height;
    private int getFace (int start, int end) {
        int x = end - start;
        int y = Math.min(height[start], height[end]);

        return x * y;
    }

    public int maxArea(int[] height) {
        this.height = height;

        int len = height.length;
        int res = 0, face, prev;
        int left = 0, right = len - 1;
        while(left < right) {
            face = getFace(left, right);
            res = Math.max(res, face);

            if(height[left] < height[right]) {
                prev = left++;
                while(height[prev] >= height[left] && left < right) {
                    left++;
                }
            } else {
                prev = right--;
                while(height[prev] >= height[right] && left < right) {
                    right--;
                }
            }
        }
        return res;
    }
}

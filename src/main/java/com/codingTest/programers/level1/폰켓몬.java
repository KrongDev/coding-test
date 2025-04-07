package com.codingTest.programers.level1;


public class 폰켓몬 {


    public int solution(int[] nums) {
        int n = 0;
        boolean[] arr = new boolean[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(!arr[nums[i]]){
                n++;
                arr[nums[i]] = true;
            }
        }
        return Math.min(n, nums.length/2);
    }


    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        폰켓몬 res = new 폰켓몬();
        System.out.println(res.solution(nums));
    }
}

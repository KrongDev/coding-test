class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int i = 1;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j - 1] != nums[j]) {
                nums[i++] = nums[j];
                continue;
            }

            nums[i] = nums[j];
            while(j + 1 < nums.length && nums[j+1] == nums[i]) {
                j++;
            }
            i++;
        }
        return i;
    }

    /**
     * 개선방향
     * 코드 복잡도가 훨씬 간소한거 같다.
     * public int removeDuplicates(int[] nums) {
     *         int k=2;
     *         for(int i=2;i<nums.length;i++){
     *             if(nums[i]!=nums[k-2]){
     *                 nums[k] = nums[i];
     *                 k++;
     *             }
     *         }
     *         return k;
     *     }
     */
}
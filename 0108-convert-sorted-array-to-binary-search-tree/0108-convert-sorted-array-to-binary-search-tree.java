/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return genBST(0, nums.length - 1, nums);
    }

    private TreeNode genBST(int start, int end, int[] nums) {
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);

        int mid = start +(end - start)/2;

        TreeNode res = new TreeNode(nums[mid]);
        res.left = genBST(start, mid - 1, nums);
        res.right = genBST(mid + 1, end, nums);

        return res;
    }


}
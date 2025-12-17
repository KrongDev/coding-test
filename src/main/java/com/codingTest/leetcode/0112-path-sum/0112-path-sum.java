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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return hasPathSum(root, 0, targetSum);
    }

    private boolean hasPathSum(TreeNode node, int total, int targetSum) {
        if(node.left == null && node.right == null) return total + node.val == targetSum;

        if(node.left != null && hasPathSum(node.left, total + node.val, targetSum)) {
            return true;
        }
        
        if(node.right != null && hasPathSum(node.right, total + node.val, targetSum)) {
            return true;
        }

        return false;
    }
}
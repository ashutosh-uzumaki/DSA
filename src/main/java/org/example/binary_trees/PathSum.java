package org.example.binary_trees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }

    public boolean helper(TreeNode root, int targetSum){
        if(root == null){
            return false;
        }
        targetSum -= root.val;
        if(root.left == null && root.right == null){
            if(targetSum == 0){
                return true;
            }
        }
        boolean left = helper(root.left, targetSum);
        boolean right = helper(root.right, targetSum);
        return left || right;
    }
}

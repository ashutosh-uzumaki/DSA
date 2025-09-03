package org.example.binary_trees;

public class BalancedBinaryHeight {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int[] maxHeightDiff = new int[1];
        maxHeightDiff[0] = Integer.MIN_VALUE;
        helper(root, maxHeightDiff);
        // System.out.println(maxHeightDiff[0]);
        return maxHeightDiff[0] <= 1;
    }

    private int helper(TreeNode root, int[] maxHeightDiff){
        if(root == null){
            return 0;
        }
        int leftHeight = helper(root.left, maxHeightDiff);
        int rightHeight = helper(root.right, maxHeightDiff);

        maxHeightDiff[0] = Math.max(maxHeightDiff[0], Math.abs(leftHeight - rightHeight));

        return Math.max(leftHeight, rightHeight) + 1;
    }
}

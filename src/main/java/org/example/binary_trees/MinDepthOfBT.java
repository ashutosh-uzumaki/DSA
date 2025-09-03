package org.example.binary_trees;

public class MinDepthOfBT {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }

        int leftHeight = minDepth(root.left);
        int rightHeight = minDepth(root.right);

        return Math.min(leftHeight, rightHeight) + 1;
    }
}

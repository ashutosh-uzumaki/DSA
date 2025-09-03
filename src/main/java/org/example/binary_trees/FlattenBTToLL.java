package org.example.binary_trees;

public class FlattenBTToLL {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode temp = root.right;
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        while(root.right != null){
            root = root.right;
        }
        root.right = temp;
        flatten(root.right);
    }
}

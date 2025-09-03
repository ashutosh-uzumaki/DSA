package org.example.binary_trees;

public class InorderTraversalBT {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        helper(root, inorder);
        return inorder;
    }

    public void helper(TreeNode root, List<Integer> inorder){
        if(root == null){
            return;
        }

        helper(root.left, inorder);
        inorder.add(root.val);
        helper(root.right, inorder);
    }
}

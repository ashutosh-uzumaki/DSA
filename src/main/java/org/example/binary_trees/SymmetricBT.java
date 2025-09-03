package org.example.binary_trees;

public class SymmetricBT {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        return p.val == q.val && isSymmetricHelper(p.left, q.right) && isSymmetricHelper(p.right, q.left);
    }
}

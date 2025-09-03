package org.example.binary_trees;

public class LevelOrderTraversalBT {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> order = new ArrayList<>();
        if(root == null){
            return order;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size() > 0){
            int size = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode front = q.remove();
                currLevel.add(front.val);
                if(front.left != null){
                    q.add(front.left);
                }
                if(front.right != null){
                    q.add(front.right);
                }
            }
            order.add(new ArrayList<>(currLevel));
        }

        return order;
    }
}

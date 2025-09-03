package org.example.binary_trees;

public class RootToLeafPaths {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findPaths(root, targetSum, new ArrayList<Integer>());
        return allPaths;
    }

    public void findPaths(TreeNode root, int targetSum, List<Integer> currPath){
        if(root == null){
            return;
        }

        targetSum -= root.val;
        currPath.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == 0){
                allPaths.add(new ArrayList<>(currPath));
            }
        }

        findPaths(root.left, targetSum, currPath);
        findPaths(root.right, targetSum, currPath);
        currPath.remove(currPath.size() - 1);

    }
}

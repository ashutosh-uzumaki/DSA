package org.example.binary_trees;

public class HouseRobber {
    class HousePair{
        int withRobbery = 0;
        int withoutRobbery = 0;
    }
    class Solution {
        public int rob(TreeNode root) {
            HousePair ans = robHelper(root);
            return Math.max(ans.withRobbery, ans.withoutRobbery);
        }

        private HousePair robHelper(TreeNode root){
            if(root == null){
                return new HousePair();
            }

            HousePair leftHouse = robHelper(root.left);
            HousePair rightHouse = robHelper(root.right);

            HousePair res = new HousePair();

            res.withoutRobbery = Math.max(leftHouse.withRobbery, leftHouse.withoutRobbery)
                    +
                    Math.max(rightHouse.withRobbery, rightHouse.withoutRobbery);

            res.withRobbery = leftHouse.withoutRobbery + root.val + rightHouse.withoutRobbery;

            return res;
        }
    }
}

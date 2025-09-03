package org.example.binary_trees;

public class CamerasNeededInBT {
    int camerasNeeded = 0;
    public int minCameraCover(TreeNode root){
        if(minCameraCoverHelper(root) == -1){
            camerasNeeded += 1;
        }
        return camerasNeeded;
    }
    public int minCameraCoverHelper(TreeNode root) {
        if(root == null){
            return 1;
        }

        int leftChildCameraState = minCameraCoverHelper(root.left);
        int rightChildCameraState = minCameraCoverHelper(root.right);

        if(leftChildCameraState == -1 || rightChildCameraState == -1){
            camerasNeeded += 1;
            return 0;
        }

        if(leftChildCameraState == 0 || rightChildCameraState == 0){
            return 1;
        }

        return -1;
    }
}

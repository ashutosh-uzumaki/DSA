package org.example.two_pointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxAmount = Integer.MIN_VALUE;
        int i = 0;
        int j = height.length - 1;
        while(i < j){
            if(height[i] < height[j]){
                maxAmount = Math.max(maxAmount, height[i] * (j - i));
                i++;
            }else{
                maxAmount = Math.max(maxAmount, height[j] * (j - i));
                j--;
            }
        }
        return maxAmount;
    }
}

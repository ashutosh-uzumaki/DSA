package org.example.two_pointers;

public class SortColors012 {
    public void sortColors(int[] nums) {
        int low=0, mid=0, high=nums.length-1;

        while(mid <= high){
            if(nums[mid] == 1){
                mid++;
            }else if(nums[mid] == 0){
                swap(nums, mid, low);
                mid++;
                low++;
            }else if(nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

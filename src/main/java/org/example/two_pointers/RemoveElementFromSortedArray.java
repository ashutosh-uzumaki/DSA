package org.example.two_pointers;

public class RemoveElementFromSortedArray {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
                j++;
            }else{
                j++;
            }
        }
        return i;
    }
}

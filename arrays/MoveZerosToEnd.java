package arrays;

public class MoveZerosToEnd {
    public void moveZeroes(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] == 0){
                int j = i + 1;
                while(j < nums.length && nums[j] == 0){
                    j++;
                }
                if(j < nums.length){
                    swap(nums, i, j);
                }
            }
            i += 1;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

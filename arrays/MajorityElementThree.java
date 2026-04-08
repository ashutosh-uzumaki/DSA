package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElementThree {
    public List<Integer> majorityElement(int[] nums) {
        int val = nums[0];
        int cnt = 1;
        int val2 = -1;
        int cnt2 = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == val){
                cnt += 1;
            }else if(cnt == 0){
                val = nums[i];
                cnt = 1;
            }else if(val2 == nums[i]){
                cnt2 += 1;
            }
            else if(cnt2 == 0){
                val2 = nums[i];
                cnt2 = 1;
            }else{
                cnt -= 1;
                cnt2 -= 1;
            }
        }

        return new ArrayList<>(Arrays.asList(val, val2));
    }
}

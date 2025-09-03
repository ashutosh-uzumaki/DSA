package org.example.two_pointers;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int sumReq = -nums[i];
            while(j < k){
                if(nums[j] + nums[k] == sumReq){
                    List<Integer> curr = new ArrayList<>();
                    curr.add(nums[i]);
                    curr.add(nums[j]);
                    curr.add(nums[k]);
                    answer.add(new ArrayList<>(curr));
                    int val = nums[j];
                    while(j < k && nums[j] == val){
                        j++;
                    }
                    val = nums[k];
                    while(k > j && nums[k] == val){
                        k--;
                    }
                }else if(nums[j] + nums[k] > sumReq){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return answer;
    }
}

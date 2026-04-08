package arrays;

public class KadaneAlgo {
    int maxSubarraySum(int[] arr) {
        // Code here
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int num: arr){
            currSum += num;
            maxSum = Math.max(currSum, maxSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}

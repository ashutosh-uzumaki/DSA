package org.example.two_pointers;
import java.util.*;
public class MinOperationsToMakeXZero {
    // Online Java Compiler
// Use this editor to write, compile and run your Java code online
    class Main {
        public static void main(String[] args) {
            int[] nums = {1, 1, 4, 3, 2};
            int x = 5;
            int left = 0;
            int right = 0;
            int totalSum = Arrays.stream(nums).sum();
            int target = totalSum - x;
            System.out.println(findTheMinOperations(nums, target, totalSum, x));
        }
        private static int findTheMinOperations(int[] nums, int target, int totalSum, int x){
            if(x == 0){
                return 0;
            }
            if(target == totalSum){
                return nums.length;
            }
            if(totalSum < target){
                return -1;
            }
            int left = 0, right = 0, maxLength = Integer.MIN_VALUE;
            int runningSum = 0;
            while(right < nums.length){
                runningSum += nums[right];
                if(runningSum > target){
                    runningSum -= nums[left];
                    left++;
                }

                if(runningSum == target){
                    maxLength = Math.max(maxLength, right - left + 1);
                }
                right++;
            }

            return nums.length - maxLength;
        }
    }
}

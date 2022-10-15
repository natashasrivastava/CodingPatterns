/* Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray 
    [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. 
    If there is no such subarray, return 0 instead.


// Try this question on Leetcode https://leetcode.com/problems/minimum-size-subarray-sum/
    Check my solution, feel free to ask question https://leetcode.com/problems/minimum-size-subarray-sum/solutions/2658554/java-sliding-window-solution/
*/
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowStart = 0;
        int windowEnd = 0;
        int windowSize = Integer.MAX_VALUE;
        int windowSum = 0;
        
        for(windowEnd=0;windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd];
            while(windowSum>=target){
                windowSize = Math.min(windowSize, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart];
                windowStart++;
            }
        }
        if(windowSize==Integer.MAX_VALUE){
            return 0;
        }
        return windowSize;
    }
}

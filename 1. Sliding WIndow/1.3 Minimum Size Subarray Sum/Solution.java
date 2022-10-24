
// Check my solution, feel free to ask question https://leetcode.com/problems/minimum-size-subarray-sum/solutions/2658554/java-sliding-window-solution/
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

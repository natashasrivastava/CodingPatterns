// Check my solution on https://leetcode.com/problems/max-consecutive-ones-iii/solutions/2735639/sliding-window/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int windowStart = 0;
        int windowSize = 0;
        int zeroesCount = 0;
        for(int windowEnd = 0; windowEnd< nums.length; windowEnd++){
            if(nums[windowEnd]==0){
                zeroesCount++;
            }
            while(windowStart<nums.length && zeroesCount>k){
                if(nums[windowStart]==0){
                    zeroesCount--;
                }
                windowStart++;
            }
            windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
        }
        return windowSize;
    }
}

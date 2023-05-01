public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
      //Find the point where slope starts to go down.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
          // After that point find minimum
            if (flag)
                min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = nums.length - 2; i >= 0; i--) {
          //Find the point where slope starts to go wrong from end.
            if (nums[i] > nums[i + 1])
                flag = true;
          // After that point find minimum
            if (flag)
                max = Math.max(max, nums[i]);
        }
        int l, r;
      // Find any number less than minimum in sorted subarray
        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }
        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
      
        int prod = 1, ans = 0, left = 0;
      // Expaning a sliding window to max size till the product is less than target.
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
          // Whenever product becomes greater than target, squeeze the window from left until prod<k
            while (prod >= k){
                prod /= nums[left++];
            } 
          // All the subarrays of this window will also have sum less than target.
            ans += right - left + 1;
        }
        return ans;
    }
}

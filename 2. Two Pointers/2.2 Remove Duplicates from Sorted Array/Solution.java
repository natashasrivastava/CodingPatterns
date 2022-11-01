class Solution {
    public int removeDuplicates(int[] nums) {
        // Take two pointers - fast and slow starting from beginning of array
        int fast = 0, slow = 0;
        while(fast<nums.length){
            // If a duplicate element is found, increment fast pointer until non duplicate element is found
            if(nums[fast]==nums[slow]){
                fast++;
            }
            // When a non duplicate element is found, place it after previous non deplicate element
            else{
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        // return pointer where all non duplicate element ends.
        return slow+1;
    }
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] response = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int k = nums.length - 1;
        while(left<=right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                response[k] = nums[left] * nums[left];
                left++;
                k--;
            }
            else{
                response[k] = nums[right] * nums[right];
                right--;
                k--;
            }
        }
        return response;
    }
}

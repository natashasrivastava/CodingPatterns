class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int closestSum = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;

            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int distance = Math.abs(target - sum);

                if(sum == target) {
                    return sum;
                }  

                if(distance < minDistance) {
                    minDistance = distance;
                    closestSum = sum;
                }

                if(sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return closestSum;
    }
}

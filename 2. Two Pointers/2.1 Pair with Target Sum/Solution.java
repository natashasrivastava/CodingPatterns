class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n-1;
        int[] answer = new int[2];
        while(i<j){
            // Take 2 pointers as i and j, i starts from starting and j starts from end of array
            // Calculate sum of elements at these pointers in array
            int sum = numbers[i]+numbers[j];
            
            // When target is found as equal to sum, add it to array and return
            if(sum==target){
                answer[0] = i+1;
                answer[1] = j+1;
                return answer;
            }
            
            // If the sum is less than target, increment i as we need a greater number
            else if(sum < target){
                i++;
            }
            
            // If sum is greater than target, decrement j as we need a smaller number
            else{
                j--;
            }
        }
        return answer;
    }
}

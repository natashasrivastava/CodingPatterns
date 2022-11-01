class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int i = 0, j = n-1;
        int[] answer = new int[2];
        while(i<j){
            int sum = numbers[i]+numbers[j];
            if(sum==target){
                answer[0] = i+1;
                answer[1] = j+1;
                return answer;
            }
            else if(sum < target){
                i++;
            }
            else{
                j--;
            }
        }
        return answer;
    }
}

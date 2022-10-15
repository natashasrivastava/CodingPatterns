//Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K. 
//[Try solving this on Geeks for Geeks](https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)

//Solution in Java

class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> arr,int N){
        int windowStart = 0;
        long sum = 0;
        long windowSum = Integer.MIN_VALUE;
        int windowSize = 0;
        for(int windowEnd = 0; windowEnd < arr.size() ; windowEnd++){
            
            sum += arr.get(windowEnd);
            windowSize = windowEnd - windowStart + 1;
            while(windowSize>=K){
                windowSum = Math.max(sum, windowSum);
                sum -= arr.get(windowStart);
                windowStart++;
                windowSize--;
            }
        }
        return windowSum;
    }
}

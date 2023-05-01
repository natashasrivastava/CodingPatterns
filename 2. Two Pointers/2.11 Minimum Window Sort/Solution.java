// Once an array is sorted (in ascending order), the smallest number is at the beginning and the largest number is at the end of the array. 
// So if we start from the beginning of the array to find the first element which is out of sorting order i.e., which is smaller than its previous element, and similarly from the end of array to find the first element which is bigger than its previous element
// sorting the subarray between these two numbers result in the whole array being sorted

//1. From the beginning and end of the array, find the first elements that are out of the sorting order. The two elements will be our candidate subarray.
//2.Find the maximum and minimum of this subarray.
//3. Extend the subarray from beginning to include any number which is bigger than the minimum of the subarray.
//4. Similarly, extend the subarray from the end to include any number which is smaller than the maximum of the subarray.

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

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        // we will move all 0s before low and all 2s after high so that in the end, all 1s will be between low and high.
        int i = low;
        while(i<n && low<high){
            while(low<n && nums[low]==0){
                System.out.println("Incrementing low");
                low++;
                i++;
            }
            while(high>0 && nums[high]==2){
                System.out.println("Decrementing high");
                high--;
            }
            if(low<high && high>0 && nums[i]==2 && i<high){
                System.out.println("Exchaning i with high");
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            }
            else if(low<high && low<n && nums[i]==0){
                System.out.println("Exchaning i with low");
                int temp = nums[low];
                nums[low]=nums[i];
                nums[i]=temp;
                low++;
            }
            else{
                System.out.println("Continue");
                i++;
            }
        }
    }
}

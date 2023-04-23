class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> quadruples = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                int k = j+1;
                int l = n-1;
                while(k<l){
                    long sum = Long.valueOf(nums[i])+nums[j]+nums[k]+nums[l];
                    if(sum==target){
                        List<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        tempList.add(nums[l]);
                        Collections.sort(tempList);
                        quadruples.add(tempList);
                    }
                    if(sum<target){
                        k++;
                    }
                    else{
                        l--;
                    }
                }
            }
        }
        return new ArrayList<List<Integer>>(quadruples);
    }
}

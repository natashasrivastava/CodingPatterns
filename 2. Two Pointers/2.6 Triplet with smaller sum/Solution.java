// We iterate through the array after sorting it. For any 2 number (i and j) we find k before which every triplet has smaller sum than target.
// Example -> [1, 3, 4, 7, 9] -> target = 12. All subsets between 3 and 7 (j and k respectively) will have sum less than 12 for i = 1.


class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
        Arrays.sort(arr);
        int i = 0;
        int count = 0;
        while(i<n-2){
            int j = i+1;
            int k = n-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k]<sum){
                    count = count + (k-j); // All the subset before k will have sum smaller than target
                    j++;
                    k = n-1;
                }
                else{
                    k--;
                }
            }
            i++;
        }
        return count;
    }
}

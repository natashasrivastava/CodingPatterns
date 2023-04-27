class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& a) {
      //If there is only 1 interval, nothing to merge
        if(a.size()==1){
            return a;
        }
      // Sort the intervals on the start to ensure starting of each element is greater than or equal to previous one.
        sort(a.begin(), a.end());
        vector<vector<int>> ans;
        for(int i=0;i<a.size();i++){
          // If result is empty, compare first two intervals
            if(ans.size()==0){
              // If ‘a’ overlaps ‘b’ (i.e. b.start <= a.end), we need to merge them into a new interval ‘c’ such that 
              // c.start = a.start and c.end = max(a.end, b.end)
                if(a[i][1]>=a[i+1][0]){
                    vector<int> temp;
                    temp.push_back(a[i][0]);
                    int x = a[i+1][1]>a[i][1]? a[i+1][1] : a[i][1];
                    temp.push_back(x);
                    ans.push_back(temp);
                    i++;
                }
                else
                    ans.push_back(a[i]);
            }
          // If there is a entry in result, compare that entry with current interval
            else{
                int n = ans.size();
                if(ans[n-1][1]>=a[i][0]){
                    if(ans[n-1][1] < a[i][1])
                        ans[n-1][1] = a[i][1];
                }
                else{
                    vector<int> temp;
                    temp.push_back(a[i][0]);
                    temp.push_back(a[i][1]);
                    ans.push_back(temp);
                }
            }
        }

        return ans;
    }

    bool checkMerge(vector<int> a, vector<int> b){
        return (a[1]>=b[0]);
    }
};

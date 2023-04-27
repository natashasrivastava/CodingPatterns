class Solution {
    public int[][] insert(int[][] a, int[] newInterval) {
        
        int i = 0;
        List<int[]> answer = new ArrayList<>();
        int j = 0;
        boolean inserted = false;
        while(i<a.length){
          
            if(inserted){
              // If new element is already inserted, check if it is overlapping any other interval
                int n = answer.size();
                if(answer.get(n-1)[1]>=a[i][0]){
                    answer.get(n-1)[0] = Math.min(a[i][0], answer.get(n-1)[0]);
                    answer.get(n-1)[1] = Math.max(a[i][1], answer.get(n-1)[1]);
                }
              //Else directly insert
                else{
                    answer.add(a[i]);
                }
                i++;
            }
          // If new element is not in range of current interval, just add to answer.
            else if(a[i][1]<newInterval[0]){
                answer.add(a[i]);
                i++;
            }
          // If newInterval is smaller than current interval, add new interval
            else if(a[i][0]>newInterval[0]){
                answer.add(newInterval);
                inserted = true;
            }
          // To handle all other overlapping cases.
            else{
                int[] temp = new int[2];
                temp[0] = Math.min(a[i][0], newInterval[0]);
                temp[1] = Math.max(a[i][1], newInterval[1]);
                answer.add(temp);
                inserted= true;
                i++;
            }
        }
      // Cases when newInterval does not overlap any element in list
        if(!inserted){
            answer.add(newInterval);
        }
        return answer.toArray(new int[answer.size()][2]);
    }
}

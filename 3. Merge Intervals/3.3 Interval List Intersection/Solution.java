class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        List<int[]> c = new ArrayList<int[]>();
      // If any list is empty, intersection not possible
        if(a.length==0 || b.length ==0){
            return c.toArray(new int[c.size()][]);
        }
        int i = 0;
        int j = 0;
        while(i<a.length && j<b.length){
          //Increase the pointer of smaller interval
            if(a[i][0]>b[j][1]){
                j++;
            }
            else if(a[i][1]<b[j][0]){
                i++;
            }
          //Take maximum of starting and minimum of ending points
            else if( a[i][1]>=b[j][0] || b[j][1]<=a[i][0]){
                System.out.println(Arrays.toString(a[i])+ " "+ Arrays.toString(b[j]));
                int[] temp = new int[2];
                temp[0] = Math.max(a[i][0], b[j][0]);
                temp[1] = Math.min(a[i][1], b[j][1]);
                c.add(temp);
                if(c.get(c.size()-1)[1]>=a[i][1]){
                    i++;
                }
                if(c.get(c.size()-1)[1]>=b[j][1]){
                    j++;
                }
            }
        }
         return c.toArray(new int[c.size()][]);
    }
}

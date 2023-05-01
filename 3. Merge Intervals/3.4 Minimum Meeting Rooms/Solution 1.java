public class Solution {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            a.add(A.get(i).get(0));
            b.add(A.get(i).get(1));
        }

        Collections.sort(a);
        Collections.sort(b);

        int i = 0;
        int j = 0;
        int rooms = 0;
      // Seperate
        while (i < A.size() && j < A.size()) {
            if (a.get(i) < b.get(j)) {
                rooms++;
                i++;
            } else {
                i++;
                j++;
            }
        }
        return rooms;
    }
}


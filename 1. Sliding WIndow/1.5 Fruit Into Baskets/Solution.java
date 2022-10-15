/*
  Given an array of characters where each character represents a fruit tree,
  you are given two baskets and your goal is to put maximum number of fruits in each basket. 
  The only restriction is that each basket can have only one type of fruit.
  
  You can start with any tree, but once you have started you can’t skip a tree. 
  You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
  
  Write a function to return the maximum number of fruits in both the baskets.
  
  Try Solving on Leetcode https://leetcode.com/problems/fruit-into-baskets/solutions/
  Check my Solution https://leetcode.com/problems/fruit-into-baskets/solutions/2707619/sliding-window-in-java/
*/

class Solution {
    public int totalFruit(int[] fruits) {
        int windowStart = 0;
        int windowSize = 0;
        int uniqueCount = 0;
        Map<Integer, Integer> basketFruits = new HashMap<>();
        for(int windowEnd = 0; windowEnd < fruits.length; windowEnd ++){
            basketFruits.merge(fruits[windowEnd], 1, Integer::sum);
            if(basketFruits.get(fruits[windowEnd])==1){
                uniqueCount++;
            }
            if(uniqueCount<=2){
                windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
            }
            while(uniqueCount>2){
                int currfruits = basketFruits.get(fruits[windowStart]);
                basketFruits.put(fruits[windowStart], currfruits - 1);
                if(currfruits-1==0){
                    uniqueCount--;
                }
                windowStart++;
            }
        }
        return windowSize;
    }
}

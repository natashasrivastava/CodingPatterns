/*  Given a string you need to print the size of the longest possible substring that has exactly K unique characters. 
    If there is no possible substring then print -1.
    
    Try solving this question on GFG https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1
*/

class Solution {
    public int longestkSubstr(String s, int k) {
        int windowStart = 0;
        int windowSize = 0;
        int uniqueCount = 0;
        int[] alphabets = new int[27];
        for(int windowEnd = 0; windowEnd < s.length() ; windowEnd++){
            alphabets[s.charAt(windowEnd) - 'a']++;
            if(alphabets[s.charAt(windowEnd) - 'a']==1){
                uniqueCount++;
            }
            if(uniqueCount==k){
                windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
            }
            while(uniqueCount>k && windowStart < s.length()){
                alphabets[s.charAt(windowStart) - 'a']--;
                if(alphabets[s.charAt(windowStart) - 'a']==0){
                    uniqueCount--;
                }
                windowStart++;
            }
        }
        if(windowSize==0){
            return -1;
        }
        return windowSize;
    }
}

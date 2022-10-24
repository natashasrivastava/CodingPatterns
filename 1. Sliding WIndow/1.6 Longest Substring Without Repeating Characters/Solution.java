//Check my solution for this https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/2713717/sliding-window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int windowSize = 0;
        int windowStart = 0;
        int notUniqueCount = 0;
        HashMap<Character, Integer> alphabets = new HashMap<Character, Integer> ();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            while(alphabets.containsKey(s.charAt(windowEnd)) && windowStart<s.length()){
                alphabets.put(s.charAt(windowStart), alphabets.getOrDefault(s.charAt(windowStart),0)-1);
                if(alphabets.get(s.charAt(windowStart))<=0){
                    alphabets.remove(s.charAt(windowStart));
                }
                windowStart++;
            }
            alphabets.put(s.charAt(windowEnd), 1);
            windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
        }
        return windowSize;
    }
 }

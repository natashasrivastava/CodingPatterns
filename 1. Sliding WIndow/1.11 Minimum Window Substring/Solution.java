// Check out my solution https://leetcode.com/problems/minimum-window-substring/solutions/2740085/sliding-window/

class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return new String();
        }

        Map<Character, Integer> frequencyMap = new HashMap<Character, Integer>();
        for(int i=0;i<t.length();i++){
            frequencyMap.put(t.charAt(i), frequencyMap.getOrDefault(t.charAt(i),0)+1);
        }

        int matched = 0;
        int windowSize = Integer.MAX_VALUE;
        int minWindowStart = 0;
        int minWindowEnd = 0;
        int windowStart = 0;
        int windowEnd = 0;
        for(; windowEnd< s.length(); windowEnd++){
            char rightChar = s.charAt(windowEnd);
            if(frequencyMap.containsKey(rightChar)){
                frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
                // Count everytime total occurrences of a character matches
                if(frequencyMap.get(rightChar)==0){
                    matched++;
                }   
            }
            
            //Shrink the window once all character matched
            while(windowStart<s.length() && matched == frequencyMap.size()){
                if(windowSize > windowEnd - windowStart + 1){
                    windowSize = windowEnd - windowStart + 1;
                    minWindowStart = windowStart;
                    minWindowEnd = windowEnd;
                }
                char leftChar = s.charAt(windowStart);
                if(frequencyMap.containsKey(leftChar)){
                    if(frequencyMap.get(leftChar)==0){
                        matched--;
                    }  
                    frequencyMap.put(leftChar, frequencyMap.getOrDefault(leftChar, 0)+1);
                }
                windowStart++;
            }
        }
        if(windowSize==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(minWindowStart, minWindowEnd+1);
    }
}

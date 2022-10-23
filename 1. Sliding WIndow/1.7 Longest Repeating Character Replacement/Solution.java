class Solution {
    public int characterReplacement(String s, int k) {
        int windowStart = 0;
        int windowSize = 0;
        int currentWindowSize = 0;
        int maxRepeatLetterCount = 0;
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){

            //Counting frequency of character at windowEnd to check most repeating character
            char rightChar = s.charAt(windowEnd);
            frequency.put(rightChar, frequency.getOrDefault(rightChar, 0)+1);
            

            // Counting character that is repeated again and again
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, frequency.get(rightChar));
            
        
            /* Shrink the Window when Remaining elements in window are more than k
                Remaining elements are non repeating elements that are to be replaced
            */
            while(windowEnd - windowStart + 1 - maxRepeatLetterCount>k){
                char leftChar = s.charAt(windowStart);
                frequency.put(leftChar, frequency.getOrDefault(leftChar,0)-1);
                windowStart++;
            }
            windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
        }
        return windowSize;
    }
}

class Solution{
    int longestUniqueSubsttr(String S){
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        int windowStart = 0;
        int windowSize = 0;
        for(int windowEnd = 0; windowEnd < S.length(); windowEnd++){
            if(counts.containsKey(S.charAt(windowEnd))){
                windowStart = Math.max(windowStart, counts.get(S.charAt(windowEnd))+1);
            }
            counts.put(S.charAt(windowEnd), windowEnd);
            windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
        }
        return windowSize;
    }
}

class Solution
{
    public int characterReplacement(String s, int k)
    {
        int windowStart = 0;
        int windowSize = 0;
        int maxRepeatingCharacter = 0;
        int[] frequency = new int[27];
        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            frequency[s.charAt(windowEnd) - 'A']++;
            maxRepeatingCharacter = Math.max(maxRepeatingCharacter, frequency[s.charAt(windowEnd) - 'A']);
            while(windowEnd - windowStart + 1 - maxRepeatingCharacter > k ){
                if(frequency[s.charAt(windowStart) - 'A']>0){
                    frequency[s.charAt(windowStart) - 'A']--;
                }
                windowStart++;
            }
            windowSize = Math.max(windowSize, windowEnd - windowStart + 1);
        }
        return windowSize;
    }
}

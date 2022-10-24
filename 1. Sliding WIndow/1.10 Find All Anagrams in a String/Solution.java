// Check my solution on https://leetcode.com/problems/find-all-anagrams-in-a-string/solutions/2738394/sliding-window/

class Solution {
    public List<Integer> findAnagrams(String s2, String s1) {
        //If length of s2 is less than s1, then permutation cannot be found
        List<Integer> startingIndices = new ArrayList<Integer>();
        if(s2.length()<s1.length()){
            return startingIndices;
        }

        // Creating frequency count of all letters in s1
        // Anagram of a letter is finding all its elements in a subsequence
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for(int i=0;i<s1.length();i++){
            frequency.put(s1.charAt(i), frequency.getOrDefault(s1.charAt(i), 0) + 1);
        }


        //We iterate on WindowStart
        int windowEnd = 0;
        for(int windowStart=0; windowStart < s2.length(); windowStart++){
            // whenever we find an alphabet from s1 in s2..
            // we expand window (incrementing windowEnd) to find the permutation
            if(frequency.containsKey(s2.charAt(windowStart))){
                int[] checkPermutation = new int[27];
                windowEnd = windowStart;
                //Iterate till you find an alphabet that do not exist in s1
                while(windowEnd < s2.length() && frequency.containsKey(s2.charAt(windowEnd))){
                    checkPermutation[s2.charAt(windowEnd) - 'a']++;
                    // If any alphabet occurs more than required frequency, shrink the window from starting
                    while(checkPermutation[s2.charAt(windowEnd) - 'a'] > frequency.get(s2.charAt(windowEnd))){
                        checkPermutation[s2.charAt(windowStart) - 'a']--;
                        windowStart++;
                    }
                    // If windowSize is equal to s1 length, permutation found
                    if(windowEnd - windowStart + 1 == s1.length()){
                        startingIndices.add(windowStart);
                    }
                    windowEnd++;
                }
                windowStart = windowEnd;
            }
        }
        return startingIndices;

    }
}

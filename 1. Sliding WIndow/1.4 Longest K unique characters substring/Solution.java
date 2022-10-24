/*  
1. First, we will insert characters from the beginning of the string until we have ‘K’ distinct characters in the HashMap.
2. These characters will constitute our sliding window. We are asked to find the longest such window having no more than ‘K’ distinct characters. 
    We will remember the length of this window as the longest window so far.
3. After this, we will keep adding one character in the sliding window (i.e. slide the window ahead), in a stepwise fashion.
4. In each step, we will try to shrink the window from the beginning if the count of distinct characters in the HashMap is larger than ‘K’. 
    We will shrink the window until we have no more than ‘K’ distinct characters in the HashMap. This is needed as we intend to find the longest window.
5. While shrinking, we’ll decrement the frequency of the character going out of the window and remove it from the HashMap if its frequency becomes zero.
6. At the end of each step, we’ll check if the current window length is the longest so far, and if so, remember its length.
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

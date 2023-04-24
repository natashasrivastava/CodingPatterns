// We traverse each string once and apply all backspaces. To do this we replace character with #.

class Solution {
public:
    bool backspaceCompare(string s, string t) {
      //To apply the backspaces, we would traverse from the end of both the strings.
        int i =s.length()-1;
        int sHash = 0;
        while(i>=0){
          //If we find a hash, we count it.
            if(s[i]=='#'){
                ++sHash;
            }
          //If we find a character but we have pending backspaces(hash) to apply, we convert character to hash indicating that its deleted.
            else if(sHash>0){
                s[i] = '#';
                sHash--;
            }
            i--;
        }
      
      // Do the same for second string
        int j =t.length()-1;
        int tHash = 0;
        while(j>=0){
            if(t[j]=='#'){
                ++tHash;
            }
            else if(tHash>0){
                t[j] = '#';
                tHash--;
            }
            j--;
        }
        i = 0;
        j =0;


      // At the end compare both strings using 2 pointers i and j. Skip whenever you find a #
        while(i<s.length() && j<t.length()){
            while(s[i]=='#') ++i;
            while(t[j]=='#') ++j;
            if(i<s.length() && j<t.length() && s[i]!=t[j]) return false;
            if(i<s.length() && j<t.length() && s[i]==t[j]) {++i;++j;}
        }
        
      //If pointer reaches end of any string, but other string is left to traverse. See if there are any non # hash character left.
        if(i<s.length()){
            while(i<s.length()){
                if(s[i]!='#') return false;
                i++;
            }
        }

        if(j<t.length()){
            while(j<t.length()){
                if(t[j]!='#') return false;
                j++;
            }
        }
        return true;
    }
    
};

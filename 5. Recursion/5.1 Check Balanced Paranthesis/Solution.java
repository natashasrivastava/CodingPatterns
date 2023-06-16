//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends

class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        return findClosing(x.toCharArray(), x.length());
    }
    
    static boolean findClosing(char x[], int n){
        if(n==0){
            return true;
        }
        if(n==1){
            return false;
        }
        if(x[0]=='}' || x[0]==')' || x[0]==']'){
            return false;
        }
        
      // Search for closing bracket for first opening bracket.
        char closingChar = findclosingChar(x[0]);
        
      // count is used to handle cases like "((()))". We basically need to consider matching closing bracket.
        int count = 0;
        int i = 1;
        for(;i<n;i++){
            if(x[i]==x[0]){
                count++;
            }
            if(closingChar==x[i]){
                if(count==0){
                    break;
                }
                count--;
            }
        }
        
      // If next element is closing char, return response of remaining array
        if(i==1){
            return findClosing(Arrays.copyOfRange(x, i+1, n), n-2);
        }
        
      // If closing bracket is not found in remaining array return false
        if(i==n){
            return false;
        }
       // If closing bracket was somewhere in middle.check in the middle part and check in the remaining part
  return findClosing(Arrays.copyOfRange(x, 1, i), i-1) && findClosing(Arrays.copyOfRange(x, i+1, n), n-(i+1));
        
    }
    
    static char findclosingChar(char opening){
        if(opening == '{'){
            return '}';
        }
        if(opening == '('){
            return ')';
        }
        if(opening == '['){
            return ']';
        }
        return Character.MIN_VALUE;
    }
}

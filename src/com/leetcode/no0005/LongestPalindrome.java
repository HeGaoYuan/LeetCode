package com.leetcode.no0005;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        return longestPalindromeForce(s);
    }

    private boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            if(s.charAt(i) == s.charAt(len-1-i))
                continue;
            else
                return false;
        }
        return true;
    }

    /*
    几秒前	通过	508 ms	38.7 MB	java
     */
    private String longestPalindromeForce(String s) {
        int len = s.length();
        for(int testLen = len; testLen > 1; testLen--){
            for(int i = 0, j = testLen; j <= len;){
                if(isPalindrome(s.substring(i, j)))
                    return s.substring(i, j);
                i++;
                j++;
            }
        }
        return "";
    }

}

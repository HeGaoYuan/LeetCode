package com.leetcode.no0003;

/*
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s)
    {
        return lengthOfLongestSubstringWindowBetter(s);
    }

    /*
    几秒前	通过	362 ms	65.9 MB	java
     */
    private int lengthOfLongestSubstringForce(String s){
        int len = s.length();
        int longest = 0;
        for(int i = 0; i < len; i++){
            int subLongest = 1;
            StringBuffer subStr = new StringBuffer(String.valueOf((s.charAt(i))));
            for(int j = i+1; j < len; j++){
                if(subStr.indexOf(String.valueOf(s.charAt(j))) != -1)//子串中有了重复字符
                    break;
                else {
                    subLongest++;
                    subStr.append(s.charAt(j));
                }
            }
            longest = subLongest > longest ? subLongest : longest;
        }
        return longest;
    }

    /*
    几秒前	通过	203 ms	79.8 MB	java
     */

    private int lengthOfLongestSubstringForceBetter(String s){
        int len = s.length();
        int longest = 0;
        for(int i = 0; i < len; i++) {
            int subLongest = 1;
            HashSet<Character> hashSet = new HashSet<>();
            hashSet.add(s.charAt(i));
            for (int j = i + 1; j < len; j++) {
                if (hashSet.contains(s.charAt(j)))
                    break;
                else {
                    hashSet.add(s.charAt(j));
                    subLongest++;
                }
            }
            longest = subLongest > longest ? subLongest : longest;
        }
        return longest;
    }

    private int lengthOfLongestSubstringWindowBetter(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
}

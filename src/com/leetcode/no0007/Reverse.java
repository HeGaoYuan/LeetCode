package com.leetcode.no0007;
/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */


import java.util.ArrayList;
import java.util.List;

public class Reverse {
    public int reverse(int x){
        return reverseMethod1(x);
    }

    /*
    几秒前	通过	49 ms	45.9 MB	java
    */
    public  int reverseMethod1(int x) {
        if(x == 0)
            return 0;
        boolean isPostive = x > 0 ? true : false;
        if(!isPostive){
            if(Math.abs(x) < 0)
                return 0;
            x = Math.abs(x);
        }
        List<Integer> result = new ArrayList<>();
        while(x > 0){
            result.add(x % 10);
            x /= 10;
        }
        int len = result.size();
        long reverseNum = 0;
        long times = 1;
        reverseNum = result.get(len - 1) * times;
        for(int i = len - 2; i >= 0; i--){
            times = times * 10;
            reverseNum += result.get(i) * times;
        }
        if(!isPostive){
            reverseNum = 0 - reverseNum;
        }
        if(reverseNum > Integer.MAX_VALUE || reverseNum < Integer.MIN_VALUE)
            return 0;
        else
            return (int)reverseNum;
    }

    /*
    几秒前	通过	42 ms	48.7 MB	java
     */

    public int reverseMethod2(int x){
        long result = 0;
        int pop = 0;
        while( x != 0 ){
            pop = x % 10;
            result = result * 10 + pop;
            x = x / 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        else
            return (int)result;
    }

    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverseMethod2(-1534239));
    }
}

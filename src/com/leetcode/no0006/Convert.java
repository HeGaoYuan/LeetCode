package com.leetcode.no0006;
/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"
示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Convert {
    public String convert(String s, int numRows) {
        return convertMethod1(s, numRows);
    }

    /*
    几秒前	通过	701 ms	56.3 MB	java
    将List<char[]> list = new LinkedList<>();换成
    List<char[]> list = new ArrayList<>();
    几秒前	通过	62 ms	40.4 MB	java
     */
    private String convertMethod1(String s, int numRows){
        if(numRows == 1)
            return s;
        int len = s.length();
        int index = 0;
        //List<char[]> list = new LinkedList<>();
        List<char[]> list = new ArrayList<>();
        for(int i = 0; index < len; i++){
            char[] column = new char[numRows];
            for(int j = 0; j < numRows; j++){
                if(i % (numRows-1) == 0 && index < len) {
                    column[j] = s.charAt(index);
                    index++;
                }else{
                    if(numRows - 1 - (i % (numRows -1)) == j && index < len){
                        column[j] = s.charAt(index);
                        index++;
                    }
                }
            }
            list.add(column);
        }
        StringBuffer result = new StringBuffer();

        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j)[i] != 0){
                    result.append(list.get(j)[i]);
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        System.out.println(convert.convert("LEETCODEISHIRING", 4));
    }
}

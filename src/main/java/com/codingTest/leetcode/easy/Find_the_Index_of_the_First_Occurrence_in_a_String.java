package com.codingTest.leetcode.easy;

public class Find_the_Index_of_the_First_Occurrence_in_a_String {
    private boolean isEquals(String haystack, String needle, int istart) {
        for (int i = 0; i < needle.length(); i++) {
            if (haystack.charAt(i + istart) != needle.charAt(i)) return false;
        }
        return true;
    }

    public int strStr(String haystack, String needle) {
        int originLen = haystack.length(), len = needle.length();
        int repeat = originLen - len + 1;
        for (int i = 0; i < repeat; i++) {
            if (isEquals(haystack, needle, i)) return i;
        }
        return -1;
    }
}

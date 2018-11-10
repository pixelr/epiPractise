package com.company;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {

        char[] chars = "     abc  fg  h i j k".toCharArray();
        clearspace(chars);
        System.out.println(chars);

        StringTest st = new StringTest();
        System.out.println(st.countAndSay(4));
    }

    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = nextNumber(s);
        }
        return s;
    }

    public String nextNumber(String s) {
        int[] count = new int[10];
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - '0']++;
        }
        String st = "";
        for (int i = 1; i <= 9; i++) {
            if(count[i] !=0)
            st +=  Integer.toString(i) + Integer.toString(count[i]);
        }
        return st;
    }

    public static void clearspace(char[] chars) {
        int last = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                chars[last++] = chars[i];
                if (i + 1 < chars.length && chars[i + 1] == ' ') {
                    chars[last] = ' ';
                    last++;
                }
            }
        }
        while (last < chars.length) {
            chars[last++] = ' ';
        }
    }
}

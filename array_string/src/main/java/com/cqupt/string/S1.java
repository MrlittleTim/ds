package com.cqupt.string;

import org.junit.Test;

import java.util.Arrays;

public class S1 {

    @Test
    public void stringEquals() {
// "static void main" must be defined in a public class.
        // initialize
        String s1 = "Hello World";
        System.out.println("s1 is \"" + s1 + "\"");
        String s2 = s1;
        System.out.println("s2 is another reference to s1.");
        String s3 = new String(s1);
        System.out.println("s3 is a copy of s1.");
        // compare using '=='
        System.out.println("Compared by '==':");
        // true since string is immutable and s1 is binded to "Hello World"
        System.out.println("s1 and \"Hello World\": " + (s1 == "Hello World"));
        // true since s1 and s2 is the reference of the same object
        System.out.println("s1 and s2: " + (s1 == s2));
        // false since s3 is refered to another new object
        System.out.println("s1 and s3: " + (s1 == s3));
        // compare using 'equals'
        System.out.println("Compared by 'equals':");
        System.out.println("s1 and \"Hello World\": " + s1.equals("Hello World"));
        System.out.println("s1 and s2: " + s1.equals(s2));
        System.out.println("s1 and s3: " + s1.equals(s3));
        // compare using 'compareTo'
        System.out.println("Compared by 'compareTo':");
        System.out.println("s1 and \"Hello World\": " + (s1.compareTo("Hello World") == 0));
        System.out.println("s1 and s2: " + (s1.compareTo(s2) == 0));
        System.out.println("s1 and s3: " + (s1.compareTo(s3) == 0));
    }

    /*
        java 字符串不可变。若是其可变，可以使用 toCharArray 将其转换为字符数组。
     */
    @Test
    public void s1() {
        String s1 = "Hello World";
//        s1[5] = ',';
        System.out.println(s1);
        char[] charArray = s1.toCharArray();
        charArray[5] = ',';
        String s = String.valueOf(charArray);
        System.out.println(s);
        String s2 = new String(charArray);
        System.out.println(s2);
    }
}

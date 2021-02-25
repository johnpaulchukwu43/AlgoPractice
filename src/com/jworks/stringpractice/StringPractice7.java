package com.jworks.stringpractice;

public class StringPractice7 {
    /*Question:
    Implement a method to perform basic string compression using the counts of
    repeated characters. For example, the string aabcccccaaa would become
    a2blc5a3. If the "compressed" string would not become smaller than the original
    string, your method should return the original string*/

    public static String compressString(String value){

        /*
         * Approach Taken:
         * 1. Go through the string value, and check repeats and keep a count of it.
         * 2. For each unique character found , append the character and count to string
         * 3. When done, if length of compressed string is less than the original length, then return compressed string else return original value
         * */

        if(value == null || value.length() == 0) {
            return value;
        }

        int originalLength = value.length();

        char[] charValueArray = value.toCharArray();

        StringBuilder compressedValue = new StringBuilder();

        char last = charValueArray[0];

        int count =0;

        for (char c : charValueArray) {

            if (c == last) {
                count++;
            } else {
                compressedValue.append(last);
                compressedValue.append(count);
                last = c;
                count = 1;

            }
        }

        compressedValue.append(last);
        compressedValue.append(count);

        String compressedValueString = compressedValue.toString();
        int compressedLength = compressedValueString.length();
        return compressedLength < originalLength ? compressedValueString : value;
    }

}

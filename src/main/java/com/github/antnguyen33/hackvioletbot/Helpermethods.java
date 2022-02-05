package com.github.antnguyen33.hackvioletbot;

public class Helpermethods{
    /**
     * 
     * @param input a string that the user sends in a message
     * @return an array of strings containing each word the array 
     */
    public static String[] stringToArray(String input) { 
        String[] output;
        output = input.split(" ",0);
        return output;
    }
    /**
     * 
     * @param array
     * @return if the word is in the array, then return true, else false
     */
    public static boolean checkInArray(String[] array, String checkword) { 
        for (int i = 0; i<array.length;i++) { 
            if (array[i] == checkword) {
                return true;
            }
        }
        return false;
        
    }

}

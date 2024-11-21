package Trainings;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trainings {

    public int deepRoot(int n){
        /*
         * Digital root is the recursive sum of all the digits in a number.
         * Given n, take the sum of the digits of n. If that value has more than one digit, 
         * continue reducing in this way until a single-digit number is produced. 
         * The input will be a non-negative integer.
         * 
         * Example:
         * 16 --> 1 + 6 = 7
         * 942 --> 9 + 4 + 2 = 15 --> 1 + 5 = 6
         * 132189 --> 1 + 3 + 2 + 1 + 8 + 9 = 24 --> 2 + 4 = 6
         * 493193 --> 4 + 9 + 3 + 1 + 9 + 3 = 29 --> 2 + 9 = 11 --> 1 + 1 = 2
        */
        String value = String.valueOf(n);
        int result = 0;
        boolean flag = false;

        for(char c : value.toCharArray()){
            result = result + Integer.parseInt(String.valueOf(c));
        }

        value = String.valueOf(result);
        while(!flag){
            if(result >= 10) {
                result = 0;
                for(char c : value.toCharArray()){
                    result = result + Integer.parseInt(String.valueOf(c));
                }
                value = String.valueOf(result);
            }
            else {
                flag = true;
            }
        }
        System.out.println(result);
        return result;
    }

    public long digPow(int n , int p){

        double result = 0;
        for(char c : String.valueOf(n).toCharArray()){
            System.out.println("{"+ c +"} : {"+ String.valueOf(p) +"} = {"+ Math.pow((double)Integer.parseInt(String.valueOf(c)),(double)p) +"}");
            result = result + (Math.pow((double)Integer.parseInt(String.valueOf(c)),(double)p));
            p++;
        }
        return -1;
    }

    public long findNextSquare(long sq){
        /*
         * Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter. 
         * Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
           If the argument is itself not a perfect square then return either -1 or an empty value like None or null, depending on your language. 
           You may assume the argument is non-negative.

           Examples:
           121 --> 144
           625 --> 676
           114 --> -1 because 114 is not a perfect square
         */
        if((Math.sqrt(sq)) - Math.floor(Math.sqrt(sq)) != 0){
            return -1;
        }
        return (long)Math.pow((Math.sqrt(sq) + 1), 2);
        
    }

    public String printerError(String s){
        /*
         * You have to write a function printer_error which given a string will return the error rate of the printer.
         * As a string representing a rational whose numerator is the number of errors and the denominator the length of the control string. 
         * Don't reduce this fraction to a simpler expression.
         * The string has a length greater or equal to one and contains only letters from ato z.
         * 
         * Example: 
         * s="aaabbbbhaijjjm"
         * printerError(s) => "0/14"
         * 
         * s="aaaxbbbbyyhwawiwjjjwwm"
         * printerError(s) => "8/22"
         */
        String regex = "[^a-mA-M$]";   

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        int count = 0;

        while(matcher.find()){
            count++;
        }

        System.out.println(String.format("%s/%s", count, s.length()));
        return String.format("%s/%s", count,s.length());
    }

    public String maskify(String str){
        /*
           Your task is to write a function maskify, which changes all but the last four characters into '#'.
           "4556364607935616" --> "############5616"
           "64607935616" -->      "#######5616"
           "1" -->                "1"
           "" -->                 ""
         */
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            if(i >= (str.length() - 4)){
                s.append(str.charAt(i));
            }else{
                s.append('#');
            }
        }
        return s.toString();
    }

    public int find(int[] integers){
        if(integers.length == 0){
            return 0;
        }
        if(Arrays.stream(integers).filter(x-> x % 2 == 0).count() == 1){
            return Arrays.stream(integers).filter(x -> x % 2 == 0).findFirst().getAsInt();
        }
        return Arrays.stream(integers).filter(x -> x % 2 == 1).findFirst().getAsInt();
    }

    public boolean getXO(String str){
        /*
         * Check to see if a string has the same amount of 'x's and 'o's. 
         * The method must return a boolean and be case insensitive. 
         * The string can contain any char.
         * 
         * Example:
         * XO("ooxx") => true
         * XO("xooxx") => false
         * XO("ooxXm") => true
         * XO("zpzpzpp") => true // when no 'x' and no 'o' is present should return true
         * XO("zzoo") => false
        */
        int X = 0, O = 0;

        for(char c : str.toCharArray()){
            switch (c) {
                case 'o':
                case 'O':
                    O++;
                    break;
                case 'x':
                case 'X':
                    X++;
                    break;
            }
        }

        System.out.println(String.format("O: %s , X: %s", O,X));

        return (X == O || O == 0 && X == 0) ? true : false;
    }

    public int[] sortArray(int[] array){
        /*
         * You will be given an array of numbers. You have to sort the odd numbers in ascending order 
         * while leaving the even numbers at their original positions.
         * 
         * Examples:
         * [7,1] => [1,7]
         * [5,8,6,3,4] => [3,8,6,5,4]
         * [9,8,7,6,5,4,3,2,1,0] => [1,8,3,6,5,4,7,2,0]
        */
        List<Integer> val = new ArrayList<>();
        for(int i : array){
            if (i % 2 == 1) {
                val.add(i);
            }
        }

        val.sort(null);

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 1){
                array[i] = val.get(0);
                val.remove(0);
            }
        };

        for(int v : array){
            System.out.print(v);
        }
        return array;
    }

    public String whoLikesIt(String... names){
        //Implement the function which takes an array containing the names of people that like an item.
        //It must return the display text as shown in the examples:
        /*[]                                -->  "no one likes this"
          ["Peter"]                         -->  "Peter likes this"
          ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
          ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
          ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this" */
        if(names.length == 1){
            return String.format("%s likes this", names[0]);
        }
        if(names.length == 2){
            return String.format("%s and %s like this", names[0], names[1]);
        }
        if (names.length == 3) {
            return String.format("%s, %s and %s like this", names[0],names[1],names[2]);
        }
        if (names.length >= 4) {
            return String.format("%s, %s and %s others like this", names[0],names[1], names.length - 2);
        }

        return "no one likes this";
    }
    
    

}




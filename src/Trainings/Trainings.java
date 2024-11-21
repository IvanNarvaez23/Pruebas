package Trainings;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Trainings {

    public int deepRoot(int n){
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

        if((Math.sqrt(sq)) - Math.floor(Math.sqrt(sq)) != 0){
            return -1;
        }
        return (long)Math.pow((Math.sqrt(sq) + 1), 2);
        
    }

    public String printerError(String s){
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




package day4.part1;

import java.util.stream.Collectors;

public class PasswordChecker {

    public boolean isSixDigits(String number){
        return number.length() == 6;
    }

    public boolean hasAdjacentDigits(String number){
        for (int i = 0; i < number.length()-1; i++) {
            char c = number.charAt(i);
            if(number.charAt(i+1) == c)
                return true;
        }
        return false;
    }

    public boolean hasOnlyIncreasingDigits(String number){
        for (int i = 0; i < number.length()-1; i++) {
            int c = Integer.parseInt(""+number.charAt(i));
            int nextC = Integer.parseInt(""+number.charAt(i+1));
            if(c > nextC)
                return false;
        }
        return true;
    }

    public boolean checkRules(String number){
        return isSixDigits(number) && hasAdjacentDigits(number) && hasOnlyIncreasingDigits(number);
    }

    public static void main(String[] args) {
        PasswordChecker checker = new PasswordChecker();
        int validPasswordCount = 0;
        for (int i = 156218; i < 652527; i++) {
            if(checker.checkRules(String.valueOf(i)))
                validPasswordCount++;
        }
        System.out.println(validPasswordCount);
    }
}

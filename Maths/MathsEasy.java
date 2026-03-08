package Maths;

import java.util.ArrayList;
import java.util.HashMap;

public class MathsEasy {

    public static ArrayList<Integer> totalDigits(int n) {

        ArrayList<Integer> digits = new ArrayList<>();
        if (n == 0) {
            digits.add(0);
            return digits;
        }
        while (n > 0) {
            digits.add(n % 10);
            n = n / 10;
        }
        return digits;
    }
    public static boolean isSingleDigit(int x){
        return Math.abs(x) < 10;
    }

    public boolean isHappy(int n){
        // 202. haapy number , sum of squares of digits should be zeros. 
        if (n<=0) return false;
        if(n==1) return true;
        // square of total digits -> combine until single digit -> if that single digit is one then true
        
        while(!isSingleDigit(n)){
            if(n==1) return true;
            ArrayList<Integer> digits = new ArrayList<>();
            digits = totalDigits(n);
            int sum = 0;
            for (int digit : digits) {
                sum +=(digit*digit);
            }
            n=sum;

        }
        return n==1 || n==7;


        // to reduce the complexity we can introduce the squareDigitSum method directly in a static function which willreduce to O(logn)
        


    }

    public static void main(String[] args) {
        System.out.println("This is a maths easy solver :- ");

    }
}
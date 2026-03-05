package String;
public class StringsEasy {
    
    public int romanToInt(String s) {
        int I = 1;
        int V = 5;
        int X = 10;
        int L = 50;
        int C = 100;
        int D = 500;
        int M = 1000;
        int result = 0;
        for(int i=0;i<s.length();i++){
            int S =s.charAt(i);
            if(S == 'I') result+=I;
            else if(S == 'V') result+=V;
            else if(S == 'X') result+=X;
            else if(S == 'L') result+=L;
            else if(S == 'C') result+=C;
            else if(S == 'D') result+=D;
            else if(S == 'M') result+=M;
        }
        if(s.contains("IV") || s.contains("IX")) result-=2*I;
        if(s.contains("XL") || s.contains("XC")) result-=2*X;
        if(s.contains("CD") || s.contains("CM")) result-=2*C;
        return result;
        

    }

    public static void main(String[] args) {
        StringsEasy se = new StringsEasy();
        String s = "IV";
        int result = se.romanToInt(s);
        System.out.println(result);
    }
}

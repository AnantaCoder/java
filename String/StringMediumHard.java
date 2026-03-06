package String;

public class StringMediumHard {
    public String totalSubstring(String s) {

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                sb.append(s.substring(i, j)).append(",");
            }
        }
        return sb.toString();
    }

    public int sumOfBeautyOfSubstring(String s) {
        // 1781. The beauty of a string is the difference in frequencies between the
        // most frequent and least frequent characters.
        // Increament frequency
        // calculate beauty max - min
        // alphabet string has 26 charecters
        StringMediumHard obj = new StringMediumHard();
        String str = obj.totalSubstring(s);
        String[] stra = str.split(",");

        int totalBeauty = 0;
        for (int i = 0; i < stra.length; i++) {
            int[] frequency = new int[26];
            String sub = stra[i];

            // count frequency
            for (int j = 0; j < sub.length(); j++) {
                char c = sub.charAt(j);
                frequency[c - 'a']++;
            }

            int max = 0;
            int min = Integer.MAX_VALUE;

            // fin d the max and minimum frequency
            for (int f : frequency) {
                if (f > 0) {
                    max = Math.max(max, f);
                    min = Math.min(min, f);
                }
            }

            totalBeauty += (max - min);
        }
        return totalBeauty;

    }

    public String reverseWords(String s) {

        StringBuilder reversed = new StringBuilder();
        String[] words = s.trim().split("\\s+"); 
        int n = words.length;
        for(int i= n-1;i>=0;i--){
            reversed.append(words[i]);
            if(i!=0){
                reversed.append(" ");
            }
        }
        
        return reversed.toString();
    }

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
        StringMediumHard obj = new StringMediumHard();
        String s = "aabcb";
        String str = " This is a a moon landing job ";
        String result = obj.totalSubstring(s);
        System.out.println("Total substrings of '" + s + "' is: " + result + " and the total number of substrings is "
                + result.split(",").length);

        System.err.println("Sum of beauty : " + obj.sumOfBeautyOfSubstring(s));
        System.out.println("reversed : "+obj.reverseWords(str));
        System.out.println("reversed : "+obj.romanToInt("IV"));
    }
}

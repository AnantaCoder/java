package String;

public class StringExtras {
    public boolean checkOnesSegment(String s) {
        // leetcode 1748:  Check if Binary String Has at Most One Segment of Ones
        int n = s.length();
        if(n <= 0) return false;
        for(int i = 0; i < n - 1; i++){
            char ch = s.charAt(i);
            char ch1 = s.charAt(i + 1);
            if(ch == '0' && ch1 == '1'){
                return false;
            }
        }
        return true;
        /*
        alternate approach   return !(s.contains("01")); one liner solver 
        */
    }

    
    public static void main(String[] args){
        StringExtras obj = new StringExtras();
        String s = "1001";
        System.out.println("If this has one segment "+ obj.checkOnesSegment(s));
    }
}
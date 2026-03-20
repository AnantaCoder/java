package String;

public class StringExtras {
    public boolean checkOnesSegment(String s) {
        // leetcode-1748: Check if Binary String Has at Most One Segment of Ones
        int n = s.length();
        if (n <= 0)
            return false;
        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);
            char ch1 = s.charAt(i + 1);
            if (ch == '0' && ch1 == '1') {
                return false;
            }
        }
        return true;
        /*
         * alternate approach return !(s.contains("01")); one liner solver
         */
    }

    public int minFlips(String s) {

        int n = s.length();
        int ans = Integer.MAX_VALUE;
        String str = s;

        for (int r = 0; r < n; r++) {
            int flip0 = 0;
            int flip1 = 0;
            for (int i = 0; i < n; i++) {

                char expected0 = (i % 2 == 0) ? '0' : '1';
                char expected1 = (i % 2 == 0) ? '1' : '0';
                if (str.charAt(i) != expected0)
                    flip0++;
                if (str.charAt(i) != expected1)
                    flip1++;
            }
            ans = Math.min(ans, Math.min(flip0, flip1));
            // rotate string
            str = str.substring(1) + str.charAt(0);
        }

        return ans;
    }

    static void main(String[] args) {
        StringExtras obj = new StringExtras();
        String s = "1001";
        System.out.println("If this has one segment " + obj.checkOnesSegment(s));
    }
}
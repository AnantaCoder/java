package String;

public class StringMediumHard {
    public String totalSubstring(String s){



        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<=n; j++){
                sb.append(s.substring(i,j)).append(",");
            }
        }
        return sb.toString();
    }

    public int sumOfBeautyOfSubstring(String s){
        
    }




    public static void main(String[] args) {
        StringMediumHard obj = new StringMediumHard();
        String s = "abc";
        String result = obj.totalSubstring(s);
        System.out.println("Total substrings of '" + s + "' is: " + result + " and the total number of substrings is " + result.split(",").length);
    }
}

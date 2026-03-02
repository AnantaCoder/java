public class StringBasic{
    // concatination is possible 
     public static void print(String text){
     System.out.println(text);
     }
    public String basicFunctions(String s){

        // student username generator for the most of the core features in java 
        s = s.trim(); // remove whitespace
        // print("after trim :"+s);
        s.toLowerCase();
        boolean hasJava = s.contains("Java");
        print("\n contains java: "+ hasJava);

        int indexd = s.indexOf(",");
        print("index of , is "+indexd);
        String name = s.substring(0,indexd);
        print("name is  "+name);

        int nameLength = name.length();
        String username = s.substring(0,3) + "_"+s.substring(nameLength-4,nameLength-1);
        print("the user name is "+ username);

        String[] parts = s.split(",");
        print("City: " + parts[2].trim());

        s = s.replace("Python","golang");
        print(s);

        return username;

    }
    
    // remove trailing spaces 
    // triverse from last
    //get the first whitespace 
    //thats the length of last word
    public int lengthOfLastWord(String s) {

        s = s.trim();  
        int length = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) == ' '){
                break;
            }
            length++;
        }

        return length;
    }

//    smart text formatter for a chat app 
    public String formatMessage(String s ){
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();

        // remove extra spaces 
        for(int i = 0; i < n - 1; i++){
            if(sb.charAt(i) == ' ' && sb.charAt(i + 1) == ' '){
                sb.deleteCharAt(i);
                i--;
                n--;
            }
        }
        print("after removing :" + sb.toString());
        // lowercase everything 

        for(int i = 0;i<n-1;i++){
            sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
        }
        print("after lowercase :" + sb.toString());
        // capitialise first letter fo each word
            for(int i = 0; i < n; i++){
                if(i == 0 || sb.charAt(i-1) == ' '){
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                }
            }
        print("after capitalise :" + sb.toString());

        // replaces java properly 

        int index = sb.indexOf("Java");
        while(index!=-1){
            sb.replace(index, index + 4, "Golang");
            index = sb.indexOf("Java", index + 6);
        }
        print("after replacing java with golang  :" + sb.toString());
        // reverse 
        // sb.reverse();
        // print("after reverse :" + sb.toString());
        // final output 
        // tell me what else we can do with this string builder class in java
        // manual reverse 
        StringBuilder reversed = new StringBuilder();
        for(int i=sb.length()-1;i>=0;i--){
            reversed.append(sb.charAt(i));
        }
        print("after manual reverse :" + reversed.toString());

        boolean isPalindrome = false;
        // is this string palindrome or not 
        
         if(reversed.toString().equals(sb.toString())){
            isPalindrome = true;
         }
        print("is palindrome : "+ isPalindrome);
//substring in the string builder
            String sub = sb.substring(0, 10);
            print("substring : "+ sub);

        return sb.toString();

    }
    public String reverseWords(String s) {

        StringBuilder reversed = new StringBuilder();
        String[] words = s.trim().split("\\s+"); 
        int n = words.length;
        for(int i= n-1;i>=0;i--){
            reversed.append(words[i]);
            if(i>0) reversed.append(" ");
        }
        
        return reversed.toString();
    }



     public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        for(int i = 0 ;i< s.length();i++){
        String re = s.substring(0,i) + s.substring(i+1);
        if(re.equals(t)) return true;
        }


        return false;
    }

    public String frequencySort451(String s ){
        int[] freq = new int[256];
        for(int i = 0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }

        StringBuilder sb  = new StringBuilder();

        for(int i = 0;i<256;i++){
            for(int j = 0;j<freq[i];j++){
                sb.append((char)i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] main){
       
        // System.out.println(((Object)s.length()).getClass()); // to get the what type of shit this is 
        // java.lang.integer is the output in this 
        // String builder are fazt and mutable , regular string is mutable in java 
        // StringBuilder sb - 

        String s = "   Anirban  Sarkar , 21, Kolkata, loves Java and Python and wanna be a dj in Mayami   ";
        StringBasic obj = new StringBasic();
        // obj.basicFunctions(s);
        String sb = "  this is    a    java program     this is a    a new form of a    java ! and    i love golang ;";
        // obj.formatMessage(sb);

        String reversed = obj.reverseWords(sb);
        // System.out.println("Reversed words: " + reversed);

        String str = "anagram";
        String t = "nagaram";
        boolean isAnagram = obj.isAnagram(str, t);
        System.out.println("Is anagram: " + isAnagram);

    }
}
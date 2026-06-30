package String;

import java.util.*;

public class StringHard {
    public List<Integer> findSubstring(String s, String[] words) {

        // int[] freq = new int[window];
        // int left = 0 ;
        // List<Integer> list = new ArrayList<>();

        // for(int right=0;right<s.length();right++){
        // freq[s.charAt(right)-'a']++;

        // if (right<window) {
        // continue;
        // }
        // while (condition) {

        // }
        // }

       List<Integer> list = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return list;

        int wordLength = words[0].length();
        int window = wordLength * words.length;

        if (s.length() < window)
            return list;

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Optimization: all words are the same
        Set<String> set = new HashSet<>(Arrays.asList(words));

        if (set.size() == 1) {

            String target = words[0].repeat(words.length);

            for (int i = 0; i <= s.length() - target.length(); i++) {

                if (s.startsWith(target, i)) {
                    list.add(i);
                }
            }

            return list;
        }

        // Brute Force
        for (int i = 0; i <= s.length() - window; i++) {

            Map<String, Integer> seen = new HashMap<>();

            int j;

            for (j = 0; j < words.length; j++) {

                int start = i + j * wordLength;

                String current = s.substring(start, start + wordLength);

                if (!map.containsKey(current))
                    break;

                seen.put(current, seen.getOrDefault(current, 0) + 1);

                if (seen.get(current) > map.get(current))
                    break;
            }

            if (j == words.length)
                list.add(i);
        }

        return list;

    }

    public static void main(String[] args) {
        StringHard obj = new StringHard();

        Scanner sc = new Scanner(System.in);

    }
}

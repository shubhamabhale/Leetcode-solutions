import java.util.*;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> hmap = new HashMap<>();

        for (String str : strings) {
            StringBuilder sb = new StringBuilder();
            int sum = 0;
            int prev = str.charAt(0) - 'a';

            for (char ch : str.toCharArray()) {
                int current = ch - 'a';
                int diff = current - prev;
                if (diff < 0) {
                    diff += 26; // Wrap around for negative differences
                }
                sb.append(diff).append("#");
                prev = current;
                sum += diff;
            }

            String keyStr = sum + "_" + str.length();
            hmap.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : hmap.values()) {
            result.add(group);
        }

        return result;
    }
}

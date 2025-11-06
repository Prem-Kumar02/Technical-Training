import java.util.HashSet;
public class removeDuplicates {
  public static String removeDuplicates(String s) {
        HashSet<Character> exists = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!exists.contains(c)) {
                ans.append(c);
                exists.add(c);
            }
        }
        
        return ans.toString();
    }
}

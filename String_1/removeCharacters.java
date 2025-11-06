class Solution {
    public String removeNonAlphabets(String s) {
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                result.append(c);
            }
        }
        return result.toString();
    }
}

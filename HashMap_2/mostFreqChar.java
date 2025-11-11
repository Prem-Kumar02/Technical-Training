class Solution {
    public char getMaxOccuringChar(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int max = -1;
        char ans = 'a';

        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                ans = (char)(i + 'a');
            }
        }

        return ans;
        
    }
}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int start = 0;
        int[] lastSeen = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (lastSeen[ch] > start) {
                start = lastSeen[ch];
            }

            max = Math.max(max, i - start + 1);
            lastSeen[ch] = i + 1;
        }

        return max;
    }
}

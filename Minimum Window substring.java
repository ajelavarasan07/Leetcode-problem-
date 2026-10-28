
class Solution {
    public String minWindow(String s, String t) {
        int[] count = new int[128];

        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int left = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        int required = t.length();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (count[c] > 0) {
                required--;
            }
            count[c]--;

            while (required == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char ch = s.charAt(left);
                count[ch]++;

                if (count[ch] > 0) {
                    required++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? "" : s.substring(start, start + minLen);
    }
}

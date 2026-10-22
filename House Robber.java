class Solution {
    public int rob(int[] nums) {
        int previous = 0;
        int current = 0;

        for (int money : nums) {
            int temp = Math.max(current, previous + money);
            previous = current;
            current = temp;
        }

        return current;
    }
}

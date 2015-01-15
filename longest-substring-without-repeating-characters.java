public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] last_loc = new int[256];
        int idx = -1, max = 0;
        int LL = s.length();
        Arrays.fill(last_loc, -1);
        for (int i = 0; i < LL; i++) {
            int s_i = s.charAt(i);
            if (last_loc[s_i] > idx)
                idx = last_loc[s_i];
            if (i - idx > max)
                max = i - idx;
            last_loc[s_i] = i;
        }
        return max;
    }
}
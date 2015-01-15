class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        last_loc = [-1] * 256 # 256 characters
        maxL, idx = 0, -1
        for i, s_i in enumerate(s):
            ord_i = ord(s_i)
            if last_loc[ord_i] > idx:
                idx = last_loc[ord_i]
            if i - idx > maxL:
                maxL = i - idx
            last_loc[ord_i] = i
        return maxL

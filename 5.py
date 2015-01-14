class Solution:
    # @return a string
    def longestPalindrome(self, s):
        LL = len(s)
        if LL < 3:
            return s
        maxL, maxB = 1, 0 # init as one char
        # odd length: 3, 5, ...
        for i in range(1, LL - 1): # select center point
            n = min(i, LL - i - 1) # upper bound of j
            j = 1
            while j <= n and s[i - j] == s[i + j]: j += 1
            j -= 1
            L = 2 * j + 1
            B = i - j
            if L > maxL:
                maxL = L
                maxB = B
        # even length: 2, 4, ...
        for i in range(0, LL - 1): # select center(left) point
            n = min(i, LL - i - 2) # upper bound of j
            j = 0
            while j <= n and s[i - j] == s[i + j + 1]: j += 1
            L = 2 * j
            B = i - j + 1
            if L > maxL:
                maxL = L
                maxB = B
        return s[maxB: maxB + maxL]

class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        ret = True
        # Return false on negitive
        if x < 0:
            return False
        # Count bits -> LL
        LL, tmp = 0, x
        while tmp > 0:
            LL += 1
            tmp /= 10
        if LL <= 1:
            return True
        # Check Palindrome
        for i in range(0, LL / 2 + 1):
            a, b = x, x
            for j in range(0, i): a /= 10
            for j in range(0, LL - 1 - i): b /= 10
            if (a % 10 != b % 10):
                ret = False
                break
        return ret
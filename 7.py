class Solution:
    # @return an integer
    def reverse(self, x):
        neg = x < 0
        ret = 0
        INT_MAX = 2147483647
        INT_MAX_10 = INT_MAX / 10
        if neg: x = -x
        while x > 0:
            tmp = x % 10
            x /= 10
            if ret > INT_MAX_10:
                return 0
            ret *= 10
            if ret > INT_MAX - tmp:
                return 0
            ret += tmp
        if neg: ret = -ret
        return ret
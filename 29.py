class Solution:
    # @return an integer
    def divide(self, dividend, divisor):
        dividendSign = 1 if dividend >= 0 else -1
        divisorSign = 1 if divisor >= 0 else -1
        dividendAbs = abs(dividend)
        divisorAbs = abs(divisor)
        result = 0
        lim, i = 0, 0
        ds = [divisorAbs] * 32
        # compute ds[i] = divisorAbs << i
        for i in range(1, 32):
            ds[i] = ds[i - 1] << 1
            if dividendAbs < ds[i]: break
        #
        while i >= 0 and dividendAbs > 0:
            if dividendAbs >= ds[i]:
                result |= (1 << i)
                dividendAbs -= ds[i]
            i -= 1
        #
        if dividendSign * divisorSign < 0:
            ret = max(-result, -(2**31))
        else:
            ret = min(result, 2**31 - 1)
        return ret
class Solution:
    # @return a string
    def convert(self, s, nRows):
        LL = len(s)
        if LL <= nRows or nRows == 1: # Too short input string
            return s
        ret = [' '] * LL
        idx, i = 0, 0
        # 0 th row
        row = 0
        for idx in range(row, LL, 2 * (nRows - 1)):
            ret[i] = s[idx]
            i += 1
        # 1...nRows-2 th rows
        for row in range(1, nRows - 1):
            idx = row
            while idx < LL:
                ret[i] = s[idx]
                i += 1
                idx += 2 * (nRows - row - 1)
                if idx >= LL: break
                ret[i] = s[idx]
                i += 1
                idx += 2 * row
        # last row
        row = nRows - 1
        for idx in range(row, LL, 2 * (nRows - 1)):
            ret[i] = s[idx]
            i += 1
        return ''.join(ret)
class Solution:
    # @param an integer
    # @return a list of string
    def generateParenthesis(self, n):
        lStr = ['']
        lLeft, lRight = [0], [0]
        for i in range(2 * n):
            L = len(lStr)
            lStr1, lStr = lStr, []
            lLeft1, lLeft = lLeft, []
            lRight1, lRight = lRight, []
            for j in range(L):
                x = lStr1[j]
                nLeft = lLeft1[j]
                nRight = lRight1[j]
                if nRight < nLeft:
                    lStr.append(x + ')')
                    lLeft.append(nLeft)
                    lRight.append(nRight + 1)
                if nLeft < n:
                    lStr.append(x + '(')
                    lLeft.append(nLeft + 1)
                    lRight.append(nRight)
        return lStr
class Solution:
    # @return a list of strings, [s1, s2]
    def letterCombinations(self, digits):
        arrNum = [1, 1, 3, 3, 3, 3, 3, 4, 3, 4]
        arrChs = [' ', ' ', 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w']
        ret = ['']
        for c in digits:
            num = int(c)
            tmp = ret[:]
            ret = []
            for i in range(arrNum[num]):
                ch = chr(ord(arrChs[num]) + i)
                for t in tmp:
                    ret.append(t + ch)
        return ret
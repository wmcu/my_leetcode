class Solution:
    romanChar = { 'I': 1, 'V': 5, 'X': 10, 'L':50,
                  'C':100, 'D':500, 'M':1000 }
    # @return an integer
    def romanToInt(self, s):
        ret = 0
        prevBit = 100000
        for c in s:
            thisBit = self.romanChar[c]
            if thisBit <= prevBit:
                ret += thisBit
            else:
                ret -= prevBit * 2
                ret += thisBit
            prevBit = thisBit
        return ret
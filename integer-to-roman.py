class Solution:
    mRomanChar = ['I', 'V', 'X', 'L', 'C', 'D', 'M']
    # @return a string
    def intToRoman(self, num):
        romanChar = self.mRomanChar
        remain = num
        ret = []
        weight = 1000
        intInd = 6
        # [1000, 3999)
        numBit = remain / weight;
        remain = remain % weight;
        for i in range(numBit):
            ret.append(romanChar[intInd])
        weight /= 10
        intInd -= 1
        # [1, 999)
        while remain > 0:
            numBit = remain / weight
            remain = remain % weight
            if numBit >= 9:
                ret.append(romanChar[intInd - 1])
                ret.append(romanChar[intInd + 1])
            elif numBit >= 5:
                ret.append(romanChar[intInd])
                for j in range(numBit - 5):
                    ret.append(romanChar[intInd - 1])
            elif numBit == 4:
                ret.append(romanChar[intInd - 1])
                ret.append(romanChar[intInd])
            else: # numBit < 4
                for j in range(numBit):
                    ret.append(romanChar[intInd - 1])
            weight /= 10
            intInd -= 2
        return "".join(ret)

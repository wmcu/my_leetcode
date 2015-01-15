public class Solution {
    static char[] romanChar = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    //static int[] romanInt = {1, 5, 10, 50, 100, 500, 1000};
    public String intToRoman(int num) {
        int remain = num;
        StringBuffer ret = new StringBuffer(16);
        int i, j;
        int weight = 1000;
        int intInd = 6;
        // [1000, 3999)
        int numBit = remain / weight;
        remain = remain % weight;
        for (i = 0; i < numBit; i++) ret.append(romanChar[intInd]);
        weight /= 10;
        intInd -= 1;
        // [1, 999)
        while (remain > 0) {
            numBit = remain / weight;
            remain = remain % weight;
            if (numBit >= 9) {
                ret.append(romanChar[intInd - 1]);
                ret.append(romanChar[intInd + 1]);
            } else if (numBit >= 5) {
                ret.append(romanChar[intInd]);
                for (j = 0; j < numBit - 5; j++)
                    ret.append(romanChar[intInd - 1]);
            } else if (numBit == 4) {
                ret.append(romanChar[intInd - 1]);
                ret.append(romanChar[intInd]);
            } else { // numBit < 4
                for (j = 0; j < numBit; j++)
                    ret.append(romanChar[intInd - 1]);
            }
            weight /= 10;
            intInd -= 2;
        }
        return new String(ret);
    }
}
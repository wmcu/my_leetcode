public class Solution {
    int romanChar(char x) {
        int ret = 0;
        switch (x) {
            case 'I': ret = 1; break;
            case 'V': ret = 5; break;
            case 'X': ret = 10; break;
            case 'L': ret = 50; break;
            case 'C': ret = 100; break;
            case 'D': ret = 500; break;
            case 'M': ret = 1000; break;
            default: ret = 0;
        }
        return ret;
    }
    public int romanToInt(String s) {
        int LL = s.length(), i = 0;
        int ret = 0;
        int thisBit = 0, prevBit = Integer.MAX_VALUE;
        for (i = 0; i < LL; i++) {
            thisBit = romanChar(s.charAt(i));
            if (thisBit <= prevBit)
                ret += thisBit;
            else {
                ret -= prevBit * 2;
                ret += thisBit;
            }
            prevBit = thisBit;
        }
        return ret;
    }
}
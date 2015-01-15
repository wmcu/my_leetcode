public class Solution {
    public int atoi(String str) {
        int buf = 0;
        int idx = 0, LL = str.length();
        boolean neg = false;
        int tmp = 0;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MIN = Integer.MIN_VALUE;
        int INT_MAX_10 = INT_MAX / 10;
        int INT_MIN_10 = INT_MIN / 10;
        // skip space
        for (; idx < LL && str.charAt(idx) == ' '; idx++);
        // get sign
        if (idx < LL && str.charAt(idx) == '-') { // "-123"
            neg = true;
            idx++;
        } else if (idx < LL && str.charAt(idx) == '+') { // '+123'
            idx++;
        }
        // handle numbers
        if (neg) {
            for (; idx < LL && Character.isDigit(str.charAt(idx)); idx++) {
                if (buf < INT_MIN_10) {
                    buf = INT_MIN;
                    break;
                }
                buf *= 10;
                tmp = -Character.digit(str.charAt(idx), 10);
                if (buf < INT_MIN - tmp) {
                    buf = INT_MIN;
                    break;
                }
                buf += tmp;
            }
        } else {
            for (; idx < LL && Character.isDigit(str.charAt(idx)); idx++) {
                if (buf > INT_MAX_10) {
                    buf = INT_MAX;
                    break;
                }
                buf *= 10;
                tmp = Character.digit(str.charAt(idx), 10);
                if (buf > INT_MAX - tmp) {
                    buf = INT_MAX;
                    break;
                }
                buf += tmp;
            }
        }
        return buf;
    }
}
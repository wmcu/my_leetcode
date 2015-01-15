public class Solution {
    public int reverse(int x) {
        boolean neg = x < 0;
        int ret = 0;
        int INT_MAX = Integer.MAX_VALUE;
        int INT_MAX_10 = INT_MAX / 10;
        int tmp;
        if (neg) x = -x;
        while (x > 0) {
            tmp = x % 10;
            x /= 10;
            if (ret > INT_MAX_10)
                return 0;
            ret *= 10;
            if (ret > INT_MAX - tmp)
                return 0;
            ret += tmp;
        }
        if (neg) ret = -ret;
        return ret;
    }
}
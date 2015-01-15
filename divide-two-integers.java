public class Solution {
    public int divide(int dividend, int divisor) {
        int dividendSign = dividend >= 0 ? 1 : -1;
        int divisorSign = divisor >= 0 ? 1 : -1;
        long dividendAbs = Math.abs((long)dividend);
        long divisorAbs = Math.abs((long)divisor);
        int ret = 0;
        long result = 0;
        int i, lim = 0;
        long[] ds = new long[32];
        // compute ds[i] = divisorAbs << i
        ds[0] = divisorAbs;
        for (i = 0; i < 32 - 1 && ds[i] <= dividendAbs; i++)
            ds[i + 1] = ds[i] << 1;
        lim = i;
        //
        for (i = lim; i >= 0 && dividendAbs > 0; i--) {
            if (dividendAbs >= ds[i]) {
                result |= ((long)1 << i);
                dividendAbs -= ds[i];
            }
        }
        if (dividendSign * divisorSign < 0)
            ret = (int)Math.max(-result, (long)Integer.MIN_VALUE);
        else
            ret = (int)Math.min(result, (long)Integer.MAX_VALUE);
        return ret;
    }
}
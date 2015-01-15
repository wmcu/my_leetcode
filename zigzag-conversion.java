public class Solution {
    public String convert(String s, int nRows) {
        int LL = s.length();
        if (LL <= nRows || nRows == 1) // Too short input string
            return s;
        char[] ret = new char[LL];
        String retn;
        int idx = 0, i = 0;
        // 0 th row
        int row = 0;
        for (idx = row; idx < LL; idx += 2 * (nRows - 1))
            ret[i++] = s.charAt(idx);
        // 1...nRows-2 th rows
        for (row = 1; row < nRows - 1; row++) {
            for (idx = row; idx < LL; ) {
                ret[i++] = s.charAt(idx);
                idx += 2 * (nRows - row - 1);
                if (idx >= LL) break;
                ret[i++] = s.charAt(idx);
                idx += 2 * row;
            }
        }
        // last row
        for (idx = row; idx < LL; idx += 2 * (nRows - 1))
            ret[i++] = s.charAt(idx);
        retn = new String(ret);
        return retn;
    }
}
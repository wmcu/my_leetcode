public class Solution {
    boolean match(char p, char s) {
        return p == '.' || p == s;
    }
    public boolean isMatch(String s, String p) {
        int ns = s.length(), np = p.length();
        boolean[][] m = new boolean[ns + 1][np + 1];
        // m[i][j] - if s[0:i] match p[0:j]
        for (int i = 0; i <= ns; i++)
            m[i][0] = (i == 0);
        for (int j = 1; j <= np; j++) {
            if (p.charAt(j - 1) == '*')
                m[0][j] = m[0][j - 2];
            else
                m[0][j] = false;
        }
        for (int i = 1; i <= ns; i++) {
            for (int j = 1; j <= np; j++) {
                char s_i_1 = s.charAt(i - 1);
                char p_i_1 = p.charAt(j - 1);
                if (p_i_1 != '*') {
                    m[i][j] = match(p_i_1, s_i_1) && m[i - 1][j - 1];
                } else {
                    // * - 0 or one more
                    m[i][j] = m[i][j - 2] || (match(p.charAt(j - 2), s_i_1) && m[i - 1][j]);
                }
            }
        }
        return m[ns][np];
    }
}
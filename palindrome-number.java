public class Solution {
    public boolean isPalindrome(int x) {
        int LL, tmp, i;
        boolean ret = true;
        // Return false on negitive
        if (x < 0)
            return false;
        // Count bits
        for (LL = 0, tmp = x; tmp > 0; LL++, tmp /= 10);
        if (LL <= 1)
            return true;
        // Check Palindrome
        for (i = 0; i <= LL / 2; i++) {
            int a = x, b = x;
            for (int j = 0; j < i; j++) a/=10;
            for (int j = 0; j < LL-1-i; j++) b/=10;
            if (a % 10 != b % 10) {
                ret = false;
                break;
            }
        }
        return ret;
    }
}
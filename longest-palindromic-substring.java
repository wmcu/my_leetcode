public class Solution {
    public String longestPalindrome(String s) {
		int LL = s.length();
		int i, j, n;
		int maxL = 1, maxB = 0; // init as one char
		int L, B;
		if (LL<3)
			return s;
		// odd length: 3, 5, ...
		for (i = 1; i < LL - 1; i++) { // select center point
			n = Math.min(i, LL - i - 1); // upper bound of j
			for (j = 1; j <= n && s.charAt(i - j) == s.charAt(i + j); j++);
			j--;
			L = 2 * j + 1;
			B = i-j;
			if (L > maxL) {
				maxL = L;
				maxB = B;
			}
		}
		// even length: 2, 4, ...
		for (i = 0; i < LL - 1; i++) { // select center(left) point
			n = Math.min(i, LL - i - 2); // upper bound of j
			for (j = 0; j <= n && s.charAt(i - j) == s.charAt(i + j + 1); j++);
			L = 2 * j;
			B = i - j + 1;
			if (L > maxL) {
				maxL = L;
				maxB = B;
			}
		}
		return s.substring(maxB, maxB + maxL);
    }
}
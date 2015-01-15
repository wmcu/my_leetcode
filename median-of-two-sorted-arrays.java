public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length, n = B.length;
        int mid = (m + n) / 2;
        double ret = 0.0;
        boolean odd = (mid * 2 != (m + n)); // Total length is odd number
        int i = 0, j = 0, k = 0;
        int stack[] = {0, 0};
        int stack_i = -1;
        for (; i < m && j < n && k <= mid; k++) {
            if (A[i] < B[j]) {
                stack_i = (stack_i + 1) % 2;
                stack[stack_i] = A[i];
                i++;
            }
            else {
                stack_i = (stack_i + 1) % 2;
                stack[stack_i] = B[j];
                j++;
            }
        }
        if (k != mid + 1) {
            if (i == m) {
                for (; j < n && k <= mid; k++) {
                    stack_i = (stack_i + 1) % 2;
                    stack[stack_i] = B[j];
                    j++;
                }
            }
            else { // j==n
                for (; i < m && k <= mid; k++) {
                    stack_i = (stack_i + 1) % 2;
                    stack[stack_i] = A[i];
                    i++;
                }
            }
        }
        if (odd)
            ret = stack[stack_i];
        else
            ret = stack[0] + 0.5 * (stack[1] - stack[0]);
        return ret;
    }
}
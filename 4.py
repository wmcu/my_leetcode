class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        m, n = len(A), len(B)
        mid = (m + n) / 2
        odd = (mid * 2 != (m + n))
        i, j, k = 0, 0, 0
        stack = [0, 0]
        stack_i = -1
        while i < m and j < n and k <= mid:
            if A[i] < B[j]:
                stack_i = (stack_i + 1) % 2;
                stack[stack_i] = A[i];
                i += 1
            else:
                stack_i = (stack_i + 1) % 2;
                stack[stack_i] = B[j];
                j += 1
            k += 1
        if k != mid + 1:
            if i == m:
                while j < n and k <= mid:
                    stack_i = (stack_i + 1) % 2
                    stack[stack_i] = B[j]
                    j += 1
                    k += 1
            else: # j == n
                while i < m and k <= mid:
                    stack_i = (stack_i + 1) % 2
                    stack[stack_i] = A[i]
                    i += 1
                    k += 1
        if odd:
            ret = float(stack[stack_i])
        else:
            ret = stack[0] + 0.5 * (stack[1] - stack[0])
        return ret
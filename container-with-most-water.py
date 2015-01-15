class Solution:
    # @return an integer
    def maxArea(self, height):
        maxC = 0
        LL = len(height)
        l, r = 0, LL - 1
        while (l < r):
            W = r - l
            if height[l] < height[r]:
                H = height[l]
                l += 1
            else:
                H = height[r]
                r -= 1
            C = H * W
            if C > maxC:
                maxC = C
        return maxC
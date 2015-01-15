public class Solution {
    public int maxArea(int[] height) {
        int maxC = 0, C, H, W;
        int LL = height.length;
        int l = 0, r = LL - 1;
        while (l < r) {
            W = r - l;
            if (height[l] < height[r]) {
                H = height[l];
                l++;
            } else {
                H = height[r];
                r--;
            }
            C = H * W;
            if (C > maxC)
                maxC = C;
        }
        return maxC;
    }
}
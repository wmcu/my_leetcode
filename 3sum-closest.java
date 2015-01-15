public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int ret = 0;
		int LL = num.length;
		int tmp, goal, diff, sum;
		int minDiff = 0;
		boolean flag = false;
		int i, j, k, g;
		// sort num
		Arrays.sort(num);
		// search
		for (i = 0; i < LL - 2; i++) {
		    goal = target - num[i];
			for (j = i + 1, k = LL - 1; j < k; ) {
				tmp = num[j] + num[k];
				sum = num[i] + tmp;
				if (tmp > goal) {
				    diff = tmp - goal;
				    k--;
				} else if (tmp < goal) {
				    diff = goal - tmp;
				    j++;
				} else { // diff = 0
				    return target;
				}
				if (!flag || diff < minDiff) {
				    minDiff = diff;
				    ret = sum;
				    flag = true;
				}
			}
		}
		return ret;
    }
}
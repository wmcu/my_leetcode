public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> vec4;
		int LL = num.length;
		// sort num
		Arrays.sort(num);
		// search
		boolean flag = false;
		int tmp_0 = 0, tmp_1 = 0, tmp_l = 0, tmp_r =0;
		int i, j, k, m;
		for (i = 0; i < LL - 3; i++) {
		    if ( i > 0 && num[i] == num[i - 1]) continue;
		    for (m = i + 1; m < LL - 2; m++) {
		        if ( m > i + 1 && num[m] == num[m - 1]) continue;
    		    if (flag && num[i] == tmp_0 && num[m] == tmp_1) // avoid duplicate
    		        continue;
    			tmp_0 = num[i]; tmp_1 = num[m];
    			flag = false;
    			for (j = m + 1, k = LL - 1; j < k; ) {
    			    if (flag && num[j] == tmp_l && num[k] == tmp_r) {
    			        j++; // avoid duplicate
    			        k--;
    			        continue;
    			    }
                    if (num[j] + num[k] > target - tmp_0 - tmp_1)
    			        k--;
    			    else if (num[j] + num[k] < target - tmp_0 - tmp_1)
    			        j++;
    			    else {
    			        flag = true;
    			        tmp_l = num[j];
    			        tmp_r = num[k];
    			        vec4 = new ArrayList<Integer>(4);
    			        vec4.add(tmp_0); vec4.add(tmp_1); vec4.add(tmp_l); vec4.add(tmp_r);
    			        ret.add(vec4);
    			        j++;
    			        k--;
    			    }
    			}
		    }
		}
		return ret;
    }
}
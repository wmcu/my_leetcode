class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> vec3;
		int LL = num.length;
		// abnormal case - less than 3 elements
		if (LL < 3)
			return ret;
		// sort num
		int[] s_num = num.clone();
		Arrays.sort(s_num);
		// brute force
		boolean flag = false;
		int tmp_0 = 0, tmp_l = 0, tmp_r =0;
		int i, j, k;
		for (i = 0; i < LL - 2; i++) {
		    if (flag && s_num[i] == tmp_0) // avoid duplicate
		        continue;
			tmp_0 = s_num[i];
			flag = false;
			for (j = i + 1, k = LL - 1; j < k; ) {
			    if (flag && s_num[j] == tmp_l && s_num[k] == tmp_r) {
			        j++; // avoid duplicate
			        k--;
			        continue;
			    }
                if (s_num[j] + s_num[k] > 0 - tmp_0)
			        k--;
			    else if (s_num[j] + s_num[k] < 0 - tmp_0)
			        j++;
			    else {
			        flag = true;
			        tmp_l = s_num[j];
			        tmp_r = s_num[k];
			        vec3 = new ArrayList<Integer>(3);
			        vec3.add(tmp_0); vec3.add(tmp_l); vec3.add(tmp_r);
			        ret.add(vec3);
			        j++;
			        k--;
			    }
			}
		}
		return ret;
    }
}
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] result = {0, 0};
    	int i, idx;
    	int LL = numbers.length;
    	int num_i, goal;
    	for (i = 0; i < LL; i++) {
    	    num_i = numbers[i];
    	    goal = target - num_i;
    		if (map.containsKey(goal)) { // found
    			idx = map.get(goal);
    			result[0] = idx + 1;
    			result[1] = i + 1;
    			break;
    		}
    		// not found
			map.put(num_i, i);
    	}
    	return result;
    }
}
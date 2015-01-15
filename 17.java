public class Solution {
    int[] arrNum = {1, 1, 3, 3, 3, 3, 3, 4, 3, 4};
    char[] arrChs = {' ', ' ', 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> tmp;
        int L = digits.length();
        int num, LL;
        int i, j, k;
        char ch;
        ret.add("");
        for (k = 0 ; k < L; k++) { // traversal of digits
            num = Character.digit(digits.charAt(k), 10); // current number
            tmp = new ArrayList<String>(ret);
            LL = tmp.size();
            ret.clear();
            for (i = 0; i < arrNum[num]; i++) {
                ch = (char)(arrChs[num] + i);
                for (j = 0; j < LL; j++) {
                    String t = tmp.get(j);
                    ret.add(t + ch);
                }
            }
        }
        return ret;
    }
}
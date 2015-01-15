public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> lStr = new ArrayList<String>(), lStr1;
        List<Integer> lLeft = new ArrayList<Integer>(), lLeft1;
        List<Integer> lRight = new ArrayList<Integer>(), lRight1;
        int nLeft = 0, nRight = 0, i, j, len;
        String x;
        lStr.add(""); lLeft.add(0); lRight.add(0);
        for (i = 0; i < n * 2; i++) {
            len = lStr.size();
            lStr1 = lStr;
            lStr = new ArrayList<String>(len);
            lLeft1 = lLeft;
            lLeft = new ArrayList<Integer>(len);
            lRight1 = lRight;
            lRight = new ArrayList<Integer>(len);
            for (j = 0; j < len; j++) {
                x = lStr1.get(j);
                nLeft = lLeft1.get(j);
                nRight = lRight1.get(j);
                if (nRight < nLeft) {
                    lStr.add(x + ')');
                    lLeft.add(nLeft);
                    lRight.add(nRight + 1);
                }
                if (nLeft < n) {
                    lStr.add(x + '(');
                    lLeft.add(nLeft + 1);
                    lRight.add(nRight);
                }
            }
        }
        return lStr;
    }
}
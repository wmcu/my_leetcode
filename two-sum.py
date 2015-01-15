class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        s_num = sorted(num)
        LL = len(num)
        # find num[index1] & num[index2]
        i = 0
        j = LL - 1
        while i < j:
            s = s_num[i] + s_num[j]
            if s > target:
                j -= 1
            elif s < target:
                i += 1
            else: # s==target
                a = s_num[i]
                b = s_num[j]
                break
        # find index1 & index2
        for i, x in enumerate(num):
            if x == a:
                index1 = i
                break
        for i, x in enumerate(num[::-1]):
            if x == b:
                index2 = LL - 1 - i
                break
        # make sure index1 < index2
        if index1 < index2:
            ret = (index1 + 1, index2 + 1)
        else:
            ret = (index2 + 1, index1 + 1)
        return ret
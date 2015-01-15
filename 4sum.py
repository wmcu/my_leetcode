class Solution:
    # @return a list of lists of length 4, [[val1,val2,val3,val4]]
    def fourSum(self, num, target):
        ret = []
        LL = len(num)
        # sort num
        num.sort()
        # search
        flag = False
        tmp_0, tmp_1, tmp_l, tmp_r = 0, 0, 0, 0
        for i in range(LL - 3):
            if i > 0 and num[i] == num[i - 1]: continue
            for m in range(i + 1, LL - 2):
                if m > i + 1 and num[m] == num[m - 1]: continue
                #if flag and num[i] == tmp_0 and num[m] == tmp_1:
                #    continue # avoid duplicate
                tmp_0, tmp_1 = num[i], num[m]
                flag = False
                j, k = m + 1, LL - 1
                while j < k:
                    if flag and num[j] == tmp_l and num[k] == tmp_r:
                        j += 1
                        k -= 1
                        continue # avoid duplicate
                    if num[j] + num[k] > target - tmp_0 - tmp_1:
                        k -= 1
                    elif num[j] + num[k] < target - tmp_0 - tmp_1:
                        j += 1
                    else:
                        flag = True
                        tmp_l, tmp_r = num[j], num[k]
                        ret.append([tmp_0, tmp_1, tmp_l, tmp_r])
                        j += 1
                        k -= 1
        return ret

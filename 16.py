class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        ret = 0
        LL = len(num)
        min_diff = 0
        flag = False
        # sort num
        num.sort()
        # search
        for i in range(LL - 2):
            goal = target - num[i]
            j, k = i + 1, LL - 1
            while j < k:
                tmp = num[j] + num[k]
                sum3 = num[i] + tmp
                if tmp > goal:
                    diff = tmp - goal
                    k -= 1
                elif tmp < goal:
                    diff = goal - tmp
                    j += 1
                else: # tmp == goal
                    return target
                if not flag or diff < min_diff:
                    min_diff = diff
                    ret = sum3
                    flag = True
        return ret
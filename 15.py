class Solution:
	# @return a list of lists of length 3, [[val1,val2,val3]]
	def threeSum(self, num):
		ret = []
		LL = len(num)
		# abnormal case - less than 3 elements
		if LL < 3: return ret
		# sort num
		s_num = sorted(num)
		# search
		flag = False
		tmp_0, tmp_, tmp_r = 0, 0, 0
		for i in range(LL - 2):
			if flag and s_num[i] == tmp_0: # avoid duplicate
				continue
			tmp_0 = s_num[i]
			flag = False
			j, k = i + 1, LL - 1
			while j < k:
				# avoid duplicate
				if flag and s_num[j] == tmp_l and s_num[k] == tmp_r:
					j += 1
					k -= 1
					continue
				# two pointer search
				if s_num[j] + s_num[k] > 0 - tmp_0:
					k -= 1
				elif s_num[j] + s_num[k] < 0 - tmp_0:
					j += 1
				else:
					flag = True
					tmp_l = s_num[j]
					tmp_r = s_num[k]
					ret.append([tmp_0, tmp_l, tmp_r])
					j += 1
		return ret
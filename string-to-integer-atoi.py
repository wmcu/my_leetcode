class Solution:
    # @return an integer
    def atoi(self, str):
        buf = 0
        idx = 0
        neg = False
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        INT_MAX_10 = INT_MAX / 10
        INT_MIN_10 = INT_MIN / 10
        # skip space
        str = str.strip()
        LL = len(str)
        if LL <= 0:
            return 0
        # get sign
        if str[idx] == '-': # "-123"
            neg = True
            idx += 1
        elif str[idx] == '+' : # '+123'
            idx += 1
        # handle numbers
        if neg:
            while idx < LL and '0' <= str[idx] <= '9':
                if buf < INT_MIN_10:
                    buf = INT_MIN
                    break
                buf *= 10
                tmp = -int(str[idx])
                if buf < INT_MIN - tmp:
                    buf = INT_MIN
                    break
                buf += tmp
                idx += 1
        else:
            while idx < LL and '0' <= str[idx] <= '9':
                if buf > INT_MAX_10:
                    buf = INT_MAX
                    break
                buf *= 10
                tmp = int(str[idx])
                if buf > INT_MAX - tmp:
                    buf = INT_MAX
                    break
                buf += tmp
                idx += 1
        return buf

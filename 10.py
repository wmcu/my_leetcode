class Solution:
    # @return a boolean
    def match(self, a, b):
        return a == '.' or a == b

    # @return a boolean
    def isMatch(self, s, p):
        ns, np = len(s), len(p)
        m = [[True for x in range(np + 1)] for x in range(ns + 1)]
        # m[i][j] - if s[0:i] match p[0:j]
        for i in range(ns + 1):
            m[i][0] = i == 0
        for j in range(1, np + 1):
            if (p[j - 1] == '*'):
                m[0][j] = m[0][j - 2]
            else:
                m[0][j] = False
        for i in range(1, ns + 1):
            for j in range(1, np + 1):
                if (p[j - 1] != '*'):
                    m[i][j] = self.match(p[j - 1], s[i - 1]) and m[i - 1][j - 1]
                else:
                    # * - 0 or one more
                    m[i][j] = m[i][j - 2] or (self.match(p[j - 2], s[i - 1]) and m[i - 1][j])
        return m[ns][np]

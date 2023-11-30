class Solution:
    def __init__(self):
        self.maxcount = float('inf')

    def recurse(self, s, start, end, k, count):
        if end >= len(s):
            self.maxcount = min(self.maxcount, count)
            return

        subst = s[start:end + 1]
        digits = str(k)

        if len(subst) <= len(digits) and int(subst) <= k:
            self.recurse(s, start, end + 1, k, count)
        else:
            subst = s[end]
            if int(subst) > k:
                return
            self.recurse(s, end, end + 1, k, count + 1)

    def minimumPartition(self, s, k):
        self.recurse(s, 0, 0, k, 1)
        return self.maxcount if self.maxcount != float('inf') else -1



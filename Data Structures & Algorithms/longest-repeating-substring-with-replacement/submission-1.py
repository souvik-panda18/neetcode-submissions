class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {}
        res = 0
        left = 0
        max_freq = 0

        for right, char in enumerate(s):
            count[char] = count.get(char, 0) + 1
            max_freq = max(max_freq, count[char])

            # If the current window size minus the frequency of the 
            # most frequent character is greater than k, shrink the window
            if (right - left + 1) - max_freq > k:
                count[s[left]] -= 1
                left += 1

            res = max(res, right - left + 1)

        return res
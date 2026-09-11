class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""

        for s in strs:
            res += str(len(s)) + "#" + s

        return res

    def decode(self, s: str) -> List[str]:
        res = []
        i = 0

        while i < len(s):
            j = i

            # Find the '#'
            while s[j] != "#":
                j += 1

            # Length of the next word
            length = int(s[i:j])

            # Move past '#'
            j += 1

            # Extract the word
            res.append(s[j:j + length])

            # Move to the beginning of the next encoded word
            i = j + length

        return res
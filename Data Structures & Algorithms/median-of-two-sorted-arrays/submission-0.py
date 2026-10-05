class Solution:
    def findMedianSortedArrays(self, nums1: list[int], nums2: list[int]) -> float:
        A, B = nums1, nums2
        total = len(nums1) + len(nums2)
        half = (total + 1) // 2

        # Ensure A is the smaller array to optimize binary search range
        if len(A) > len(B):
            A, B = B, A

        l, r = 0, len(A)
        while l <= r:
            i = (l + r) // 2  # partition index for A
            j = half - i  # partition index for B

            # Boundary values with infinity for out-of-bounds cases
            Aleft = A[i - 1] if i > 0 else float("-inf")
            Aright = A[i] if i < len(A) else float("inf")
            Bleft = B[j - 1] if j > 0 else float("-inf")
            Bright = B[j] if j < len(B) else float("inf")

            # Check if partition is valid
            if Aleft <= Bright and Bleft <= Aright:
                # Odd length: median is max of left elements
                if total % 2 != 0:
                    return max(Aleft, Bleft)
                # Even length: median is average of middle elements
                return (max(Aleft, Bleft) + min(Aright, Bright)) / 2.0
            elif Aleft > Bright:
                r = i - 1  # Too many elements from A
            else:
                l = i + 1  # Too few elements from A
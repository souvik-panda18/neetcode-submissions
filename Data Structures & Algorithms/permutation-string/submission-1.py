class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
            
        # Initialize frequency arrays for s1 and the first window of s2
        s1_count = [0] * 26
        s2_count = [0] * 26
        
        window_size = len(s1)
        
        for i in range(window_size):
            s1_count[ord(s1[i]) - ord('a')] += 1
            s2_count[ord(s2[i]) - ord('a')] += 1
            
        # Check if the first window matches
        if s1_count == s2_count:
            return True
            
        # Slide the window across s2
        left = 0
        for right in range(window_size, len(s2)):
            # Add the new character entering the window on the right
            s2_count[ord(s2[right]) - ord('a')] += 1
            
            # Remove the old character leaving the window from the left
            s2_count[ord(s2[left]) - ord('a')] -= 1
            
            left += 1
            
            # Check if current window matches s1
            if s1_count == s2_count:
                return True
                
        return False
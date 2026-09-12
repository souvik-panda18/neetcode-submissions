class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low, high = 0, len(nums) - 1
        
        while low <= high:  # Bug 2 fix: <= so single element gets checked
            mid = low + (high - low) // 2  # Bug 1 fix: safe midpoint
            
            if nums[mid] == target:
                return mid
            
            # Determine which half is normally sorted
            if nums[low] <= nums[mid]:
                # Left half [low..mid] is sorted
                if nums[low] <= target < nums[mid]:
                    high = mid - 1  # target is in the sorted left half
                else:
                    low = mid + 1   # target must be in the right half
            else:
                # Right half [mid..high] is sorted
                if nums[mid] < target <= nums[high]:
                    low = mid + 1   # target is in the sorted right half
                else:
                    high = mid - 1  # target must be in the left half
        
        return -1
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left = 0      # Buy day
        right = 1     # Sell day
        max_profit = 0
        
        while right < len(prices):
            if prices[left] < prices[right]:
                current_profit = prices[right] -prices[left]
                max_profit = max(max_profit, current_profit)
            else:
                # Found a new lower price, so shift left pointer to right
                left = right
            
            right += 1
            
        return max_profit
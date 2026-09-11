class Solution {
      public int maxProfit(int[] arr) {
        if (arr.length == 0) return 0;

        int min = arr[0];      // Minimum price so far (buy price)
        int maxProfit = 0;     // Maximum profit so far

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i]; // Found a better (lower) buy price
            } else {
                int profit = arr[i] - min; // Sell today
                if (profit > maxProfit) {
                    maxProfit = profit; // Update max profit
                }
            }
        }

        return maxProfit;
    }
}

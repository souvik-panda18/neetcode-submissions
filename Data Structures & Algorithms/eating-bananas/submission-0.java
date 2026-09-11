class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = max(piles); 
        int low = 1;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (hours(mid, piles) <= h) {
                ans = mid;
                high = mid - 1; // try smaller k
            } else {
                low = mid + 1; // k too small, increase
            }
        }

        return ans;
    }

    public int max(int[] arr) {
        int maxVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxVal) {
                maxVal = arr[i];
            }
        }
        return maxVal;
    }

    public int hours(int k, int[] arr) {
        int hour = 0;
        for (int i = 0; i < arr.length; i++) {
            hour += (arr[i] + k - 1) / k; // same as ceil(arr[i] / k)
        }
        return hour;
    }
}

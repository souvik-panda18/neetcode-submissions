class Solution {
    public int maxArea(int[] height) {
        int max_left = 0;
        int max_right = height.length - 1; // Fix: Use length - 1
        int max_area = 0; // Track the maximum area

        while (max_left < max_right) {
            int dist = max_right - max_left;
            int h = Math.min(height[max_left], height[max_right]);
            int current_area = dist * h;

            // Update max_area if current_area is greater
            max_area = Math.max(max_area, current_area);

            // Move the pointer with the shorter height
            if (height[max_left] < height[max_right]) {
                max_left++;
            } else {
                max_right--;
            }
        }

        return max_area;
    }
}

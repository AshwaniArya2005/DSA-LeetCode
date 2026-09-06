class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
            } else {
                while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                    int index = st.pop();
                    int width;
                    if (st.isEmpty()) {
                        width = i;
                    } else {
                        width = i - st.peek() - 1;
                    }
                    int area = heights[index] * width;
                    maxArea = Math.max(maxArea, area);
                    // st.pop();
                }
                st.push(i);
            }
        }
        int n = heights.length;
        while (!st.isEmpty()) {
            int index = st.pop();
            int width;
            if (st.isEmpty()) {
                width = n;
            } else {
                width = n - st.peek() - 1;
            }
            int area = heights[index] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
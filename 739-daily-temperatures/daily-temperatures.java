class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (st.isEmpty()) {
                st.push(i);
            } else {
                if (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                    while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                        result[st.peek()] = i - st.peek();
                        st.pop();
                    }
                }
                st.push(i);
            }
        }
        return result;
    }
}
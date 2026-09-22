class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> al = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int first = intervals[0][0];
        int last = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= last) {
                last = Math.max(last, intervals[i][1]);

            } else {
                int[] temp = new int[2];
                temp[0] = first;
                temp[1] = last;
                al.add(temp);
                first = intervals[i][0];
                last = intervals[i][1];
            }
        }
        int[] temp = new int[2];
        temp[0] = first;
        temp[1] = last;
        al.add(temp);
        return al.toArray(new int[0][0]);
    }
}
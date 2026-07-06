class Solution {
    public String minWindow(String s, String t) {
        int[] freq1 = new int[128];
        int[] freq2 = new int[128];

        for (int i = 0; i < t.length(); i++) {
            freq1[t.charAt(i)]++;
        }
        int l = 0;
        int mincount = Integer.MAX_VALUE;
        String ans = "";
        int start = 0;
        for (int r = 0; r < s.length(); r++) {
            freq2[s.charAt(r)]++;

            while (contain(freq1, freq2)) {
                int count = r - l + 1;
                if (count < mincount) {
                    mincount = count;
                    start = l;
                }

                freq2[s.charAt(l)]--;
                l++;
            }
        }

        return mincount == Integer.MAX_VALUE ? "" : s.substring(start, start + mincount);
    }

    private boolean contain(int[] freq1, int[] freq2) {
        for (int i = 0; i < freq1.length; i++) {
            if (freq1[i] > freq2[i]) {
                return false;
            }
        }
        return true;
    }
}
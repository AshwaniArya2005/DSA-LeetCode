class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        // int MOD = 1_000_000_007;

        for (int[] e : roads) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u])
                continue;

            for (int[] e : adj.get(u)) {
                int next = e[0];
                int w = e[1];
                long newdist = w + d;

                if (newdist < dist[next]) {
                    dist[next] = newdist;
                    ways[next] = ways[u];
                    pq.offer(new long[] { newdist, next });
                } else if (newdist == dist[next]) {
                    ways[next] = (ways[next] + ways[u]) % ((int) 1e9 + 7);
                }
            }
        }
        return ways[n - 1];
    }
}
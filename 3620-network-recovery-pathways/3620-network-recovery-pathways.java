class Solution {
    HashMap<Integer, List<int[]>> hmap;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        hmap = new HashMap<>();
        int n = online.length;
        int maxEdge = 0;
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int cost = edge[2];

            if (!online[src] || !online[dest])
                continue;

            hmap.computeIfAbsent(src, x -> new ArrayList<>()).add(new int[]{dest, cost});
            maxEdge = Math.max(maxEdge, cost);
        }
        int ans = -1;
        int left = 0, right = maxEdge;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dijkstra(mid, k, n)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    boolean dijkstra(int minEdge, long k, int n) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long costSoFar = curr[1];
            if (costSoFar > dist[node])
                continue;
            if (node == n - 1)
                return costSoFar <= k;
            List<int[]> list = hmap.get(node);
            if (list == null)
                continue;
            for (int[] next : list) {
                int nextNode = next[0];
                int edgeCost = next[1];
                if (edgeCost < minEdge)
                    continue;
                long nextCost = costSoFar + edgeCost;
                if (nextCost > k)
                    continue;
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new long[]{nextNode, nextCost});
                }
            }
        }
        return false;
    }
}
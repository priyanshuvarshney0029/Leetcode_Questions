class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
          int n = edges.length;

        int[] dist1 = bfs(edges, node1, n);
        int[] dist2 = bfs(edges, node2, n);

        int minDist = Integer.MAX_VALUE;
        int res = -1;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < minDist) {
                    minDist = maxDist;
                    res = i;
                }
            }
        }

        return res;
    }

    private int[] bfs(int[] edges, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            int next = edges[curr];

            if (next != -1 && dist[next] == -1) {
                dist[next] = dist[curr] + 1;
                q.add(next);
            }
        }

        return dist;
    }
}
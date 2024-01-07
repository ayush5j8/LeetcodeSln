class Solution {
    class Node {
        int v;
        int w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : times) {
            adj.get(e[0]).add(new Node(e[1], e[2]));
        }

        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((node1, node2) -> node1.w - node2.w);
        pq.add(new Node(k, 0));
        res[k] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.v;
            int w = node.w;
            for (Node e : adj.get(u)) {
                int v = e.v;
                int weightUV = e.w;
                if (res[u] + weightUV < res[v]) {
                    res[v] = res[u] + weightUV;
                    pq.add(new Node(v, res[v]));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (res[i] == Integer.MAX_VALUE)
                return -1;
            maxTime = Math.max(maxTime, res[i]);
        }
        return maxTime;
    }
}

class Solution {
    // phle connected components k andar each components count krke map mei daalo
    // fir size*(remaining components - size) calaculate kro each iteration mei     sabka sum krdo
    // there are 3 components with [4,1,2] elements in each
    // 4*(2+1) or 4*(7-4)
    private int find(int x, int[] parent) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x], parent);
    }

    private void union(int x, int y, int[] parent, int[] rank) {
        int parentX = find(x, parent);
        int parentY = find(y, parent);

        if (parentX == parentY)
            return;

        if (rank[parentX] < rank[parentY])
            parent[parentX] = parentY;
        else if (rank[parentX] > rank[parentY])
            parent[parentY] = parentX;
        else {
            parent[parentX] = parentY;
            rank[parentY]++;
        }
    }

    public long countPairs(int n, int[][] edges) {
        long sum = 0L;
        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int[] edge : edges)
            union(edge[0], edge[1], parent, rank);

        Map<Integer, Integer> hm = new HashMap<>();
        for (int e : parent)
            hm.put(find(e, parent), hm.getOrDefault(find(e, parent), 0) + 1);

        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            int size = e.getValue();
            sum += (long)size * (n - size);
            n -= size;
        }

        return sum;
    }
}
class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    List<List<Integer>> result;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        result = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(i, visited, i);
        }
        for(List<Integer> e : result)
        Collections.sort(e);
        return result;
    }

    private void dfs(int current, boolean[] visited, int start) {
        visited[current] = true;
        for (Integer ancestor : adj.get(current)) {
            if (!visited[ancestor]) {
                result.get(start).add(ancestor);
                dfs(ancestor, visited, start);
            }
        }
    }
}

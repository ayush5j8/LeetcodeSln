class Solution {
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        // reverse the edges
        for(int i=0;i<n;i++){
            res.add(new ArrayList<Integer>());
            adj.add(new ArrayList<Integer>());
        }

        for(int [] edge:edges)
        adj.get(edge[1]).add(edge[0]);

        for(int i=0;i<n;i++){
            boolean vis[]=new boolean[n];
            dfs(i,vis,i);
        }
        for(List<Integer> e: res)
        Collections.sort(e);
        return res;
    }
    public void dfs(int node, boolean[] vis, int start){
        vis[node]=true;
        for(int ele : adj.get(node)){
            if(!vis[ele])
            {res.get(start).add(ele);
            dfs(ele,vis,start);}
        }
    }
}
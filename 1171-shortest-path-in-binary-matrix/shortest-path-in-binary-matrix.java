class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int end = grid.length-1;
        if(grid[0][0]==1 || grid[end][end]==1)
        return -1;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<Pair> q = new LinkedList<Pair>();
        int zeroes = 0;
        boolean vis[][]=new boolean[end+1][end+1];
        q.add(new Pair(0,0));
        grid[0][0]=1;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int x = p.x;
            int y = p.y;
            zeroes = grid[x][y];
            if(x==end && y == end){
                return zeroes;
            }
            for(int i=0;i<8;i++){
                int newx=x+dx[i];
                int newy=y+dy[i];
                if(isValid(newx,newy,end)&&grid[newx][newy]==0){
                    q.add(new Pair(newx,newy));
                    grid[newx][newy] = zeroes+1;
                    if (newx == end && newy == end) {
                        return grid[end][end]; 
                    }            
                }
            }

        }       
        return -1;

    }
    public boolean isValid(int x, int y, int limits)
    {
        return x>=0&&x<=limits&&y>=0&&y<=limits;
    }
}
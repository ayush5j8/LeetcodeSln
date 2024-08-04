
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxPoints(int[][] points) {
        int max=0;
        for(int x=0;x<points.length;x++){
            HashMap<Double, Integer> hm =new HashMap<>();
            for(int y=0;y<points.length;y++){
                if(x==y)
                continue;
                double slope = Integer.MAX_VALUE;
                if(points[y][0]-points[x][0]!=0)
                slope = 1.0*(points[y][1]-points[x][1])/(points[y][0]-points[x][0]);
                hm.put(Math.abs(slope)==0.0?0.0:slope,hm.getOrDefault(slope, 0)+1);
                max=Math.max(hm.getOrDefault(slope,1), max);
                // System.out.println(slope);
            }
            //System.out.print(hm);
            //hm.clear();
        }
       //System.out.println(hm);
        return max+1;
    }
}
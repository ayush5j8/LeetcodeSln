class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res= new ArrayList<>();
        HashMap<Integer, Integer> win =new HashMap<>();
        HashMap<Integer, Integer> loss =new HashMap<>();
        
        for(int[] arr:matches){
            win.put(arr[0], win.getOrDefault(arr[0],0)+1);
            loss.put(arr[1], loss.getOrDefault(arr[1],0)-1);
        }
        // System.out.println(win);
        // System.out.println(loss);
        ArrayList<Integer> winner = new ArrayList<>();
        ArrayList<Integer> loser = new ArrayList<>();

        for(Map.Entry<Integer,Integer> e:win.entrySet()){
            if(!loss.containsKey(e.getKey()))
            winner.add(e.getKey());
        }
        for(Map.Entry<Integer,Integer> e:loss.entrySet()){
            if(e.getValue() == -1)
            loser.add(e.getKey());
        }
        Collections.sort(winner);Collections.sort(loser);
        res.add(winner);res.add(loser);
        return res;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int [] ans = new int[k];
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((entry1, entry2)->entry1.getValue()-entry2.getValue());
        for(int e : nums){
            hm.put(e, hm.getOrDefault(e, 0)+1);
        }
        
        for(Map.Entry<Integer, Integer> e : hm.entrySet()){
            if(pq.size()==k){
                if(pq.peek().getValue() < e.getValue()){
                    pq.poll();
                }
                else{
                    continue;
                }
            }
            pq.offer(e);
        }
        for(int j = k-1;j>=0;j--)
        ans[j]=pq.poll().getKey();

        return ans;
    }
}
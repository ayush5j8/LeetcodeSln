class Solution {
    public int nthUglyNumber(int n) {
        // if u multiply a ugly number by 2,3,5, it'll result in ugly number only
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        HashSet<Long> visited = new HashSet<>();
        int primes[] = new int[]{2,3,5};
        pq.offer(1L);
        visited.add(1L);
        long current = 1L;
        for(int i=0;i<n;i++){
            current = pq.poll();
            //System.out.println(i+" "+current);
            for(int j = 0;j<3;j++){
                long next = current*primes[j];
                if(!visited.contains(next)){
                    pq.offer(next);
                    visited.add(next);
                }
                
            }
        }
        return (int)current;
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // kth largest -> so minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums)
        pq.offer(i);

        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
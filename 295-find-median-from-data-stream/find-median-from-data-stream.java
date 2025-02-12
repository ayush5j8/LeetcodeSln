class MedianFinder {
    private PriorityQueue<Integer> minheap;
    private PriorityQueue<Integer> maxheap;
    public MedianFinder() {
        minheap = new PriorityQueue<Integer>((a,b)->a-b);
        maxheap = new PriorityQueue<Integer>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        //before inserting check if both are balanced i.e size(maxheap) = size(minheap) or 
        //size(maxheap) should not exceed size(minheap) by 1
        if(this.maxheap.isEmpty() || this.maxheap.peek() >= num){
            this.maxheap.offer(num);
        }
        else{
            this.minheap.offer(num);
        }

        if(this.maxheap.size() > this.minheap.size()+1){
            this.minheap.offer(this.maxheap.poll());
        }
        
        if(this.maxheap.size() < this.minheap.size()){
            this.maxheap.offer(this.minheap.poll());
        }
    }
    
    public double findMedian() {
        int size = this.minheap.size()+this.maxheap.size();
        if(size%2==0){
            return (this.maxheap.peek() + this.minheap.peek())/2.0;
        }
        else
        return this.maxheap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
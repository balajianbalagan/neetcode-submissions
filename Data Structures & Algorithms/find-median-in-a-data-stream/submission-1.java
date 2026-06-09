class MedianFinder {
    /*
    have a pq
    have nums count
    1 (median = 1)
    if(n is odd)
    median = maxheap top
    else
    median = maxheap top + minheap top /2

    when adding
    if > mean add it to the second
    if < mean add it to the first
    1 3  

    */
    PriorityQueue<Integer> first; // max heap
    PriorityQueue<Integer> second; // min heap
    int n;
    double median;
    public MedianFinder() {
        second = new PriorityQueue<>();
        first = new PriorityQueue<>(Collections.reverseOrder());
        n=0;
        median=0;
    }
    
    public void addNum(int num) {
        n++;
        if(first.isEmpty()){
            first.add(num);
            median = num;
            return;
        }
        if(num>=median){
            //put in second
            second.add(num);
        }else{
            first.add(num);
        }
        
        if(first.size()-second.size()==2){
            int f = first.poll();
            second.add(f);
        }else if(first.size()<second.size()){
            int s = second.poll();
            first.add(s);
        }
        median = findMedian();
        return;
    }
    
    public double findMedian() {
        double median = 0.0f;
        if(n%2==0){
            System.out.println(first.peek()+" "+second.peek());
            median =  (first.peek() + second.peek()) / 2.0;
            System.out.println(median);
        }else{
            median = first.peek();
        }
        return median;
    }
}

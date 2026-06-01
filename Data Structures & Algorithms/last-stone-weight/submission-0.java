class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
        6 4 3 2 2 max heap

        if its empty we return 0
        else we get stone 1
        if its empty return stone 1
        else we get stone 2

        if eq then move on to next iter
        of unq get new stone weight and add it
        nlog(n)
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int s:stones){
            pq.add(s);
        }

        while(!pq.isEmpty()){
            int s1 = pq.poll();
            if(pq.isEmpty()){
                return s1;
            }
            int s2 = pq.poll();
            if(s1>s2){
                int newstone = s1-s2;
                pq.add(newstone);
            }
        }
        return 0;
    }
}

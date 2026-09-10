/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(n<=1){
            return n;
        }
        intervals.sort((a,b)->{
            if(a.start!=b.start){
                return Integer.compare(a.start,b.start);
            }
            return Integer.compare(a.end,b.end);
        });
        pq.offer(intervals.get(0).end);
        for(int i=1;i<n;i++){
            Interval currInt = intervals.get(i);
            if(currInt.start>=pq.peek()){
                pq.poll();
            }
            pq.offer(currInt.end);
        }
       
       
       
       
       
       
       
       
       
        // while(i<n-1){
        //     Interval first = intervals.get(i);
        //     Interval second = intervals.get(i+1);

        //     if(first.end>second.start){
        //         // theres a conflict
        //         intervals.get(i+1).start = first.start; 
        //         intervals.get(i+1).end = Math.max(first.end,second.end);
        //     }else{
        //         minRooms++;
        //     }

        //     i++;
        
        // }



        return pq.size();
    }
}

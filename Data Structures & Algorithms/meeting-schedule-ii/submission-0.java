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
        if(n<=1){
            return n;
        }
        intervals.sort((a,b)->{
            if(a.start!=b.start){
                return Integer.compare(a.start,b.start);
            }
            return Integer.compare(a.end,b.end);
        });
        List<Integer> rooms = new ArrayList<>();
        rooms.add(intervals.get(0).end);
        for(int i=1;i<n;i++){
            Interval currInt = intervals.get(i);
            boolean roomFound = false;
            for(int j=0;j<rooms.size();j++){
                if(currInt.start>=rooms.get(j)){
                    rooms.set(j,currInt.end);
                    roomFound = true;
                    break;
                }
            }
            if(!roomFound){
                rooms.add(currInt.end);
            }
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



        return rooms.size();
    }
}

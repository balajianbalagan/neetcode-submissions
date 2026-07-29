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
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)->{
            if(a.start!=b.start){
                return Integer.compare(a.start,b.start);
            }
            return Integer.compare(a.end,b.end);
        });
        int n = intervals.size();
        int i=0;
        while(i<n-1){
            Interval first = intervals.get(i);
            Interval second = intervals.get(i+1);
            if(first.end>second.start){
                return false;
            }

            i++;
        }

        return true;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        brute force
        1-2 , 1-4 , 2-7, 2-9 , 3-5, 5-6, 6-7
        we sort them and 
        while looping if there's an overlap we remove the interval with largest end
        */

        int erasedCount = 0;

        // Comparator comp = new Comparator<int[][]>{
        //     @Override
        //     int compare(int[][] a,int[][] b){
        //         if(a[0]!=b[0]){
        //             return Integer.compare(a[0],b[0]);
        //         }
        //         return Integer.compare(a[1],b[1]);
        //     }
        // };
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]){
                    return Integer.compare(a[0],b[0]);
                }
                return Integer.compare(a[1],b[1]);
        });
        int n = intervals.length;
        for(int i=0;i<n-1;i++){
            // if overlapping
            if(intervals[i][1] > intervals[i+1][0]){
                if(intervals[i+1][1] > intervals[i][1]){
                    intervals[i+1][0] = intervals[i][0];
                    intervals[i+1][1] = intervals[i][1];
                }
                erasedCount++;
            }
        }

        return erasedCount;
    }
}

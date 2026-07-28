class Solution {
    public int[][] merge(int[][] intervals) {
        int i=0;
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });
        while(i<n){
            int[] first = intervals[i];
            if(i+1>=n){
                ans.add(new int[]{first[0],first[1]});
                i++;
                continue;
            }
            
            int[] second = intervals[i+1];

            if(first[1] >= second[0]){
                intervals[i+1][0] = first[0];
                intervals[i+1][1] = Math.max(first[1],second[1]);
            }else{
                ans.add(new int[]{first[0],first[1]});
            }

            i++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}

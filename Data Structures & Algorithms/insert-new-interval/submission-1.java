class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int ic = intervals.length+1;
        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));

        for(int[] interval:intervals){
            pq.add(interval);
        }
        pq.add(newInterval);

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            if(pq.isEmpty()){
                ans.add(new ArrayList<>(Arrays.asList(top[0],top[1])));
                continue;
            }

            // if the top is overlapping we merge
            int[] next = pq.peek();
            if(top[1]>=next[0]){
                pq.poll();
                pq.add(new int[]{top[0],Integer.max(next[1],top[1])});
            }else{
                ans.add(new ArrayList<>(Arrays.asList(top[0],top[1])));
            }

        }



        int[][] finalAns = ans.stream()
            .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
            .toArray(int[][]::new);

        return finalAns;
    }
}

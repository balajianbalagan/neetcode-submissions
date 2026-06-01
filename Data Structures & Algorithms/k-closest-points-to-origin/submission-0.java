class Solution {
    public int[][] kClosest(int[][] points, int k) {
        /*
        we just maintain a k lengthed pq??

        */
        int noOfPoints = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[0]-a[0])); //max heap
        for(int i=0;i<noOfPoints;i++){
            int x = points[i][0];
            int y = points[i][1];
            int dist = x*x + y*y;
            pq.offer(new int[]{dist,x,y});
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] kcl = new int[k][2];
        for(int i=0;i<k;i++){
            int[] pts = pq.poll();
            kcl[i][0] = pts[1];
            kcl[i][1] = pts[2];
        }
        return kcl;
        

    }
}

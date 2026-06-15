class Pair{
    int node;
    int dist;
    Pair(int n,int d){
        node = n;
        dist = d;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        /*
        build adj graph
        create a min heap of pair
        add a dist array of max value
        0: []
        */
        List<List<List<Integer>>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] data: times){
            List<Integer> edge = new ArrayList<>(List.of(data[1]-1,data[2]));
            adjList.get(data[0]-1).add(edge);
        }
        int[] distances = new int[n];
        Arrays.fill(distances,(int)1e9);
        /*
        1:0
        */
        distances[k-1]=0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.offer(new Pair(k-1,0));
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            for(List<Integer> edges:adjList.get(top.node)){
                if(top.dist + edges.get(1) < distances[edges.get(0)]){
                    distances[edges.get(0)] = top.dist + edges.get(1);
                    pq.offer(new Pair(edges.get(0),distances[edges.get(0)]));
                }
            }
        }

        int maxTime = (int) 0;
        for(int i:distances){
            maxTime = Math.max(maxTime,i);
        }

        if(maxTime==1e9){
            return -1;
        }
        return maxTime;
    }
}

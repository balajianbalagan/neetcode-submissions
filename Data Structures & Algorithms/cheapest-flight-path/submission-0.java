class Pair{
    int node;
    int dist;
    int stops;

    Pair(int n,int d,int s){
        node = n;
        dist = d;
        stops = s;
    }
}


class Node{
    int node;
    int cost;
    Node(int n,int c){
        node = n;
        cost = c;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        //build graph
        List<List<Node>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adjList.get(flights[i][0]).add(new Node(flights[i][1],flights[i][2]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0,0));

        while(!q.isEmpty()){
            Pair top = q.poll();
            if(top.node == dst){
                continue;
            }
            int nextStopCount = top.stops + 1;
            for(Node nei:adjList.get(top.node)){
                if(nei.node == dst && nextStopCount > k+1){
                    continue;
                }
                if(dist[nei.node] > top.dist + nei.cost){
                    dist[nei.node] = top.dist + nei.cost;
                    // System.out.println(dist[nei.node]);
                    q.add(new Pair(nei.node,dist[nei.node],nextStopCount));

                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst]; 

    }
}

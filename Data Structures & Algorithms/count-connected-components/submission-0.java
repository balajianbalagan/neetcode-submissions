class Solution {
    public int countComponents(int n, int[][] edges) {
        int cc = 0;
        boolean[] vis = new boolean[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                cc++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int node = q.poll();
                    for(int nei:adj.get(node)){
                        if(!vis[nei]){
                            vis[nei]=true;
                            q.add(nei);
                        }
                    }
                }
            }
        }


        return cc;
    }
}

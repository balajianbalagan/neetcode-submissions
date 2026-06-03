class Solution {
    public boolean validTree(int n, int[][] edges) {
        /*
        vis [0,1,2,3,4,5]
        0,-1
        1,0
        2,1 | 3,1
        if not vis
            set to vis

        for neighbors of node
            if !visited
                add
            else if !parent
                return false
        */
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
                if(i>0){
                    return false;
                }
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i,-1});
                while(!q.isEmpty()){
                    int[] data = q.poll();
                    int node = data[0];
                    int parent = data[1];
                    if(vis[node]==false){
                        vis[node]=true;
                        for(int nei:adj.get(node)){
                            if(vis[nei]==false){
                                q.add(new int[]{nei,node});
                            }else if(parent!=nei){
                                return false;
                            }
                        }
                    }
                }
            }
        
        }



        return true;
        
    }
}

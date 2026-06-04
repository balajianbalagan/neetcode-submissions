class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        /*
        1,3 1,4 

        1 2 3 4 5
        F F F T T
        5,-1
        4,5 -> add 1,4 3,4 
        1,4 -> 1,3, 1,2
        3,4 -> 


        */
        int n = edges.length;
        parent = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            // adj.get(edges[i][0]-1).add(edges[i][1]-1);
            // adj.get(edges[i][1]-1).add(edges[i][0]-1);
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            if(find(u)==find(v)){
                // same parent so they are in cycle
                return new int[]{u+1,v+1};
            }else{
                // combine
                parent[find(u)] = find(v);
            }
        }
       
        return new int[]{};
    }

    public int find(int u){
        if(u != parent[u]){
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }
}

class Solution {
    public int[] findOrder(int nc, int[][] pr) {
         int[] indegree = new int[nc];
        List<List<Integer>> adjList = new ArrayList<>();
        // List<Integer> topo = new ArrayList<>();
        int[] topo = new int[nc];
        for(int i=0;i<nc;i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : pr){
            int a = edge[0];
            int b = edge[1];
            adjList.get(b).add(a);
            indegree[a]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<nc;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int n = q.poll();
            topo[cnt++]=n;
            for(int nei:adjList.get(n)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.add(nei);
                }
            }
        }
        if(cnt!=nc){
            return new int[]{};
        }
        return topo;
    }
}

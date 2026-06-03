class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegree[v]++;
            adjList.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int i : adjList.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        if(topo.size()==numCourses){
            return true;
        }
        return false;
    }
}

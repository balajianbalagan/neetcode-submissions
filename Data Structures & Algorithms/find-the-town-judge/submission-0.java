class Solution {
    public int findJudge(int n, int[][] trust) {
        /*
        1->3
        4->3
        2->3 (in degree 3 : V and outdegree 0)
        */
        int[] indegree = new int[n]; 
        int[] outdegree = new int[n]; 
        for(int i=0;i<trust.length;i++){
            int u = trust[i][0];
            int v = trust[i][1];
            indegree[v-1]++;
            outdegree[u-1]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==n-1 && outdegree[i]==0){
                return i+1;
            }
        }
        return -1;
    }
}
class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> totalTasks = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]){
                return a[1]-b[1];
            }
            return a[2]-b[2];
        });
        PriorityQueue<int[]> availableTasks = new PriorityQueue<>((a,b)->{
            if(a[2]!=b[2]){
                return a[2]-b[2];
            }
            return a[0]-b[0];
        });
        int n = tasks.length;
        int[] finalOrder = new int[n];

        for(int i=0;i<tasks.length;i++){
            System.out.println(i+" "+tasks[i][0]);
            totalTasks.add(new int[]{i,tasks[i][0],tasks[i][1]});
        }
        int time = 0;
        int j=0;
        while(!totalTasks.isEmpty() || !availableTasks.isEmpty()){
            while(!totalTasks.isEmpty() && totalTasks.peek()[1]<=time){
                availableTasks.add(totalTasks.poll());
            }
            if(availableTasks.isEmpty()){
                time++;
            }
            if(!availableTasks.isEmpty()){
                int[] taskData = availableTasks.poll();
                finalOrder[j++]=taskData[0];
                time+=taskData[2];
            }
        }


        return finalOrder;
    }
}
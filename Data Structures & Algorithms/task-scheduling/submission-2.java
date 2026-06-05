class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        X:2 Y:2  n:2
        A B C
        A:3 B:1 C:1 3
        A:2 B:1 C:1
        each n interval we have a map of 26 we store last occurency
        hmap A1 B1 C1
        A A A B C we have in queue
        we go through queue
        i = q letter
        if hmap[i]==-1
        we pop it and put in taskq = A and assign A=cnt
        find another A hmap[i]!=-1 && (cnt-hmap[i] ! >n) so we skip it
        find another A so same
        find b (hmap[i]==-1) so we pop it and putin tasq and assign B=cnt ( A0 B1   )
        find c (hmap[i]==-1) so we pop it and putin tasq and assign B=cnt ( A0 B1 C2  )


        
        
        A10
        b11
        c12


        */

        int[] hmap = new int[26];
        int time=0;
        PriorityQueue<Integer> spq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<tasks.length;i++){
            hmap[tasks[i]-'A']++;
        }
        
        for(int i=0,j=0;i<26;i++){
            if(hmap[i]!=0){
                spq.add(hmap[i]);
            }
        }

        while(!spq.isEmpty() || !q.isEmpty()){
            time++;
            if(!spq.isEmpty()){
                int f = spq.poll();
                f--;
                if(f>0){
                    q.add(new int[]{f,time+n});
                }
            }
            
            while(!q.isEmpty() && time==q.peek()[1]){
                spq.add(q.poll()[0]);
            }

        }

     
        return time;
    }
}

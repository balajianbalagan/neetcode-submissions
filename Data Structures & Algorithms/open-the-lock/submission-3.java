class Pair{
    String combo;
    int steps;
    Pair(String c,int s){
        combo = c;
        steps = s;
    }
}
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<String>();
        for(String s: deadends){
            deadSet.add(s);
        }
        if(deadSet.contains(target) || deadSet.contains("0000")){
            return -1;
        }
        Set<String> used = new HashSet<String>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair("0000",0));
        int ans = (int) 1e9;
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String s = curr.combo;
            int steps = curr.steps;
            if(s.equals(target)){
                ans = Math.min(ans,steps);
            }
            /* increment each character
            increment each unless its a 9 then
            see if its in used or deadends
            if not add it to queue with added steps
            add to used
             */
            char[] currA = s.toCharArray();
            for(int i=0;i<currA.length;i++){
                char c = currA[i];
                char ncu = c!='9' ?  (char) (c+1) : '0';
                currA[i] = ncu;
                // now currA has a new word
                String newWordUp = new String(currA);
                if(!used.contains(newWordUp) && !deadSet.contains(newWordUp)){
                    // System.out.println("trying: "+newWord);
                    used.add(newWordUp);
                    q.add(new Pair(newWordUp,steps+1));
                }
                char ncd = c!='0' ?  (char) (c-1) : '9';
                currA[i] = ncd;
                String newWordDown = new String(currA);
                if(!used.contains(newWordDown) && !deadSet.contains(newWordDown)){
                    // System.out.println("trying: "+newWord);
                    used.add(newWordDown);
                    q.add(new Pair(newWordDown,steps+1));
                }

                currA[i] = c;
            }
        }

        if(ans==(int)1e9){
            return -1;
        }
        return ans;
    }
}
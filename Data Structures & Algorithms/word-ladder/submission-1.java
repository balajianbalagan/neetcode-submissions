class Pair{
    public String word;
    public int dist;
    Pair(String w,int d){
        word = w;
        dist = d;
    }
}
class Solution {
    public int computeDiff(String a, String b){
        int diff = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
                if(diff>1){
                    return -1;
                }
            }
        }
        return diff;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        we construct a graph 
        where two nodes are connected if they have difference as one
        then we do DFS traversal to find if we can find the target
        */
        Map<String,List<String>> mp = new HashMap<>();
        Map<String,Integer> dist = new HashMap<>();
        wordList.add(beginWord);
        boolean isEndpresent = false;
        for(int i=0;i<wordList.size();i++){
            mp.computeIfAbsent(wordList.get(i),k -> new ArrayList<>());
            dist.computeIfAbsent(wordList.get(i),k->(int)1e9);
            if(wordList.get(i).equals(endWord)){
                isEndpresent = true;
            }
            for(int j=0;j<wordList.size();j++){
                if(i!=j){
                    if(computeDiff(wordList.get(i),wordList.get(j))==1){
                        // System.out.println(wordList.get(i) + " " + wordList.get(j));
                        mp.get(wordList.get(i)).add(wordList.get(j));
                    }
                }
            }
        }
        if(!isEndpresent){
            return 0;
        }

        /*
        We start from beginword
        */
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,0));
        dist.put(beginWord,0);
        while(!q.isEmpty()){
            Pair node = q.poll();
            System.out.println(node.word+" | dist from org "+node.dist);
            for(String nei:mp.getOrDefault(node.word,new ArrayList<>())){
                System.out.println(nei+" | neighbor dist "+dist.get(nei));
                if(node.dist + 1 < dist.get(nei)){
                    dist.put(nei,node.dist+1);
                    q.add(new Pair(nei,node.dist+1));
                }
            }
        }



        int answer = dist.getOrDefault(endWord,0);
        if(answer==1e9){
            return 0;
        }
        return answer+1;
    }
}

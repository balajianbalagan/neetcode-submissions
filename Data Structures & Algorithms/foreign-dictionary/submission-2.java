class Solution {
    public String foreignDictionary(String[] words) {
      /*
      find graph nodes
      i,i+1 
      find differing character
      n->f
      h->e
      r->n
      e->r
      
      find topo sort
        store as adjacency list

    topo sort algo
        indegree array
        n1 f1 h0 e1 r1
        h e r n f
      */
    if(words.length==1){
        return words[0];
    }
    StringBuilder toposort = new StringBuilder();
    Map<Character,List<Character>> mp = new HashMap<>();
    Map<Character,Integer> indegree = new HashMap<>();
    for(int i=0;i<words.length;i++){
        for(int j=0;j<words[i].length();j++){
            indegree.put(words[i].charAt(j),indegree.getOrDefault(words[i].charAt(j),0));
            System.out.println(indegree.size());
        }
    }
    for(int i=0;i<words.length-1;i++){
        String s1 = words[i];
        String s2 = words[i+1];

        int n1 = s1.length();
        int n2 = s2.length();
        char u=' ',v=' ';
        int n = Math.min(n1,n2);
        for(int j=0;j<n;j++){
            if(s1.charAt(j) - s2.charAt(j) != 0){
                u = s1.charAt(j);
                v = s2.charAt(j);
                break;
            }
        }
        if(u==' ' && n1>n2){
            return "";
        }
        System.out.println(u+" -> "+v);
        if(v!=' '){
            List<Character> lich = mp.computeIfAbsent(u,k->new ArrayList<>());
            lich.add(v);
            System.out.println(mp.get(u).size());
            indegree.put(v,indegree.getOrDefault(v,0)+1);
            indegree.put(u,indegree.getOrDefault(u,0));
        }
    }

    Queue<Character> q = new LinkedList<>();
    for(Map.Entry<Character,Integer> entry:indegree.entrySet()){
        if(entry.getValue()==0){
            System.out.println(entry.getKey());
            q.add(entry.getKey());
        }
    }

    while(!q.isEmpty()){
        char c = q.poll();
        System.out.println(c);
        toposort.append(c);
        for(char nei:mp.getOrDefault(c,new ArrayList<>())){
            indegree.put(nei,indegree.get(nei)-1);
            if(indegree.get(nei)==0){
                q.add(nei);
            }
        }
    }

    //toposort aint equal to nodes in graph
      if(indegree.size()!=toposort.toString().length()){
        System.out.println(indegree.size()+" "+toposort.toString());
        return "";
      }
      return toposort.toString();
    }
}

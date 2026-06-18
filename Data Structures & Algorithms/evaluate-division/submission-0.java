class Pair{
    String node;
    double val;
    Pair(String n,double v){
        node = n;
        val = v;
    }
}
class Solution {
    public void union(String a,String b, Map<String,String> parents){
        String pb = find(b,parents);
        String pa = find(a,parents);
        if(pb.equals(pa)){
            return;
        }
        parents.put(pb,pa);
    }

    public String find(String a, Map<String,String> parents){
        if(!a.equals(parents.get(a))){
            parents.put(a,find(parents.get(a),parents));
            return parents.get(a);
        }
        return a;
    }
    public double dfs(String c,String d,Set<String> visited,Map<String,List<Pair>> graph){
        System.out.println(c+"/"+d);
        double val = -1;
        for(Pair pa:graph.get(c)){
            if(visited.contains(pa.node)){
                continue;
            }
            if(pa.node.equals(d)){
                return pa.val;
            }
            visited.add(pa.node);
            double temp = dfs(pa.node,d,visited,graph);
            if(temp!=-1){
                val = pa.val * temp;
                return val;
            }
        }
        return -1;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        /*
        a->b
        b->c
        we store a DSU 
        we store a directed graph from given equations

        if in same set -> perform DFS and get soln
        else return -1
        */
        Map<String,List<Pair>> graph = new HashMap<>();
        Map<String,String> parents = new HashMap<>();
        double[] answers = new double[queries.size()];
        int i=0;
        for(List<String> eq:equations){
            parents.putIfAbsent(eq.get(0),eq.get(0));
            parents.putIfAbsent(eq.get(1),eq.get(1));
            union(eq.get(0),eq.get(1),parents);

            graph.computeIfAbsent(eq.get(0),k->new ArrayList<>()).add(new Pair(eq.get(1),values[i]));
            graph.computeIfAbsent(eq.get(1),k->new ArrayList<>()).add(new Pair(eq.get(0),1/values[i]));
            i++;
        }

        i = 0;
        for(List<String> q:queries){
            String c = q.get(0);
            String d = q.get(1);
            if(!graph.containsKey(c) || !graph.containsKey(d)){
                answers[i] =  -1;
            }else if(c.equals(d)){
                answers[i] = 1;
            }else if(!find(c,parents).equals(find(d,parents))){
                answers[i] = -1;
            }else{
                Set<String> visited = new HashSet<>();
                visited.add(c);
                answers[i] = dfs(c,d,visited,graph);
            }
            i++;
        }
        return answers;
    }
}   
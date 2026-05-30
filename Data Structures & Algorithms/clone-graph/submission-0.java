/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Pair{
    public Node node;
    public int visited;
    Pair(Node node,int visited){
        this.node = node;
        this.visited = visited;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        
        Node newNode = new Node();
        if(node==null){
            return node;
        }
        Queue<Node[]> q = new LinkedList<>();
        HashMap<Integer, Pair> map = new HashMap<>();
        q.add(new Node[]{node,newNode});
        while(!q.isEmpty()){
            int s = q.size();
            for(int i=0;i<s;i++){
                Node orig = q.peek()[0];
                Node newN = q.peek()[1];
                q.remove();
                if(node==null){
                    continue;
                }
                if(map.containsKey(orig.val) && map.get(orig.val).visited==1){
                    System.out.println("detected: "+orig.val);
                    continue;
                }
                System.out.println(orig.val);
                map.put(orig.val,new Pair(newN,1));
                newN.val = orig.val;
                for(Node n:orig.neighbors){
                    Node newNeighbor;
                    if(map.containsKey(n.val)){
                        newNeighbor = map.get(n.val).node;
                    }else{
                        newNeighbor = new Node();
                        newNeighbor.val = n.val;
                        map.put(n.val,new Pair(newNeighbor,0));
                    }
                    
                    
                    newN.neighbors.add(newNeighbor);
                    q.add(new Node[]{n,newNeighbor});
                }
            }
        }
        return newNode;
    }
}



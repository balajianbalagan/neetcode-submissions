class TreeNode {
    boolean isEndWord;
    Map<Character, TreeNode> children;
    TreeNode(){
        children = new HashMap<>();
        isEndWord = false;
    }
}

class PrefixTree {
    private TreeNode root;
    public PrefixTree() {
         root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode node = root;
        for(char c:word.toCharArray()){
            node = node.children.computeIfAbsent(c,k->new TreeNode());
        }
        node.isEndWord = true;
    }

    public boolean search(String word) {
        TreeNode node = root;
        for(char c:word.toCharArray()){
            node = node.children.get(c);
            if(node==null){
                return false;
            }
        }
        return node.isEndWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode node = root;
        for(char c:prefix.toCharArray()){
            node = node.children.get(c);
            if(node==null){
                return false;
            }
        }
        return true;
    }
}

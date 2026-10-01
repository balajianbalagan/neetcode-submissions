class Solution {
    public int maxDepth(String s) {
        int maximumDepth = 0;
        int currentDepth = 0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                currentDepth+=1;
                maximumDepth = Math.max(maximumDepth,currentDepth);
            }else if(ch==')'){
                currentDepth-=1;
            }
        }
        return maximumDepth;

    }
}
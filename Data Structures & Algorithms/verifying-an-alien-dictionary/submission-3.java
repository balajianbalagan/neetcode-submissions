class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] dictionary = new int[26];
        for(int i=0;i<26;i++){
            dictionary[order.charAt(i)-'a'] = i;
        }
        /*
        h:0 l:1 ....
        dag disk dog
        a i i o
        check distinction character if  nothing found its false
        see if its topologically sorted
        */
        for(int i=0;i<words.length-1;i++){
            char fi=' ';
            // compare words i i+1
            String first = words[i];
            String second = words[i+1];
            int len = Math.min(first.length(),second.length());
            for(int j=0;j<len;j++){
                int f = first.charAt(j) - 'a';
                int s = second.charAt(j) - 'a';
                if(dictionary[f]<dictionary[s]){
                    fi = first.charAt(j);
                    break;
                }else if(dictionary[f]>dictionary[s]){
                    return false;
                }
            }
            if(fi==' ' && first.length()>second.length()){
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public String maximumOddBinaryNumber(String s) {
        /*
            if odd? (last is 1?)
           yes ----                         --- no
          has any other 1s                  move the minimum 1 to 0th
    yes --          -- no
   move it to max    return as is                              
        */


        /*
        if odd (move 1 to last)
        has any other 1s than last (if so move it first)
        */

        int n = s.length();
        int n1s = 0;
        int n0s = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                n1s+=1;
            }else{
                n0s+=1;
            }
        }

        for(int j=0;j<n1s-1;j++){
            sb.append('1');
        }
        for(int j=0;j<n0s;j++){
            sb.append('0');
        }
        sb.append('1');

        return sb.toString();
    }
}
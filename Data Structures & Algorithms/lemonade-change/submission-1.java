class Solution {
    public boolean lemonadeChange(int[] bills) {
        int no5s = 0;
        int no10s = 0;
        int n = bills.length;
        for(int i=0;i<n;i++){
            if(bills[i]==5){
                no5s+=1;
            }else if(bills[i]==10){
                if(no5s==0){
                    return false;
                }
                no5s-=1;
                no10s+=1;
            }else{
                if((no10s==0 || no5s==0) && (no5s<3)){
                    return false;
                }
                if((no10s>0 && no5s>0)){
                    no10s-=1;
                    no5s-=1;
                }else if(no5s>=3){
                    no5s-=3;
                    // System.out.println(no5s);
                }

            }
            System.out.println(no5s);
        }




        return true;
    }
}
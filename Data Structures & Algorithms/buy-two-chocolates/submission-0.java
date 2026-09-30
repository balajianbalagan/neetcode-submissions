class Solution {
    public int buyChoco(int[] prices, int money) {
        /*

        3 5 2
        1 2 3 

        1 2 2 5
        1 2 

        */

        int min_1st = Integer.MAX_VALUE;
        int min_2nd = Integer.MAX_VALUE;

        for(int i:prices){
            if(i<min_1st){
                min_2nd = min_1st;
                min_1st = i;
            }else if(i<min_2nd){
                min_2nd = i;
            }
        }

        if(min_1st + min_2nd <= money){
            return money - min_1st - min_2nd;
        }else{
            return money;
        }

    }
}
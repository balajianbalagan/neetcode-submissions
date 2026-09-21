class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int l = 0,r=0;
        int jumps = 0;
        while(r<n-1){
            int maxRange = Integer.MIN_VALUE;
            // System.out.println("l: "+l+" | r: "+r);
            for(int j=l;j<=r;j++){
                maxRange = Math.max(j + nums[j],maxRange);
            }
            jumps++;
            l=r+1;
            r=maxRange;
            // if(jumps==3){
            //     break;
            // }
        }
        return jumps;
    }
}

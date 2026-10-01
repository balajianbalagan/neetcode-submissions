class Solution {
    public int[] findBuildings(int[] heights) {
        /*
        1 2 3 4
        maxHeight
        4 2 3 2 1
                 

        */

        int n = heights.length;
        List<Integer> oceanView = new ArrayList<>();
        int maxHeightSoFar = 0;
        for(int i = n-1;i>=0;i--){
            if(heights[i]>maxHeightSoFar){
                oceanView.add(0,i);
            }
            maxHeightSoFar = Math.max(maxHeightSoFar,heights[i]);
        }

        int[] ans = oceanView.stream().mapToInt(Integer::intValue).toArray();
        return ans;


    }
}
class Solution {
    List<List<Integer>> ans;
    public void solve(List<List<Integer>> ans,int[] candidates, int target, int ind, List<Integer> subArr){
        if(target==0){
            ans.add(new ArrayList<>(subArr));
        }
        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }
            
            if(target<candidates[i]){
                return;
            }

            subArr.add(candidates[i]);
            solve(ans,candidates,target-candidates[i],i+1,subArr);
            subArr.removeLast();
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        List<Integer> subArr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        solve(ans,candidates,target,0,subArr);


        return ans;
    }
}

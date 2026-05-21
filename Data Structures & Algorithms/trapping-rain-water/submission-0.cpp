class Solution {
public:
    int trap(vector<int>& height) {
        int trappedWater = 0;
        int leftMax=0,rightMax=0;
        int n = height.size();
        int l = 0,r=n-1;
        vector<int> walls(n,-1);
        for(int i=0;i<n;i++){
            leftMax = max(leftMax,height[l]);
            rightMax = max(rightMax,height[r]);

            if(walls[l]==-1){
                walls[l] = leftMax;
            }else{
                walls[l] = min(walls[l],leftMax);
            }

            
            if(walls[r]==-1){
                walls[r] = rightMax;
            }else{
                walls[r] = min(walls[r],rightMax);
            }


            l++;
            r--;
        }

        for(int i=0;i<n;i++){
            if(walls[i] - height[i]>0){
                trappedWater += walls[i] - height[i];
            }
        }


        return trappedWater;
    }
};

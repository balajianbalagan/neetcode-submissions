class Solution {
public:
    int findHours(vector<int>& piles, int bananaEatingRate){
        int hours = 0;
        for(int i=0;i<piles.size();i++){    
            hours += ceil((double)piles[i]/bananaEatingRate);
        }
        return hours;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int minEatSpeed = INT_MAX;
        int n = piles.size();
        int maxElement = *max_element(piles.begin(),piles.end());
        int l = 1;
        int r = maxElement;
        while(l<=r){
            int mid = (l+r)/2;
            int hours = findHours(piles,mid);
            cout<<"mid : "<<mid<<" hours: "<<hours<<endl;
            if(hours<h){
                minEatSpeed = min(minEatSpeed,mid);
                r = mid-1;
            }else if(hours>h){
                l = mid+1;
            }else{
                minEatSpeed = min(minEatSpeed,mid);
                r = mid-1;
            }
        }
        return minEatSpeed;

    }
};

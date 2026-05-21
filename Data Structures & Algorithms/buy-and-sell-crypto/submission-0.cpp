class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int n = prices.size();
        if(n==0)return 0;
        int maxProfit=0,minBuyingPrice=prices[0];
        for(int i=0;i<n;i++){
            minBuyingPrice = min(minBuyingPrice,prices[i]);
            maxProfit = max(maxProfit, prices[i]-minBuyingPrice);
        }
        return maxProfit;

    }
};

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int rows = matrix.size();
        int cols = matrix[0].size();
        int rowst=0,rowend=rows-1;
        int colst=0,colsend=cols-1;
        while(rowst<=rowend && colst<=colsend){
            int rowmid = (rowst+rowend)/2;
            int colmid = (colst+colsend)/2;

            if(matrix[rowmid][colmid]==target){
                return true;
            }else if(matrix[rowmid][colmid]<target){
                if(matrix[rowmid][cols-1]<target){
                    rowst++;
                }else{
                    colst++;
                }
            }else{
                if(matrix[rowmid][0]>target){
                    rowend--;
                }else{
                    colsend--;
                }
            }
        }
        return false;
    }
};

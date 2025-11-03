class Solution {
    public void dfs(int row, int col, int[][] ans, int[][] image,int iniColour,int color, int[] delRow, int[] delCol){
        ans[row][col]=color;
        int m=image.length;
        int n=image[0].length;
        for(int i=0;i<4; i++){
            int nRow=row+delRow[i];
            int nCol=col+delCol[i];
            if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && image[nRow][nCol]==iniColour && ans[nRow][nCol]!=color){
                dfs(nRow,nCol,ans,image,iniColour,color,delRow,delCol);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans=image;
        int iniColour=image[sr][sc];
        int[] delRow={-1,0,1,0};
        int[] delCol={0,1,0,-1};
        dfs(sr,sc,ans,image,iniColour,color,delRow,delCol);
        return ans;
    }
}
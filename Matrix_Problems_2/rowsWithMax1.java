class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int maxCnt=Integer.MIN_VALUE;
        int row=-1;
        for(int i=0; i<m; i++){
            int cnt=0;
            for(int j=0; j<n; j++){
                if(mat[i][j]==1) cnt++;
            }
            if(cnt>maxCnt){
                maxCnt=cnt;
                row=i;
            }
        }
        return new int[]{row,maxCnt};
    }
}
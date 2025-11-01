import java.util.ArrayList;
import java.util.List;

public class NQueens {
  public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        List<Integer> queens=new ArrayList<>();
        boolean[] rows=new boolean[n];
        boolean upperLeftDiag[]=new boolean [2*n-1];
        boolean lowerLeftDiag[]=new boolean[2*n-1];

        backTrack(res,queens,0,n,rows,upperLeftDiag,lowerLeftDiag);
        return res;
        
    }
    public void backTrack(List<List<String>> res,List<Integer> queens,int col,int n,boolean[] rows,boolean[] upperLeftDiag,boolean[] lowerLeftDiag){
        if(col==n){
          List<String> board=new ArrayList<>();
          for(int c=0; c<n; c++){
            StringBuilder rowString=new StringBuilder();
            for(int r=0; r<n; r++){
              if(queens.get(c)==r){
                rowString.append('Q');
              } else{
                rowString.append('.');
              }
            }
            board.add(rowString.toString());
          }
          res.add(board);
          return;
        }

        for(int row=0; row<n; row++){
            if(rows[row] || lowerLeftDiag[row+col] || upperLeftDiag[n-1 + col - row]){
                continue;
            }
            queens.add(row);
            rows[row]=true;
            lowerLeftDiag[row+col]=true;
            upperLeftDiag[n-1 + col - row]=true;

            backTrack(res,queens,col+1,n,rows,upperLeftDiag,lowerLeftDiag);

            queens.remove(queens.size()-1);
            rows[row]=false;
            lowerLeftDiag[row+col]=false;
            upperLeftDiag[n-1 + col - row]=false;
        }
    }
}

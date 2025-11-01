import java.util.*;
public class generateParanthesis {
  public void backtrack(int open, int close, int n, StringBuilder sb, List<String> res){
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append('(');
            backtrack(open+1,close,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(')');
            backtrack(open,close+1,n,sb,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        backtrack(0,0,n,new StringBuilder(),res);
        return res;
    }
}

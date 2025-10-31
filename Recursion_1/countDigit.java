public class countDigit {
  static int evenlyDivides(int N){
    return helper(N,N);
  }
  static int helper(int ori,int current){
    if(current==0) return 0;
    int digit=current%10;
    int count=0;
    if(digit!=0 && ori%digit==0){
      count=1;
    }
    return count+helper(ori,current/10);
  }
}

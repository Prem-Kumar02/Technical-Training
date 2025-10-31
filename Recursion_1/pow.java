public class pow {
  public int pow(int n, int p){
        if(p==0) return 1;
        return n*pow(n,p-1);
    }
    public int reverseExponentiation(int n) {
        // code here
        int rev=0;
        int num=n;
        while(num>0){
            int lastDigit=num%10;
            rev+=rev*10+lastDigit;
            num/=10;
        }
        
        return pow(n,rev);
        
    }
}

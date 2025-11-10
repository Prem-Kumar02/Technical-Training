public class firstBadVersion {
  public int firstBadVersion(int n) {
        int low=1;
        int high=n;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isBadVersion(mid)==true){
                ans=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return ans;
    }

  private boolean isBadVersion(int mid) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isBadVersion'");
  }
}
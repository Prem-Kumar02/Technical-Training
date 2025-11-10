import java.util.*;
class Solution{
  public int lowerBound(int[] arr,int target){
    int low=0,high=arr.length-1;
    while(low<high){
      int mid=low+(high-low)/2;
      if(arr[mid]>=target){
        high=mid;
      } else{
        low=mid+1;
      }
    }
    return low;
  }
}
public class sumOfArr {
  int sum(int arr[], int n, int i,int sum){
        if(i==n) return sum;
        return sum(arr,n,i+1,sum+arr[i]);
    }
    int arraySum(int arr[]) {
        int n=arr.length;
        int sum=0;
        return sum(arr,n,0,sum);
        
    }
}

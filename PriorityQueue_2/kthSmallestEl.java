import java.util.*;
class Solution {

    static void kth_Smallest_MinHeap(int[] arr, int k) {

        PriorityQueue<Integer>pq= new PriorityQueue<>();
        int n = arr.length  ;

        for (int i = 0; i < n; i++) {
            pq.add(arr[i])  ;
        }

        int f = k - 1 ;

        while (f > 0) {
            pq.remove()  ;
            f-- ;
        }

        System.out.println("Kth Smallest element "+pq.peek())  ;
    }
 
public static void main(String args[]) {

    int arr[] = {1, 2, 6, 4, 5, 3}  ;

    kth_Smallest_MinHeap(arr, 3)  ;
}
}
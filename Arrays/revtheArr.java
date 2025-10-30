

import java.util.* ;
import java.util.ArrayList;

public class revtheArr {
    public static void reverseArray(ArrayList<Integer> arr, int m){
        int start=m+1;
        int end=arr.size()-1;
        while(start<end){
            int temp=arr.get(start);
            arr.set(start,arr.get(end));
            arr.set(end,temp);
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        int m = 4; // Index after which to reverse
        reverseArray(arr, m);
        System.out.println(arr); // Output the modified array
    }
}
    
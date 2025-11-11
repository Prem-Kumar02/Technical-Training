import java.util.*;

class Solution {
    static void heapify(int[] arr, int n, int i) {
        int largest = i;         
        int left = 2 * i + 1;    
        int right = 2 * i + 2;   

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than the current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and heapify the affected subtree
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static int[] buildHeap(int[] arr, int n) {
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        return arr; 
    }
}

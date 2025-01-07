#include <stdio.h>

void findNonRepeating(int arr[], int n) {
    int xor = 0, x = 0, y = 0, set_bit_no;
    for (int i = 0; i < n; i++) xor ^= arr[i];
    set_bit_no = xor & ~(xor - 1);
    for (int i = 0; i < n; i++) {
        if (arr[i] & set_bit_no) x ^= arr[i];
        else y ^= arr[i];
    }
    printf("%d %d\n", x, y);
}

int main() {
    int arr[] = {4, 5, 4, 5, 6, 7};
    int n = sizeof(arr) / sizeof(arr[0]);
    findNonRepeating(arr, n);
    return 0;
}
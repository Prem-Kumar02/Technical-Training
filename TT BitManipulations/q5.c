#include <stdio.h>

int countBitsToFlip(int a, int b) {
    int xor = a ^ b, count = 0;
    while (xor) {
        count += xor & 1;
        xor >>= 1;
    }
    return count;
}

int main() {
    int a, b;
    scanf("%d %d", &a, &b);
    printf("%d\n", countBitsToFlip(a, b));
    return 0;
}

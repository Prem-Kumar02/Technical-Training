#include <stdio.h>

int findSetBitPosition(int n) {
    if ((n & (n - 1)) != 0) return -1;
    int pos = 1;
    while ((n & 1) == 0) {
        n >>= 1;
        pos++;
    }
    return pos;
}

int main() {
    int num;
    scanf("%d", &num);
    printf("%d\n", findSetBitPosition(num));
    return 0;
}

#include <stdio.h>

int isPowerOfTwo(int n) {
    return (n > 0) && (n & (n - 1)) == 0;
}

int main() {
    int num;
    scanf("%d", &num);
    printf("%d\n", isPowerOfTwo(num));
    return 0;
}

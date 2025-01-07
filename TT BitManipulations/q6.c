#include <stdio.h>

int countSetBits(int n) {
    int count = 0, powerOf2 = 2, groups, remainder;
    while (powerOf2 / 2 <= n) {
        groups = n / powerOf2;
        count += (groups / 2) * powerOf2;
        remainder = n % powerOf2;
        if (groups % 2 == 1) count += remainder + 1;
        powerOf2 *= 2;
    }
    return count;
}

int main() {
    int num;
    scanf("%d", &num);
    printf("%d\n", countSetBits(num));
    return 0;
}

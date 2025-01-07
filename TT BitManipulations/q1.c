#include <stdio.h>

int countSetBits(int number) {
    int count = 0;
    while (number > 0) {
        count += number & 1;
        number >>= 1;
    }
    return count;
}

int main() {
    int num;
    printf("Enter an integer: ");
    scanf("%d", &num);

    int result = countSetBits(num);
    printf("The number of set bits in %d is: %d\n", num, result);

    return 0;
}
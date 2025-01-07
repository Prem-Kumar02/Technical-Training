#include <stdio.h>

int divide(int dividend, int divisor) {
    int quotient = 0, sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
    dividend = dividend < 0 ? -dividend : dividend;
    divisor = divisor < 0 ? -divisor : divisor;
    while (dividend >= divisor) {
        dividend -= divisor;
        quotient++;
    }
    return sign * quotient;
}

int main() {
    int a, b;
    scanf("%d %d", &a, &b);
    printf("%d\n", divide(a, b));
    return 0;
}

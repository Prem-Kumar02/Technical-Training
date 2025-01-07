#include <stdio.h>
#include <math.h>

void printPowerSet(char *set, int n) {
    int powerSetSize = 1 << n;
    for (int i = 0; i < powerSetSize; i++) {
        for (int j = 0; j < n; j++) {
            if (i & (1 << j)) printf("%c", set[j]);
        }
        printf("\n");
    }
}

int main() {
    char set[] = {'a', 'b', 'c'};
    int n = sizeof(set) / sizeof(set[0]);
    printPowerSet(set, n);
    return 0;
}

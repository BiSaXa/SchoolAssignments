#include <stdio.h>
#include <math.h>

float distance(int x1, int y1, int x2, int y2);

int main() {
    printf("Enter coordinates for x:\n");
    int x;
    scanf("%d", &x);
    printf("Enter coordinates for y:\n");
    int y;
    scanf("%d", &y);
    if(distance(0, 0, x, y) > 10) {
        printf("Point is not in the circle.\n");
        printf("Distance to center: %.2f\n", distance(0, 0, x, y));
    } else {
        printf("Point is in the circle.\n");
        printf("Distance to center: %.2f\n", distance(0, 0, x, y));
    }
    return 0;
}

float distance(int x1, int y1, int x2, int y2) {
    return sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
}
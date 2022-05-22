#include <stdio.h>
#include <ctype.h>
#define AMOUNT_OF_FAMILY_MEMBERS 2
int main()
{
    char fname[AMOUNT_OF_FAMILY_MEMBERS][16];
    printf("Enter your father's name: ");
    scanf("%s", &fname[0]);
    printf("Enter your mother's name: ");
    scanf("%s", &fname[1]);
    int r = 0, u = 0;
    for (r = 0; r < AMOUNT_OF_FAMILY_MEMBERS; r++)
    {
        while (fname[r][u])
        {
            fname[r][u] = toupper(fname[r][u]);
            u++;
        }
        u = 0;
    }
    int i, j, k, row = 0;
    while (row < AMOUNT_OF_FAMILY_MEMBERS)
    {
        for (i = 0; fname[row][i] != '\0'; i++)
        {
            k = 1;
            for (j = i + 1; fname[row][j] != '\0'; j++)
            {
                if (fname[row][i] == fname[row][j])
                {
                    k++;
                    fname[row][j] = '`';
                }
            }
            if (fname[row][i] != '`')
            {
                printf("\n%c appeared %d times.", fname[row][i], k);
            }
        }
        printf("\n");
        row++;
    }
    return 0;
}
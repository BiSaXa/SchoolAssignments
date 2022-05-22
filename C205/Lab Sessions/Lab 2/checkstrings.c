#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char strings[10][20];
int stringcount;

void ReadStrings();

void PrintStrings();

void EvenChars();

int CheckEven(int, int, char[], int[]);

int main(int argc, char **argv) {
    ReadStrings();
    PrintStrings();
    EvenChars();
    return 0;
}

void ReadStrings() {
    printf("Enter the number of strings:\n");
    scanf("%d", &stringcount);
    if (stringcount > 10 || stringcount <= 0) {
        printf("Invalid number of strings. Should be between 1 and 10.");
        exit(1);
    }
    for (unsigned int i = 0; i < stringcount; i++) {
        char str[20];
        printf("%d: Enter the string:\n", i);
        scanf("%s", str);
        strcpy(strings[i], str);
    }
}

void PrintStrings() {
    printf("Strings:\n");
    for (unsigned int i = 0; i < stringcount; i++) {
        printf("Characters of the %dth string: ", i);
        unsigned int c = 0;
        while (1) {
            if (strings[i][c] == '\0') {
                break;
            }
            if (strings[i][c] == 44) {
                strings[i][c] = 32;
            }
            printf("%c", strings[i][c]);
            c++;
        }
        printf("\n");
    }
}

void EvenChars() {
    for (unsigned int i = 0; i < stringcount; i++) {
        int chars[20] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        if(CheckEven(0, 0, strings[i], chars)) {
            printf("The %dth string has even number of characters\n", i);
        }
    }
}

int CheckEven(int i, int j, char str[], int chars[20]) {
    for (i = 0; i < strlen(str); i+=2) {
        int count = 0;
        for (j = i; j < strlen(str); j+=2) {
            if (str[i] == str[j] && chars[j] == 1) {
                count++;
                chars[i] = 2;
                chars[j] = 2;
            }
        }
        if (count % 2 != 0) {
            chars[i] = 0;
        }
    }
    for (int k = 0; k < 20; k++) {
        if (chars[k] == 0) {
            return 0;
            break;
        }
    }
    return 1;
}
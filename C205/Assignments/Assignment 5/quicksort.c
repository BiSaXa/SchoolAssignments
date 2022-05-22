#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define SIZE 5
#define RANDOM_NO_RANGE 20
int main()
{
    int arr[SIZE][SIZE];
    srand(time(0));
    printf("Randomly created array:\n");
    for (int i = 0; i < SIZE; i++)
    {
        for (int j = 0; j < SIZE; j++)
        {
            int n = rand() % RANDOM_NO_RANGE;
            arr[i][j] = n;
        }
    }
    printArray(arr);
    for (int row = 0; row < SIZE; row++)
    {

        quickSort(arr[row], 0, SIZE - 1);
    }
    printf("\nSorted array:\n");
    printArray(arr);
    return 0;
}

void printArray(int arr[SIZE][SIZE])
{
    int i, j;
    for (i = 0; i < SIZE; i++)
    {
        for (j = 0; j < SIZE; j++)
        {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }
}

void swap(int *a, int *b)
{
    int t = *a;
    *a = *b;
    *b = t;
}

int partition(int arr[], int low, int high)
{
    int pivot = arr[high];
    int i = (low - 1);
    for (int j = low; j <= high - 1; j++)
    {
        if (arr[j] < pivot)
        {
            i++;
            swap(&arr[i], &arr[j]);
        }
    }
    swap(&arr[i + 1], &arr[high]);
    return (i + 1);
}

void quickSort(int arr[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(arr, low, high);
        quickSort(arr, low, pi - 1);
        quickSort(arr, pi + 1, high);
    }
}
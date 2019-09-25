#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <time.h>

typedef enum {false, true} bool;

void siftDown(int *numbers, int root, int bottom)
{
  int maxDoch;
  bool done = false;
  while (
		(root * 2 <= bottom) && (!done)) {
    if (root * 2 == bottom) maxDoch = root * 2;
    else if (numbers[root * 2] > numbers[root * 2 + 1]) maxDoch = root * 2;
    else maxDoch = root * 2 + 1;
    if (numbers[root] < numbers[maxDoch]) {
			int temp = numbers[root];
			numbers[root] = numbers[maxDoch];
			numbers[maxDoch] = temp;
			root = maxDoch;
    }
    else done = true;
	}
}

void heapSort(int *arr, int n)
{
	for (int i = (n / 2) - 1; i >= 0; i--) siftDown(arr, i, n - 1);
	for (int i = n - 1; i >= 1; i--)
	{
		int temp = arr[0];
		arr[0] = arr[i]; arr[i] = temp;
		siftDown(arr, 0, i - 1);
	}
}

int main() {
    printf("input min value\n"); int min; scanf("%d", &min);
    printf("input max value\n"); int max; scanf("%d", &max);
    int *data;
    srand(time(NULL));
	int count = 100;
	while(
		count < 10000000){
    data = malloc(count * sizeof(int));
		for(size_t i = 0; i < count; ++i) {
			data[i] = min + rand() % max;
		}
		struct timeval start, end;
		gettimeofday(&start, NULL);
		heapSort(data, count);
		gettimeofday(&end, NULL);
		double dtime = (double)(end.tv_usec - start.tv_usec);
		printf("%d sorted in %f uSec\n", count, dtime);
		free(data);
		count *= 10;
	}
	scanf("%d", &max);
	return 0;
}

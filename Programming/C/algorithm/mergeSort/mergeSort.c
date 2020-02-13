#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>
#include <time.h>

void mergeSort(int *a, int l, int r)
{
	if (l == r) return;
	int mid = (l + r) / 2;
	mergeSort(a, l, mid);
	mergeSort(a, mid + 1, r);
	int i = l;
	int j = mid + 1;
	int *tmp = (int*)malloc(r * sizeof(int));
	int step;
	for (step = 0; step < r - l + 1; step++)
	{
		if ((j > r) || ((i <= mid) && (a[i] < a[j])))
		{
			tmp[step] = a[i];
			i++;
		}
		else
		{
			tmp[step] = a[j];
			j++;
		}
	}
	for (step = 0; step < r - l + 1; step++)
		a[l + step] = tmp[step];
}
int main() {
	setlocale(LC_CTYPE, "");

  printf("input min\n"); int min; scanf("%d", &min);
  printf("input max\n"); int max; scanf("%d", &max);
  int *data;
  srand(
	time(NULL));
	int count = 100;
	while(
		count < 10000000){
    data = malloc(count * sizeof(int));
		int i;
		for(i = 0; i < c; ++i) {
			data[i] = min + rand() % max;
		}
		struct timeval start, end;
		gettimeofday(&start, NULL);
		mergeSort(data, 0, c-1);
		gettimeofday(&end, NULL);
		double dtime = (double)(end.tv_usec - start.tv_usec);
		printf("%d sorted in %f usec\n", count, dtime);
		free(data);
		count *= 10;
	} scanf("%d", &max);
	return 0;
}

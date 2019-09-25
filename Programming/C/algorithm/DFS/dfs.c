#include<stdio.h>
#include <locale.h>

int data[20][20],
		range[20],
			n;

void dfcLogic(int value) {
	range[value]=1;
	for (size_t i = 1; i <= n ; i++)
	if(data[value][i] && !range[i]) {
		printf("\n %d 🠒 %d", value, i);
		dfcLogic(i);
	}
}

int main() {
	setlocale(LC_CTYPE, "");

	int j, count=0;
	FILE *dfsData = fopen("DFS.txt", "rt");

	printf("\nNumber of vertices: ");
	fscanf(dfsData, "%d", &n);
	printf("%d", n);
	for (size_t i = 1 ; i <= n ; i++) {
		range[i]=0;
		for (size_t j = 1; j <= n ; j++) data[i][j]=0;
	}
	printf("\nAdjacency matrix: \n");
	for (size_t i = 1 ; i <= n; i++){
		for (size_t j = 1 ; j <= n ; j++){
			fscanf(dfsData,"%d",&data[i][j]);
			printf("%d\t", data[i][j]);
		}
		printf("\n");
	} dfcLogic(1);
	printf("\n");
	for (size_t i = 1 ;i <= n; i++) {
		if(range[i]) count++;
	}
	if(count==n) printf("\nCount connected");
	else printf("\nCount not connected");
	return 0;
}

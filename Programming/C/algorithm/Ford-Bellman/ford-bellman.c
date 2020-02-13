/* input
10 18
0 1 3
0 2 5
0 4 4
1 4 1
2 4 2
2 3 2
3 4 -1
1 7 4
4 7 -2
4 6 3
3 5 3
5 6 2
7 6 2
7 9 5
6 9 2
6 8 5
5 8 4
8 9 5
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <limits.h>

struct Edge {
	int src, dest, weight;
};

struct Graph {
	int V, E;
	struct Edge* edge;
};

struct Graph* createGraph(int V, int E) {
	struct Graph* graph = (struct Graph*) malloc( sizeof(struct Graph) );
	graph->V = V;
	graph->E = E;
	graph->edge = (struct Edge*) malloc( graph->E * sizeof( struct Edge ) );
	return graph;
}
void printArr(int dist[], int n){
  printf("Vertex   Distance from Source\n");
  int i;
  for (i = 0; i < n; ++i)
    printf("%d \t\t %d\n", i, dist[i]);
}
void BellmanFord(struct Graph* graph, int src) {
  int V = graph->V;
  int E = graph->E;
  int dist[V];
  for (size_t i = 0; i < V; i++) dist[i]   = INT_MAX;
  dist[src] = 0;
  for (size_t i = 1; i <= V-1; i++)
  {
    for (size_t j = 0; j < E; j++)
    {
      int u = graph->edge[j].src;
      int v = graph->edge[j].dest;
      int weight = graph->edge[j].weight;
      if (dist[u] + weight < dist[v]) dist[v] = dist[u] + weight;
    }
  }
  for (size_t i = 0; i < E; i++)
  {
      int u = graph->edge[i].src;
      int v = graph->edge[i].dest;
      int weight = graph->edge[i].weight;
      if (dist[u] + weight < dist[v]) printf("Graph contains negative weight cycle");
  }
  printArr(dist, V);
  return;
}
int main()
{
  int V = 10; int E = 18;
  scanf("%d",&V); scanf("%d",&E);
  struct Graph* graph = createGraph(V, E);
  int i;
  for(size_t i = 0; i < E; i++){
    scanf("%d",&graph->edge[i].src);
    scanf("%d",&graph->edge[i].dest);
    scanf("%d",&graph->edge[i].weight);
  }
  BellmanFord(graph, 0);
  return 0;
}

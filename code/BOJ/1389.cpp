#include <iostream>

using namespace std;

#define INF 987654321
#define NIL -1
#define MAX 101

int graph[MAX][MAX];
int before[MAX][MAX];

void floyd(int n){
    for (int mid=1;mid<=n;mid++){
        for (int start=1;start<=n;start++){
            for (int end=1;end<=n;end++){
                if (graph[start][end] > graph[start][mid] + graph[mid][end]){
                    graph[start][end] = graph[start][mid] + graph[mid][end];
                    before[start][end] = before[mid][end];
                    
                }
            }
        }
    }
}

int main(){
    int n,m;
    cin >> n >> m;

    for (int i=1;i<=n;i++){
        for (int j=1;j<=n;j++){
            graph[i][j] = MAX;
            if (i==j) graph[i][j] = 0;
            before[i][j] = NIL;
        }
    }
    
    for (int i=0;i<m;i++){
        int node1, node2;
        cin >> node1 >> node2;
        graph[node1][node2] = 1;
        graph[node2][node1] = 1;
        before[node1][node2] = node1;
        before[node2][node1] = node2;
    }
    
    floyd(n);
    
    
    int sum=0;
    int min=MAX;
    int result;
    for (int i=1;i<=n;i++){
        sum=0;
        for (int j=1;j<=n;j++){
            sum+=graph[i][j];
        }
        if (min>sum){
          min = sum;
          result=i;
        }
    }
    cout << result << endl;

}
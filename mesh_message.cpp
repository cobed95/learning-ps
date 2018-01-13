#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> mesh {
    {1, 2, 8},
    {0, 7},
    {0, 4, 3, 7},
    {2, 8},
    {2, 5, 6},
    {4, 6},
    {4, 5},
    {2, 1},
    {3, 0},
};

vector<int> color;
vector<int> d;
vector<int> pi;
vector<int> q;

int head = 0;
int tail = 0;

void debug(vector<int>& list) {
  for (auto e: list)
    cout << e << ", ";
  cout << endl;
}

void enqueue(vector<int>& q, int& x) {
  
  q[tail] = x;
  
  if (tail == q.size()-1)
    tail = 0;
  
  else
    tail += 1;

}

int dequeue(vector<int>& q) {
  
  int x = q[head];
  
  if (head == q.size()-1)
    head = 0;
  
  else
    head += 1;
  
  return x;

}

void bfs(vector<vector<int>>& mesh, int& start) {
    
  color[start] = 1;
  d[start] = 0;

  enqueue(q, start);
  
  while (head != tail) {
    
    int u = dequeue(q);
    
    for (auto v: mesh[u]) {
      
      if (color[v] == 0) {
        color[v] = 1;
        d[v] = d[u] + 1;
        pi[v] = u;
        enqueue(q, v);
      }
    }
  }
}

vector<int> find_shortest_path(vector<vector<int>>& mesh, int start, int end) {
   
  vector<int> shortest_path {};
  
  bfs(mesh, start);

  int stop = end;
  
  while (stop != start) {
    shortest_path.push_back(stop);
    stop = pi[stop];
  } 
  shortest_path.push_back(start);
  
  return shortest_path;
}

int main() {
  
  color.resize((int)mesh.size(), 0);
  d.resize((int)mesh.size());
  pi.resize((int)mesh.size());
  q.resize((int)mesh.size());

  vector<int> shortest_path = find_shortest_path(mesh, 2, 5);
  
  for (auto e: shortest_path) 
      cout << e << ", ";
  cout << endl;
  
  return 0;
}

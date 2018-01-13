#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> get_adj_lst(vector<int>& sequence) {

  int n = (int)sequence.size()-1;
  vector<vector<int>> adj_lst (n);

  for (int i = 0; i < (int)sequence.size(); i++) {
    
    if (i == 0)
      adj_lst[sequence[i]].push_back(sequence[i+1]);

    else if (i == (int)sequence.size()-1)
      adj_lst[sequence[i]].push_back(sequence[i-1]);

    else {
      adj_lst[sequence[i]].push_back(sequence[i-1]);
      adj_lst[sequence[i]].push_back(sequence[i+1]);
    }
  }
  
  return adj_lst;
}

vector<int> count_edges(vector<int>& sequence) {
  
  vector<vector<int>> adj_lst = get_adj_lst(sequence);
  vector<int> edges ((int)adj_lst.size(), 0);

  for (int i = 0; i < (int)sequence.size(); i++) {
    for (int j = 0; j < (int)adj_lst[i].size(); j++)
      edges[adj_lst[i][j]] += 1;
  }

  return edges;
}

int find_repeat(vector<int>& sequence) {
  
  vector<int> edges = count_edges(sequence);

  for (int i = 0; i < (int)sequence.size(); i++) {
    if (edges[i] > 2) 
      return i;
  }
}

int main() {
  vector<int> sequence {3, 1, 2, 0, 1, 4};
  cout << find_repeat(sequence) << endl;

  return 0;
}

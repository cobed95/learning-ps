#include <iostream>
#include <vector>
#include <queue>

using namespace std;

queue<pair<int, int>> q {};

vector<int> get_direction(vector<vector<bool>>& matrix, pair<int, int> coordinate) {
    
    vector<int> direction (4, 0);

    if (coordinate.first < (int)matrix[0].size()-1 && matrix[coordinate.first+1][coordinate.second] == false) 
        direction[0] = 1;
    else direction[0] = 0;

    if (coordinate.first > 0 && matrix[coordinate.first - 1][coordinate.second] == false)
        direction[1] = 1;
    else direction[1] = 0;
    
    if (coordinate.second < (int)matrix.size()-1 && matrix[coordinate.first][coordinate.second+1] == false)
        direction[2] = 1;
    else direction[2] = 0;
    
    if (coordinate.second > 0 && matrix[coordinate.first][coordinate.second-1] == false)
        direction[3] = 1;
    else direction[3] = 0;
 
    return direction;
}

vector<pair<int, int>> find_shortest_path(vector<vector<bool>>& matrix, pair<int, int>& s) {

    vector<vector<int>> color ((int)matrix.size()); 

    for (int i = 0; i < (int)matrix.size(); i++) {
        for (int j = 0; j < (int)matrix[i].size(); j++) 
            color[i].push_back(0);
    }

    color[s.first][s.second] = 1;

    vector<vector<pair<int, int>>> pi ((int)matrix.size());

    for (int i = 0; i < (int)matrix.size(); i++) {
        for (int j = 0; j < (int)matrix[i].size(); j++) {
            pair<int, int> pi_init (0, 0);
            pi[i].push_back(pi_init);
        }
    }

    q.push(s);

    while (!q.empty()) {

        pair<int, int> u = q.front();
        q.pop();

        cout << u.first << "," << u.second << endl;
        
        vector<int> u_direction = get_direction(matrix, u);

        for (auto e: u_direction) 
            cout << e << endl;

        if (u_direction[0] == 1 && color[u.first+1][u.second] == 0) {
          pair<int, int> v (u.first+1, u.second);
          cout << v.first << " " << v.second << endl;
          color[v.first][v.second] = 1;
          pi[v.first][v.second].first = u.first;
          pi[v.first][v.second].second = u.second;
          q.push(v);
        }

        if (u_direction[1] == 1 && color[u.first-1][u.second] == 0) {
          pair<int, int> v (u.first-1, u.second);
          color[v.first][v.second] = 1;
          q.push(v);
          pi[v.first][v.second].first = u.first;
          pi[v.first][v.second].second = u.second;
        }

        if (u_direction[2] == 1 && color[u.first][u.second+1] == 0) {
          pair<int, int> v (u.first, u.second+1);
          color[v.first][v.second] = 1;
          q.push(v);
          pi[v.first][v.second].first = u.first;
          pi[v.first][v.second].second = u.second;
        }

        if (u_direction[3] == 1 && color[u.first][u.second-1] == 0) {
          pair<int, int> v (u.first, u.second-1);
          color[v.first][v.second] = 1;
          q.push(v);
          pi[v.first][v.second].first = u.first;
          pi[v.first][v.second].second = u.second;
        }
    }

    vector<pair<int, int>> map {};

    pair<int, int> stop ((int)matrix[0].size()-1, (int)matrix.size()-1);

    while (stop.first != 0 && stop.second != 0) {
      map.push_back(stop);
      stop.first = pi[stop.first][stop.second].first;
      stop.second = pi[stop.first][stop.second].second;
    }

    return map;

}

int main() {
  vector<vector<bool>> matrix {
    {false, true, true},
    {false, true, true},
    {false, false, false}
  };

  pair<int, int> s (0, 0);

  vector<pair<int, int>> map = find_shortest_path(matrix, s);

  for (auto e: map) 
    cout << "(" << e.first << "," << e.second << ") ";

  cout << endl;
}

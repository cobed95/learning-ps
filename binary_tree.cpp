//This is an incomplete solution.
//1. It does not actually build a binary tree.
//2. The recursive function "build_binary_tree" has termination issues

#include <iostream>
#include <vector>

using namespace std;

void insertion_sort (vector<int>& array) {
  
  for (int i = 1; i < (int)array.size(); i++) {
  
    int key = array[i];
    int j = i-1;

    while (key < array[j] && j >= 0) {
      array[j+1] = array[j];
      j -= 1;
    }

    array[j+1] = key;

  }
  
}

void build_binary_tree (vector<int> array, int s) {

  int left = (s*2) + 1;
  int right = left + 1;

  vector<int> candidates {};

  if (right < (int)array.size()) {
    candidates.push_back(array[left]);
    candidates.push_back(array[s]);
    candidates.push_back(array[right]);
  }

  else if (left < (int)array.size()) {
    candidates.push_back(array[left]);
    candidates.push_back(array[s]);
  }
  
  insertion_sort(candidates);

  if ((int)candidates.size() == 2) {
    array[left] = candidates[0];
    array[s] = candidates[1];
  }

  else if ((int)candidates.size() == 3) {
    array[left] = candidates[0];
    array[s] = candidates[1];
    array[right] = candidates[2];
  }

}

int main () {
  
  vector<int> array {0,1,2,3,4,5,6,7,8,9};

  build_binary_tree(array, 0);

  for (auto e: array)
    cout << e << ", ";

  cout << endl;

  return 0;

}

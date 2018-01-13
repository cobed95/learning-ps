#include <iostream>
#include <vector>

using namespace std;

void print (vector<int> array) {
  
  for (auto e: array)
    cout << e << ", "; 

  cout << endl;

}

int count_zeros(vector<int>& array) {
  
  int count = 0;

  for (int i = 0; i < (int)array.size(); i++) {
    if (array[i] == 0)
      count += 1;
  }
  
  return count;

}

void swap (vector<int>& array, int i, int j) {
  
  int temp = array[i];
  array[i] = array[j];
  array[j] = temp;

}

vector<int> push_zeros(vector<int> array) {
  
  int count = count_zeros(array);

  int back = (int)array.size()-1;

  for (int i = 0; i < (int)array.size()-count; i++) {
    
    if (array[i] == 0) {
      
      if (array[back] == 0)
        back -= 1;
      
      swap(array, i, back);

      back -= 1;

    }

  }
  
  return array;

}

int main() {
  
  vector<int> array {0,5,3,2,0,4,6,0,3,0};

  vector<int> new_array = push_zeros(array);

  print(new_array);

  return 0;

}

#include <iostream>
#include <vector>

void max_heapify(std::vector<int>& A, int i, int heapsize){
  int l = (2*i)+1;
  int r = (2*i)+2;
  int largest = i;
  if (l < heapsize && A[l] > A[largest])
    largest = l;
  if (r < heapsize && A[r] > A[largest])
    largest = r;
  if (largest != i){
    int temp = A[i];
    A[i] = A[largest];
    A[largest] = temp;
    max_heapify(A, largest, heapsize);
  }
}

void build_max_heap(std::vector<int>& A){
  for (int i = (A.size()/2)-1; i >= 0; i--){
    max_heapify(A, i, A.size());
  }
}

void heapsort(std::vector<int>& A){
  build_max_heap(A);
  for (int i = A.size()-1; i > 0; i--){
    int temp = A[0];
    A[0] = A[i];
    A[i] = temp;
    max_heapify(A, 0, i);
  }
}

bool check_for_movie(std::vector<int>& movie_list, int flight_length){
  
  for (int i = 0; i < movie_list.size()-1; i++){
    
    int j = movie_list.size()-1;
    
    while (j > i && movie_list[i] + movie_list[j] > flight_length){
    
      j -= 1;

    } 

    if (movie_list[i] + movie_list[j] == flight_length)
      
      return true;
  
  }

  return false;

}

int main(){
  std::vector<int> A {5,4,1,2,32,5,7,8,2,23,34,5,6,1,1};
  heapsort(A);
  if (check_for_movie(A, 100) == true){
    std::cout << "True" << std::endl;
  }
  else{
    std::cout << "False" << std::endl;
  } 
}

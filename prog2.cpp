#include <iostream>

void hanoi(char A, char B, char C, int n){

  if (n == 1){
    std::cout << A << " to " << C << std::endl;
  }
  else{
    hanoi(A, C, B, n-1);
    std::cout << A << " to " << C << std::endl;
    hanoi(B, A, C, n-1);
  }
}
int main(void){
  hanoi('A', 'B', 'C', 4);
  return 0;
}

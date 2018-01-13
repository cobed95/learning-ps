#include <iostream>

void hanoi(int n, char A, char B, char C)
{
  if (n == 1)
  {
    std::cout << A << " to " << C << std::endl;
  }
  else
  {
    hanoi(n-1, A, C, B);
    std::cout << A << " to " << C << std::endl;
    hanoi(n-1, B, A, C);
  }
}

int main()
{
  hanoi(4, 'A', 'B', 'C');
  return 0;
}

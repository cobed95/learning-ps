#include <iostream>

int Get_Num_From_User()
{
  std::cout << "Enter a number:";
  int x;
  std::cin >> x;
  return x;
}

int main()
{
  int x = Get_Num_From_User();
  int y = Get_Num_From_User();
  std::cout << x << " + " << y << " = " << x + y << std::endl;
  return 0;
}


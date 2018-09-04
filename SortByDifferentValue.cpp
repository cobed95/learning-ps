#include <iostream>
#include <vector>

using namespace std;

void merge(vector<int>& list, int p, int q, int r) {
    vector<int> left;
    for (int i = p; i < q + 1; i++) {
        left.push_back(list[i]);
    }
    vector<int> right;
    for (int j = q + 1; j < r + 1; j++) {
        right.push_back(list[j]);
    }

    int i, j = 0;
    for (int k = p; k < r + 1; k++) {
        
    }
}

void mergesort(vector<int>& list, int p, int r) {

}

int main() {
    return 0;
}

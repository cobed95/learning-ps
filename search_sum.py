def search_sum(A, x):
    merge_sort(A)
    for i in range((x//2)+1):
        b = x - A[i]
        if binary_search(A, b, x//2, A[-1]) == True:
            return True
        else: 
            return False

def search_sum_in_n(A, x):
    L = [0] * len(A)
    R = [0] * len(A)
    for i in range(len(A)):
        L[i] = A[i]
    for j in range(len(A)):
        R[j] = A[len(A)-1-j]
    i = 0
    j = 0
    while i < len(A) and j < len(A):
        if L[i] + R[j] == x:
            return True
        elif L[i] + R[j] > x:
            j += 1
        else:
            i += 1

def search_sum_simple(A, x):
    i, j = 0, len(A)-1
    while i < j: 
        print(i, j)
        print(A[i], A[j])
        while i < j and A[i] + A[j] > x: 
            j -= 1
        if A[i] + A[j] == x:
            return True
        if A[i] +A[j] < x:
            i += 1

def main():
    A = [1,2,6,7,8,9,10,13,16,17,29]
    if search_sum_simple(A, 29) == True:
        print("Take this Gaji")
    if search_sum_simple(A, 100) == True:
        print("You didn't expect")

if __name__ == '__main__':
    main()

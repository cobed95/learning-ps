def selection_sort(A):
    for i in range(len(A)-1):
     smallest = A[i]   
     for j in range(i+1, len(A)):
        if A[j] < smallest:
            smallest = A[j]
     A[i], smallest = smallest, A[i]



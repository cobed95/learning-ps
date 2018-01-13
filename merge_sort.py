def merge(A, p, q, r):
    L = [0] * (q-p+1)
    R = [0] * (r-q)
    for i in range(len(L)):
        L[i] = A[p+i]
    for j in range(len(R)):
        R[j] = A[q+j+1]
    i = 0
    j = 0
    for k in range(p, r+1):
        if i >= len(L):
            A[k] = R[j]
            j += 1
        elif j >= len(R):
            A[k] = L[i]
            i += 1
        elif L[i] <= R[j]:
            A[k] = L[i]
            i += 1
        else:
            A[k] = R[j]
            j += 1

def merge_sort_aux(A, p, r):
    if p < r:
        q = (p+r)//2
        merge_sort_aux(A, p, q)
        merge_sort_aux(A, q+1, r)
        merge(A, p, q, r)

def merge_sort(A):
    merge_sort_aux(A, 0, len(A)-1)
    

def binary_search(A, v):
    p = 0
    r = len(A)-1
    while p < r:
        q = (p+r)//2
        if A[q] >= v:
            r = q
        else:
            p = q+1
    if A[p] >= v:
        return p
    else:
        return None

##[0,1,2,3,4]

def binary_insertion_sort(A):
    for i in range(1, len(A)):
        key = A[i]
        idx = binary_search(A[:i], key)
        if idx == None:
            A[i] = key
        else:
            for j in range(i-1, idx-1, -1):
                A[j+1] = A[j]
            A[idx] = key

def main():
    A = [8,2,45,5,1,34,6,2,3]
    binary_insertion_sort(A)
    print(A)

if __name__ == '__main__':
    main()

##[1,2,5,6,8,34,45,2,3]

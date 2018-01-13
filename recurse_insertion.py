def insertion_sort(A):
    for i in range(1, len(A)):
        key = A[i]
        j = i-1
        while j >= 0 and key < A[j]:
            A[j+1] = A[j]
            j -= 1
        A[j+1] = key

def recurse_insertion(A, n):
    if n == 1:
        A[0] = A[0]
    elif n > 1:
        recurse_insertion(A, n-1)
        key = A[n-1]
        i = n-2
        while i >= 0 and key < A[i]:
            A[i+1] = A[i]
            i -= 1
        A[i+1] = key

def main():
    A = [6,1,3,4,2]
    recurse_insertion(A, 5)
    print(A)

if __name__ == '__main__':
    main()

def insertion_sort(A):
    for i in range(1, len(A)):
        key = A[i]
        j = i-1
        while j >= 0 and key < A[j]:
            A[j+1] = A[j]
            j -= 1
        A[j+1] = key

def main():
    A = [6,5,4,3,2,1]
    insertion_sort(A)
    print(A)

if __name__ == '__main__':
    main()

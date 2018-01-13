def multiply_all_but_self(A):
    left = [0] * len(A)
    left[0] = 1
    for i in range(1, len(left)):
        left[i] = left[i-1] * A[i-1]
    right = [0] * len(A)
    right[-1] = 1
    for i in range(len(right)-2, -1, -1):
        right[i] = right[i+1] * A[i+1]
    for i in range(len(A)):
        A[i] = left[i] * right[i]
    return A

def main():
    A = [1,2,3,4,5]
    print(multiply_all_but_self(A))

if __name__ == '__main__':
    main()

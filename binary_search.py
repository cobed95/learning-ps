def binary_search(A, p, r, v):
    if p < r:                               ##c1
        q = (p+r)//2                        ##c2
        if A[q] >= v:                       ##c3
            binary_search(A, p, q, v)       ##T(n/2)
        else:                               ##c5
            binary_search(A, q+1, r, v)     ##T(n/2)
    elif A[p] == v:                         ##c6
        print(p)                            ##c7
    else:                                   ##c8
        return None                         ##c9

##T(n) = {a (if n == 1)} {T(n/2) + a (if n > 1)}
##if n = 2^k
##T(2^0) = a = lg(2^0) + a
##T(2^k) = lg(2^k) + a
##T(2^k+1) =(lg(2^k) + a) + b = (k+1) = k+1 a + b - 1 = lg(2^(k+1)) + c
##T(n) = lg(n) (if n = 2^k, k = int)

def main():
    A = [1,2,3,4,5,6,7,8,9,10]
    binary_search(A, 0, len(A)-1, 9)
    iterative_binary_search(A, 4)

if __name__ == '__main__':
    main()

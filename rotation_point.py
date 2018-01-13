def rotation_point(A, lo, hi):
    alphabets = [
            'a', 'b', 'c', 'd', 'e', 
            'f', 'g', 'h', 'i', 'j', 
            'k', 'l', 'm', 'n', 'o', 
            'p', 'q', 'r', 's', 't', 
            'u', 'v', 'w', 'x', 'y', 
            'z'
            ]
    if lo == hi:
        return lo
    else:
        mid = (lo+hi)//2
        if A[mid][0] <= len(alphabets)//2:
            rotation_point(A, lo, mid)
        else:
            rotation_point(A, mid+1, hi)

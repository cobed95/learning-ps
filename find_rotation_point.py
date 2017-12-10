alphabets = [
        0,'a','b','c','d','e',
        'f','g','h','i','j','k',
        'l','m','n','o','p','q',
        'r','s','t','u','v','w',
        'x','y','z'
        ]

def get_alphabet_index(string, k):
    if k >= len(string):
        return 0
    for i in range(len(alphabets)):
        if string[k] == alphabets[i]:
            return i

def get_largest_length(A):
    longest_word = A[0]
    largest_length = len(A[0])
    for i in range(1, len(A)):
        if len(A[i]) > len(longest_word):
            longest_word = A[i]
            largest_length = len(A[i])
    return largest_length

def find_rotation_point_in_O_of_N(A):
    largest_length = get_largest_length(A)
    ##converts strings to 27-ary integers.
    int_list = [0] * len(A)
    for i in range(len(A)):
        for j in range(largest_length-1, -1, -1):
            int_list[i] = int_list[i]*27 + get_alphabet_index(A[i], largest_length-1-j)
    for i in range(1, len(int_list)):
        if int_list[i] < int_list[i-1]:
            return i

def main():
    A = ['bbjil', 'cliasjd', 'eiafosj', 'filghj', 'ba', 'babb', 'bac']
    print(find_rotation_point_in_O_of_N(A))

if __name__ == '__main__':
    main()

##for all d values

def search_for_sum_equal_multiple(A, d):
    count = 0
    for i in range(0, len(A)-1):
        j = i+1
        while j < len(A):
            sum = 0
            for k in range(i, j+1):
                sum += A[k]
            if sum%d == 0:
                count += 1
            j += 1
    return count

##O(n) solution

def search_for_range_mult_simple(A, d):
    sum_candidates = [0] * (len(A)+1)
    for i in range(1, len(sum_candidates)):
        sum_candidates[i] = A[i-1]
    sum_lst = [0] * len(sum_candidates)
    for i in range(len(sum_lst)-1):
        sum_lst[i+1] = sum_lst[i] + sum_candidates[i+1]
    book = [0] * d
    exception = 0
    for i in range(len(sum_lst)):
        remainder = sum_lst[i]%d
        book[remainder] += 1
        if i < len(sum_lst)-1 and remainder == sum_lst[i+1]%d:
            exception += 1
    count = 0
    for i in range(len(book)):
        count += (book[i]*(book[i]-1))//2
    count -= exception
    return count

##O(n). Counting and book-keeping simultaneously.

def search_without_asterisk(A, d):
    sum_candidate = [0] * (len(A)+1)
    for i in range(1, len(sum_candidate)):
        sum_candidate[i] = A[i-1]
    sum_lst = [0] * (len(sum_candidate))
    for i in range(1, len(sum_lst)):
        sum_lst[i] = sum_lst[i-1] + sum_candidate[i]
    book = [0] * d
    count = 0
    for i in range(len(sum_lst)):
        remainder = sum_lst[i]%d
        if i != 0 and remainder == sum_lst[i-1]%d:
            count += book[remainder]-1
        else:
            count += book[remainder]
        book[remainder] += 1
    return count

def main():
    A = [1,2,3,4,5]
    print(search_without_asterisk(A, 3))

if __name__ == '__main__':
    main()

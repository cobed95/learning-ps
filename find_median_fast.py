def binary_search_for_position(A, k, lo, hi):
    if hi-(lo-1) > 2:
        mid = (lo+hi)//2
        if A[mid] >= k:
            binary_search_for_position(A, k, lo, mid)
        else:
            binary_search_for_position(A, k, mid+1, hi)
    elif A[lo] <= k <= A[hi]:
        return lo


def find_median_fast(A, k):
    
    partition_addresses = [A[0]]
    
    for i in range(1, len(partition_addresses)):
        partition_addresses.append(partition_addresses[i-1]+A[i])
    
    position = binary_search_for_position(A, k, 0, len(A)-1)
    
    left_addresses = partition_addresses[:position+1]
    right_addresses = partition_addresses[position:len(partition_addresses)]
    
    for i in range(len(right_addresses)):
        right_addresses[i] += k
    
    partition_addresses = left_addresses + right_addresses
    
    length = partition_addresses[-1]
    
    if length%2 == 0:
        median_address = (length-1)//2, ((length-1)//2)+1
    else:
        median_address = (length-1)//2, (length-1)//2
    
    left_median = binary_search(partition_addresses, median_address[0], 0, len(partition_addresses)-1)
    right_median= binary_search(partition_addresses, median_address[1], 0, len(partition_addresses)-1)
    
    if left_median == right_median:
        return A[left_median]
    else: 
        return (A[left_median]+A[right_median])//2
   
def main():
    A = [1,2,3,5,6]
    k = 4
    print(find_median_fast(A, k))

if __name__ == '__main__':
    main()

def snd(pair):
    return pair[1]

def insertion_sort(A):
    for i in range(1, len(A)):
        key = A[i]
        j = i-1
        while j >= 0 and A[j] > key:
            A[j+1] = A[j]
            j -= 1
        A[j+1] = key

def min_heapify(A, i, heap_size):
    l = 2*i
    r = (2*i)+1
    if l < heap_size and snd(A[l]) < snd(A[i]):
        smallest = l
    else:
        smallest = i
    if r < heap_size and snd(A[r]) < snd(A[smallest]):
        smallest = r
    if smallest != i:
        A[i], A[smallest] = A[smallest], A[i]
        min_heapify(A, smallest, heap_size)

def build_min_heap(A, heap_size):
    for i in range((heap_size//2)-1, -1, -1):
        min_heapify(A, i, heap_size)

def k_way_merge_sort(A, k):
    partition_len = len(A)//k
    partitions = []
    for i in range(k):
        partitions.append(A[partition_len*i:partition_len*(i+1)])
    print(partitions)
    for partition in partitions:
        insertion_sort(partition)
    print(partitions)
    ptrs = [0] * len(partitions)
    for i in range(len(A)):
        print(ptrs)
        candidates = [partitions[idx][ptr] for idx, ptr in enumerate(ptrs) if ptr < len(partitions[idx])]
        print(candidates)
        candidates_min_heap = list(enumerate(candidates))
        print(candidates_min_heap)
        aux = build_min_heap(candidates_min_heap, len(candidates))
        print(aux)
        A[i] = snd(candidates_min_heap[0])
        ptrs[candidates_min_heap[0][0]] += 1

def main():
    A = [8,6,43,1,4,7,3,4,5,67,1,2]
    k_way_merge_sort(A, 3)
    print(A)

if __name__ == '__main__':
    main()

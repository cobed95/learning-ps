def swap(string, p, q):
    left = string[: p]
    mid = string[p + 1 : q]
    right = string[q + 1 :]
    result = left + string[q] + mid + string[p] + right
    return result

#def permute(list, string, start):
#    if start == len(string) - 2:
#        list.append(swap(string, start, len(string) - 1))
#    else:
#        list.append(string)
#        for i in range(start, len(string)):
#            for j in range(i + 1, len(string)):
#                list.append(swap(string, i, j))
#        permute(list, string, start + 1)

def permute(list, string):
    print(list)
    print(string)
    print(len(string))
    if len(string) == 1:
        list.append(string)
    for i in range(len(string)):
        left = string[ : i]
        right = string[i + 1 : ]
        permute(list, left + right)
        list = [string[i] + element for element in list]

def main():
    list = []
    permute(list, 'abcde')
    print(list)

if __name__ == '__main__':
    main()

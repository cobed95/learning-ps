#fibanacci in O(n)

def fibonacci(n):
    if n == 0 or n == 1:
        return 1
    else:
        return fibonacci(n-1)+fibonacci(n-2)

#fibonacci in less than O(n)

def fibonacci_simple(n):
    generator = [[1,1],[1,0]]
    pair = [1,1]
    for i in range(n):
        pair[0], pair[1] = (generator[0][0] * pair[0])+(generator[0][1] * pair[1]), (generator[1][0] * pair[0])+(generator[1][1] * pair[1])
    def snd(pair):
        return pair[1]

    return snd(pair)
        

def main():
    print(fibonacci_simple(5))

if __name__ == '__main__':
    main()

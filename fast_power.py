def slow_power(a, k):
    for i in range(k-1):
        a = a*a
    return a

def fast_power(a, k):
    if k >= 2 and k % 2 == 0:
        q = k//2
        aux_answer = fast_power(a, q)
        answer = aux_answer * aux_answer
    elif k >= 2 and k % 2 != 0:
        q = k//2
        aux_answer = fast_power(a, q)
        answer = aux_answer * aux_answer * a
    else:
        answer = a
    return answer

def fast_power_simple(a, k):
    if k == 0:
        return 1

    base = fast_power_simple(a, k//2)

    elif k % 2 == 0:
        return base*base
    else:
        return base*base*a

def main():
    a = 2
    k = 10
    print(fast_power(a, k))

if __name__ == '__main__':
    main()

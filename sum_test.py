class Eundo:
    def __init__(self, lo, hi):
        self.lo = lo
        self.hi = hi

    def __iter__(self):
        return self

    def __next__(self):
        if self.lo > self.hi:
            raise StopIteration
        else:
            self.lo += 1
            return self.lo - 1

def main():
    for eundo in Eundo(1, 10):
        print(eundo)

    print(sum(Eundo(1,10)))

if __name__ == '__main__':
    main()

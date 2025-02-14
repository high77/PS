import sys
input = sys.stdin.readline

def main():

    n = int(input())

    dict_ = {}
    for i in range(n):
        before, after = input().rstrip().split()
        dict_[before] = after

    m = int(input())

    for i in range(m):
        c = input().rstrip()
        print(dict_.get(c, c), end ="")


if __name__ == "__main__":
    main()
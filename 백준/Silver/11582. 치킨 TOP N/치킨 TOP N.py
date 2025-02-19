import sys
input = sys.stdin.readline



def main():
    N = int(input())
    list_ = list(map(int,input().split()))
    K = int(input())
    for i in range(0,N,N//K):
        list_[i:i+N//K]=sorted(list_[i:i+N//K])
    print(*list_)


if __name__ == "__main__":
    main()

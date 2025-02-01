import sys
input = sys.stdin.readline


def main():
    N = int(input())
    list_ = [int(input()) for _ in range(N)]
    for i in range(N):
        tmp = list_[i]
        for j in range(1,N):
            if (j%2==1) : tmp-=list_[(i+j)%N]
            else : tmp+=list_[(i+j)%N]
        print(tmp//2)




if __name__ == "__main__":
    main()

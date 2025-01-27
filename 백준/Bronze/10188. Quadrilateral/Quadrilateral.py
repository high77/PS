import sys
input = sys.stdin.readline


def main():
    N = int(input())
    for tc in range(N):
        n,m = map(int,input().split())
        for i in range(m):
            print("X"*n)
        print()





if __name__ == "__main__":
    main()

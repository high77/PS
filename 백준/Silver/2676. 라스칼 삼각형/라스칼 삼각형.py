import sys
input = sys.stdin.readline



def main():
    T = int(input())
    for _ in range(T):
        n,m = map(int,input().split())
        print(1+(n-m)*m)





if __name__ == "__main__":
    main()

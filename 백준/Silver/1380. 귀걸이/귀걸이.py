import sys
input = sys.stdin.readline

def main():
    T = 0
    while True:
        N = int(input())
        if N==0: break
        T+=1
        name = []
        check = [False]*N
        for _ in range(N):name.append(input().rstrip())
        for _ in range(2*N-1):
            input_ = input().rstrip().split()
            n = int(input_[0])-1
            check[n] = True if not check[n] else False
        for i in range(N):
            if check[i]:
                print(T,name[i])
main()
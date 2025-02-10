import sys
input = sys.stdin.readline



def main():
    N = int(input())
    list_ = list(map(int,input().split()))
    K = int(input())
    e=0
    ans = 0
    res = 0
    for i in range(N):
        flag = True
        while True :
            if res > K:
                flag = False
                ans +=N-e+1
                break
            if e==N : break
            res += list_[e]
            e+=1
        if flag : break
        res-=list_[i]
    print(ans)




if __name__ == "__main__":
    main()

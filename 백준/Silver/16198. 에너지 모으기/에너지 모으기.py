import sys
input = sys.stdin.readline

def f(k,curV):
    global N,list_,visit,ans
    if k==N-2:
        ans = max(curV,ans)
        return
    for i in range(1,N-1):
        if not visit[i]:
            visit[i] = True
            a = 0
            for j in range(i-1,-1,-1):
                if not visit[j]:
                    a = list_[j]
                    break
            b = 0
            for j in range(i+1,N):
                if not visit[j]:
                    b = list_[j]
                    break
            f(k+1,curV+a*b)
            visit[i] = False

def main():
    global N,list_,visit,ans
    N = int(input())
    list_ = list(map(int,input().split()))
    visit = [False]*N
    ans = 0
    f(0,0)
    print(ans)

main()
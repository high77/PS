import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

def dfs(now):
    arr[now].sort(reverse=True)
    for i in arr[now]:
        if visit[i] == -1:
            visit[i] = visit[now]+1
            dfs(i)

def main():
    global visit,arr
    N,M,R = map(int,input().split())
    arr = [[] for _ in range(N+1)]
    visit = [-1]*(N+1)
    for _ in range(M):
        u,v = map(int,input().split())
        arr[u].append(v)
        arr[v].append(u)
    visit[R] = 0
    dfs(R)
    for i in range(1,N+1):
        print(visit[i])
if __name__ == "__main__":
    main()
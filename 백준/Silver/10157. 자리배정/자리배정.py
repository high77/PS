import sys
input = sys.stdin.readline

def Main():
    N,M = map(int,input().split())
    K = int(input())
    if N*M<K:
        print(0)
        return
    visit = [[False]*N for _ in range(M)]
    dx = [1,0,-1,0]
    dy = [0,1,0,-1]
    x,y=0,0
    now = 1
    flag = 0
    while now < N*M:
        visit[x][y] = True
        if now==K:break
        nx=x+dx[flag]
        ny=y+dy[flag]
        if 0>nx or nx>=M or 0>ny or ny>=N or visit[nx][ny]:
            flag=(flag+1)%4
            continue
        x=nx
        y=ny
        now +=1
    print(y+1,x+1)
Main()


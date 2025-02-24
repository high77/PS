import sys
input = sys.stdin.readline


def main():
    N,M = map(int,input().split())
    arr = [input().rstrip() for _ in range(N)]
    ans = [0]*5
    for i in range(N-1):
        for j in range(M-1):
            cnt = 0
            flag = True
            for k in range(2):
                for l in range(2):
                    if arr[i+k][j+l] =='#':
                        flag = False
                        break
                    elif arr[i+k][j+l] =='X':
                        cnt+=1
            if flag :
                ans[cnt]+=1
    for i in ans:
        print(i)



if __name__ == "__main__":
    main()

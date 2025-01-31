import sys
input = sys.stdin.readline


def main():
    N = int(input())
    arr = [[] for _ in range(N)]
    ans = 0
    res = 0
    for i in range(N):arr[i] = list(map(int, input().split()))
    for i in range(N):
        tmp = 0
        for j in range(N):
            if arr[i][0]<= arr[j][0] and arr[i][0]-arr[j][1]>0:
                tmp+=arr[i][0]-arr[j][1]
        if res < tmp:
            res = tmp
            ans = arr[i][0]
        elif res == tmp :
            ans = min(ans, arr[i][0])
    print(ans)





if __name__ == "__main__":
    main()

import sys
input = sys.stdin.readline


def f(n, k, curV):
    global ans
    if k==n:
        if curV%3==0:
            ans+=1
        return
    for i in range(3):
        if k==0 and i==0:continue
        f(n, k+1, curV+i)


def main():
    global ans
    N = int(input())
    ans =0
    f(N,0,0)
    print(ans)



if __name__ == "__main__":
    main()

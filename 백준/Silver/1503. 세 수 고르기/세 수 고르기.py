import sys
input = sys.stdin.readline


def main():
    N,M = map(int,input().split())
    set_ = set(map(int,input().split())) if M>0 else set(input().rsplit())
    ans = float('inf')
    for i in range(1,1002):
        if i in set_:continue
        for j in range(1,1002):
            if j in set_:continue
            for k in range(1,1002):
                if k in set_:continue
                tmp = i*j*k
                ans = min(ans, abs(N-tmp))
                if N<tmp: break
    print(ans)


if __name__ == "__main__":
    main()

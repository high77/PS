import sys
input = sys.stdin.readline



def main():
    N,T = map(int,input().split())
    A = list(map(int,input().split()))
    divisors = []
    for i in range(1,int(T**0.5)+1):
        if T%i!=0: continue
        divisors.append(i)
        if T//i==i:continue
        divisors.append(T // i)
    divisors.sort()
    ans = 0
    for a in A :
        min_ = float('inf')
        for divisor in divisors:
            min_ = min(min_,abs(a-divisor))
        ans+=min_
    print(ans)

if __name__ == "__main__":
    main()

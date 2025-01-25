import sys
input = sys.stdin.readline

def gcd(a,b):
    if b==0:return a
    return gcd(b,a%b)

def lcm(a,b):
    return a*b//gcd(a,b)
def main():
    N = int(input())
    list_ = list(map(int,input().split()))
    n =1
    d = list_[0]
    for i in range(1,N):
        lcm_ = lcm(d,list_[i])
        n = (lcm_//d*n)+(lcm_//list_[i])
        d = lcm_

        gcd_ = gcd(n,d)
        n//= gcd_
        d//=gcd_
    print(f'{d}/{n}')




if __name__ == "__main__":
    main()

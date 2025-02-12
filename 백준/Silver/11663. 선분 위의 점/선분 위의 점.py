import sys
input = sys.stdin.readline

def f1(n,list_,a):
    s=0
    e=n
    while (s<e):
        mid = (s+e)//2
        if list_[mid]>=a:
            e=mid
            if list_[mid]==a: break
        else :
            s=mid+1
    return e

def f2(n,list_,b):
    s=0
    e=n
    while (s<e):
        mid = (s+e)//2
        if list_[mid]==b:
            e=mid+1
            break
        elif list_[mid]>b:
            e=mid
        else :
            s=mid+1
    return e-1


def main():
    N,M = map(int,input().split())
    list_ = list(map(int,input().split()))
    list_.sort()
    for _ in range(M):
        a,b = map(int,input().split())
        s=f1(N,list_,a)
        e=f2(N,list_,b)
        print(e-s+1)

if __name__ == "__main__":
    main()

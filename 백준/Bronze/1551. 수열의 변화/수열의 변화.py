import sys
input = sys.stdin.readline

def f(A):
    B = []
    for i in range(1,len(A)):
        B.append(A[i]-A[i-1])
    return B
def main():
    N,K = map(int,input().split())
    list_ = list(map(int,input().split(",")))
    for i in range(K):
        list_ = f(list_)
    for i in range(len(list_)):
        print(list_[i],end='')
        if i!=len(list_)-1:
            print(",",end="")




if __name__ == "__main__":
    main()

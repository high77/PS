import sys
input = sys.stdin.readline

def main():
    N = int(input())
    if N==1 or N==2:
        print(1)
        return 
    a=1
    b=1
    c=2
    for i in range(3,N+1):
        tmp = a+b
        if i==N:
            print(tmp)
        a=b
        b=tmp




if __name__ == "__main__":
    main()

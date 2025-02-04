import sys
input = sys.stdin.readline

def main():
    G = int(input())
    flag = True
    for i in range(int(G**0.5)+1,10000000):
        if (i*i-G)**0.5%1==0:
            flag = False
            print(i)
    if flag : print(-1)
    

if __name__ == "__main__":
    main()

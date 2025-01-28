import sys
input = sys.stdin.readline


def main():
    while True:
        N, WD, M = input().rstrip().split()
        N, M = int(N),int(M)
        if N==0 and WD=='W' and M == 0: break
        if WD=='W':N-=M
        else :N+=M
        if N<-200:print("Not allowed")
        else :print(N)






if __name__ == "__main__":
    main()

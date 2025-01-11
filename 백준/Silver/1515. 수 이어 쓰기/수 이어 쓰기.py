import sys
input = sys.stdin.readline



def main():
    S = input().rstrip()
    N = "0"
    L = 1
    idx = 0
    while idx < len(S) :
        N = str(int(N) + 1)
        L = len(N)
        if S[idx:idx+L] == N :idx+=L
        else:
            for n in N:
                if S[idx]==n:
                    idx+=1
                if idx >= len(S): break

    print(N)





if __name__ == "__main__":
    main()

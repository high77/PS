import sys
input = sys.stdin.readline



def main():
    B,R = 0,0
    N = int(input())
    S = input().rstrip()
    recent = S[0]
    for c in S:
        if c != recent:
            if c == "B":R+=1
            else:B+=1
            recent = c
    if S[-1] == "B":B+=1
    else:R+=1
    print(1+min(R,B))


if __name__ == "__main__":
    main()

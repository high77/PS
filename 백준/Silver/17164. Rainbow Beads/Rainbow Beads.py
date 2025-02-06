import sys
input = sys.stdin.readline


def main():
    global l, maxlen
    N = int(input())
    S = input().rstrip()
    l = 1
    maxlen = 0

    def lenset():
        global l, maxlen
        if l > maxlen:
            maxlen = l
        l = 1

    for i in range(1, N):
        if (S[i - 1] == 'R' and S[i] == 'B') or (S[i - 1] == 'B' and S[i] == 'R'):
            l += 1
        else:
            lenset()

    print(max(l, maxlen))


if __name__ == "__main__":
    main()

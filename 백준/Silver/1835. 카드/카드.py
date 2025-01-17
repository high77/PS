import sys
from collections import deque
input = sys.stdin.readline



def main():
    N = int(input())
    if N == 1:
        print(1)
        return
    q = deque()
    q.append(N)
    for i in range(N-1,0,-1):
        q.appendleft(i)
        for j in range(i):
            q.appendleft(q[-1])
            q.pop()
    for i in range(N):
        print(q.popleft(), end=" ")



if __name__ == "__main__":
    main()

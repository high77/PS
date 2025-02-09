import sys
input = sys.stdin.readline
from collections import deque


def main():
    N = int(input())
    q = deque()
    for i in range(1,N+1):
        if i % 2 == 1:
            if i==N:q.appendleft(i)
            else:q.append(i)
    while len(q)>1:
        q.append(q.popleft())
        q.popleft()
    print(q.pop())



if __name__ == "__main__":
    main()

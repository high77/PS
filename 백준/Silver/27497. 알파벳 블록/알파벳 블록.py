import sys
input = sys.stdin.readline
from collections import deque


def main():
    N = int(input())
    stack = []
    dq = deque()
    for i in range(N):
        list_ = input().rstrip().split()
        if list_[0] == '1':
            dq.append(list_[1])
            stack.append(list_[0])
        elif list_[0] == '2':
            dq.appendleft(list_[1])
            stack.append(list_[0])
        else:
            if stack:
                tmp = stack.pop()
                if tmp == '1':dq.pop()
                else: dq.popleft()
    ans =0
    if dq:
        ans = dq.popleft()
        while dq:
            ans += dq.popleft()
    print(ans)


if __name__ == "__main__":
    main()

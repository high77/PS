import sys
input = sys.stdin.readline




def main():
    N = int(input())
    S = input().rstrip()
    stack = []
    ans = 1
    for c in S:
        if 65<=ord(c)<=90:
            if stack :
                if ord(stack[-1])!=ord(c)+32:
                    ans = 0
                    break
                else:
                    stack.pop()
            else:
                ans = 0
                break
        else:stack.append(c)
    if stack :ans = 0        
    print(ans)


if __name__ == "__main__":
    main()


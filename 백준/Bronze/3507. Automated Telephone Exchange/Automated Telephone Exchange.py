import sys
input = sys.stdin.readline

def main():
    N = int(input())
    if N > 198:
        print(0)
        return
    print(198-N+1)


if __name__ == "__main__":
    main()

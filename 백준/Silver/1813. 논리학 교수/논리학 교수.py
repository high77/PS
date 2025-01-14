import sys
input = sys.stdin.readline



def main():
    N = int(input())
    list_ = list(map(int,input().split()))
    ans = -1
    check = [0] * 51
    for n in list_:
        check[n] += 1
    for i in range(1,51):
        if check[i] == i:
            ans = i
    if ans == -1 and check[0] == 0:
        ans =0

    print(ans)

if __name__ == "__main__":
    main()

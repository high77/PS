import sys
input = sys.stdin.readline



def main():
    N = int(input())
    list_ = []
    for i in range(N):list_.append(input().rstrip())
    res = ""
    flag = False
    for s1 in list_:
        if flag: break
        for s2 in list_:
            if s1 == s2[::-1]:
                res = s1
                flag = True
                break
    print(len(res),res[len(res)//2])



if __name__ == "__main__":
    main()


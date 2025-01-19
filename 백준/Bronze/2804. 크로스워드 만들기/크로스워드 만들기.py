import sys
input = sys.stdin.readline

def main():
    S1, S2 = input().split()
    s1,s2 = 0,0
    flag = False
    for i in range(len(S1)):
        if flag: break
        for j in range(len(S2)):
            if S1[i] == S2[j]:
                s1 = i
                s2 = j
                flag = True
                break
    for i in range(len(S2)):
        ans = ""
        for j in range(len(S1)):
            if s1==j:
                ans+=S2[i]
            elif s2==i:
                ans+=S1[j]
            else :
                ans+="."
        print(ans)







if __name__ == "__main__":
    main()

import sys
input = sys.stdin.readline



def main():
    T = int(input())
    for tc in range(T):
        N = int(input())
        dict_ = {}
        list_ = input().rstrip().split()
        for i in range(N):dict_[list_[i]] = i
        list_ = input().rstrip().split()
        order = []
        for i in range(N):order.append(dict_[list_[i]])
        list2 = input().rstrip().split()
        for i in range(N):dict_[order[i]]=list2[i]
        for i in range(N):
            print(dict_[i],end=" ")


if __name__ == "__main__":
    main()

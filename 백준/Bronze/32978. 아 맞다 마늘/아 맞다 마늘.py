n=int(input())
set_=set(input().split())
list_=list(input().split())
for i in list_:
    set_.remove(i)
print(list(set_)[0])
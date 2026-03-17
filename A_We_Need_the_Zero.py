t=int(input())
ans=[0] * t
for k in range(t):
    n=int(input())
    arr= [int(i) for i in input().split()]
    sum=0
    for j in arr:
        sum^=j
    if n%2==1 or sum==0:
        ans[k]=sum
    else:
        ans[k]=-1

for k in range(t):
    print(ans[k])

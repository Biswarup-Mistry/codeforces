t=int(input())
for _ in range(t):
    n=int(input())
    arr=list(input().strip())
    i=0
    j=n-1
    while(i<=j):
        if(arr[i]!=arr[j]):
            i+=1 
            j=j-1
        else:break
    print(j-i+1)

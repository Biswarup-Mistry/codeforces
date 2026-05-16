t=int(input())
for _ in range(t):
    n=int(input())
    a = list(map(int, input().split()))
    m=a.count(2)
    if(m==0):
        print(1)
    elif(m%2==1):
        print(-1)
    elif(m%2==0 and m>0):
        count=0
        i=0
        while(count != m//2):
            if(a[i]==2):
                count+=1
            i+=1
        print(i)

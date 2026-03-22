import math

t=int(input())
for _ in range(t):
    n=int(input())
    p=False
    a = list(map(int, input().split()))
    if(min(a)==1):print("Yes")
    else:
        for i in range(n):
            for j in range(i+1,n):
                if (math.gcd(a[i], a[j])<=2):
                    p=True 
                    break
            if p==True : break
        print("Yes" if p else "No")

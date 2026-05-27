t=int(input())
for _ in range(t):
    n=int(input())
    a = list(map(int, input().split()))
    
    if(max(a)!=min(a)):
        print("YES")
            # 1. Find and remove the maximum element
        max_val = max(a)
        a.remove(max_val)

        # 2. Find and remove the minimum element
        min_val = min(a)
        a.remove(min_val)

        # 3. Insert them at the beginning (index 0 and 1)
        a.insert(0, min_val) # Insert min first so max can push it to index 1
        a.insert(0, max_val)
        print(*a)
    else:
        print("NO")

import random

def mrgsrt(ldata):
    if len(ldata) > 1:
        middle = len(ldata) // 2
        left = ldata[:middle]
        right = ldata[middle:]
        mrgsrt(left)
        mrgsrt(right)
        m = 0
        l = 0
        r = 0
        while l < len(left) and r < len(right):
            if left[l] <= right[r]:
              ldata[m] = left[l]
              l += 1
            else:
                ldata[m] = right[r]
                r += 1
            m += 1
        while l < len(left):
            ldata[m] = left[l]
            m += 1
            l += 1
        while r < len(right):
            ldata[m]=right[r]
            m += 1
            r += 1

ldata = []
for x in range(100):
    ldata.append(random.randint(0, 100))
print("Unsorted List: ")
print(ldata)
mrgsrt(ldata)
print("\nSorted List: ")
print(ldata)
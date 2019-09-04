def sum1(range_):
    a = 0;
    for i in range(1, range_+1):
        a+=i
    return a

def sum2(range_):
    return (range_*(range_+1))/2

import time
st = time.time()
print(sum1(10**2))
print(time.time() - st)


st = time.time()
print(sum2(10**80))
print(time.time() - st)

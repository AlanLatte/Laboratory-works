def lpf(number = 600851475143):
    resultArray = []
    while number > 1:
        divider,\
            checkFinish = 2 , 0
        while True:
            if number % divider == 0:
                number //= divider
                if divider in resultArray: pass
                else: resultArray.append(divider)
                checkFinish = 1
                break
            else: divider += 1
        if checkFinish: continue
    yield '*'.join(str(item) for item in resultArray)

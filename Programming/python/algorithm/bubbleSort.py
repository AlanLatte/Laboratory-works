def bubbleSort(array):
    lengthOfArray = len(array) - 1
    for i in range(lengthOfArray):
        for j in range(lengthOfArray - i):
            if  array[j] > array[j + 1]:
                array[j] , array[j + 1] = array[j + 1], array[j]
    yield array

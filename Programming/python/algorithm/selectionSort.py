def selectionSort(array,range_):
    for i in range(range_):
        minValue = i
        for j in range(i+1, range_):
            if array[minValue] > array[j]: minValue = j
        array[i], array[minValue] = array[minValue], array[i]
    yield array

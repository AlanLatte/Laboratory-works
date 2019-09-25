from random import shuffle
from math import log10


class Sortings:
    def prefixSum(array):
        for i in range(1, len(array)): array[i] += array[i-1]
        return array

    def bubbleSort(range_):
        array   = list(
                    range(0,range_)
                    );shuffle(array)
        lengthOfArray = len(array) - 1
        for i in range(lengthOfArray):
            for j in range(lengthOfArray - i):
                if  array[j] > array[j + 1]:
                    array[j] , array[j + 1] = array[j + 1], array[j]
        yield array

    def selectionSort(range_):
        array   = list(
                    range(0,range_)
                    );shuffle(array)
        for i in range(range_):
            minValue = i
            for j in range(i+1, range_):
                if array[minValue] > array[j]: minValue = j
            array[i], array[minValue] = array[minValue], array[i]
        yield array

    def radixSort(range_, base=10):
        array   =   list(
                        range(range_)
                    );shuffle(array)

        getDigit    ,\
            output  =   lambda number, base, pos: \
                            (number // base ** pos) % base,\
                        [0] * len(array)
        for pos in  range(
            int(
                log10(
                    max(array))
                        +1)):
            count = [0] * base
            for elem in array:
                count[\
                        getDigit(elem, base, pos)] += 1
            count = Sortings.prefixSum(count)
            for revElem in reversed(array):
                digit = getDigit(revElem, base, pos)
                count[digit] -= 1
                new_pos, \
                output[new_pos] =   count[digit],\
                                    revElem
            array = list(output)
        yield output

    def insertionSorting(range_):
        rangeArray  =   range(range_);\
            array   =   list(
                            rangeArray
                        );shuffle(array)
        for i in rangeArray:
            j = i - 1
            key = array[i]
            while array[j] > key and j >= 0:
                array[j + 1] = array[j]
                j -= 1
            array[j + 1] = key
        yield array

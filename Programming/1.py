import os
""" Change directory to current """
os.chdir(
    os.path.realpath(
        os.path.join(
            os.getcwd(),\
            os.path.dirname(__file__)
            )
        )
    )

from random import shuffle
from math import log10

class File:
    def write(nums, typeOfSorting):
        import time
        start_time  = time.time()
        with open(f'{typeOfSorting}.txt','w') as result:
            for num in nums: result.write(str(num))
            result.write("\n--- %s seconds ---" % (time.time() - start_time))

class SortTypes:
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
            count = SortTypes.prefixSum(count)
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

def main():
    insertionSorting_   = SortTypes.insertionSorting;\
        bubbleSort_     = SortTypes.bubbleSort;\
            radixSort_  = SortTypes.radixSort
    File.write(
        nums = bubbleSort_(
            range_ = 10 ** 6
            ),\
        typeOfSorting = bubbleSort_.__name__
        )
    File.write(
        nums = insertionSorting_(
            range_ = 10 ** 6
            ),\
        typeOfSorting = insertionSorting_.__name__
        )
    File.write(
        nums = radixSort_(
            range_ = 10 ** 6
            ),\
        typeOfSorting = radixSort_.__name__
        )

if __name__ == '__main__':
    main()
    # pass

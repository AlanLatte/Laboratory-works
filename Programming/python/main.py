#version 1 (x16)
from operations import *
from algorithm import *
from os import chdir
from random import randint

def main(resultFolder: str = "result") -> str:
    Array   =   ArrayOperation
    File    =   FileOperation
    RANGE   =   10 ** 3
    File.createFolder(
        resultFolder,
        presonalLink = "t.me/alanlatte"
    );chdir(resultFolder)
    File.write(
        data = quicksort(
            array   =   Array.createArray(
                RANGE)
            ),\
        typeOfSorting = quicksort.__name__,
        reqursion   = True)
    File.write(
        data = binarySearch(
            array   =   Array.createArray(
                RANGE,
                    search = True),
            number  =   randint(0,RANGE)
            ),\
        typeOfSorting = binarySearch.__name__
        )
    File.write(
        data = lpf(
            number = randint(0, RANGE)
            ),\
        typeOfSorting = lpf.__name__
        )
    File.write(
        data = bstSort(
            array   =   Array.createArray(
                RANGE)
            ),\
        typeOfSorting = bstSort.__name__
        )
    File.write(
        data = bubbleSort(
            array   =    Array.createArray(
                RANGE)
            ),\
        typeOfSorting = bubbleSort.__name__
        )
    File.write(
        data = insertionSorting(
            array   =    Array.createArray(
                RANGE)
            ),\
        typeOfSorting = insertionSorting.__name__
        )
    File.write(
        data = radixSort(
            array   =    Array.createArray(
                RANGE)
            ),\
        typeOfSorting = radixSort.__name__
        )
    File.write(
        data = selectionSort(
            array   =    Array.createArray(
                RANGE),\
            range_ =   RANGE
            ),\
        typeOfSorting = selectionSort.__name__
        )

if __name__ == '__main__':
    main()

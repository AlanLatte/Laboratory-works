#version 1 (x16)
from operations import *
from algorithm import *
from os import chdir


def main(resultFolder: str = "result") -> str:
    Array   =   ArrayOperation
    File    =   FileOperation
    RANGE   =   10 ** 3
    File.createFolder(
        resultFolder,
        presonalLink = "t.me/alanlatte"
    );chdir(resultFolder)

    File.write(
        nums = bstSort(
            array   =   Array.createArray(
                RANGE)
            ),\
        typeOfSorting = bstSort.__name__
        )
    File.write(
        nums = bubbleSort(
            array   =    Array.createArray(
                RANGE)
            ),\
        typeOfSorting = bubbleSort.__name__
        )
    File.write(
        nums = insertionSorting(
            array   =    Array.createArray(
          RANGE)
            ),\
        typeOfSorting = insertionSorting.__name__
        )
    File.write(
        nums = radixSort(
            array   =    Array.createArray(
          RANGE)
            ),\
        typeOfSorting = radixSort.__name__
        )
    File.write(
        nums = selectionSort(
            array   =    Array.createArray(
          RANGE),\
            range_ =   RANGE
            ),\
        typeOfSorting = selectionSort.__name__
        )

if __name__ == '__main__':
    main()

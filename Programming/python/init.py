import writeToFile
import mainLogic
import os

def main(resultFolder: str = "result") -> str:

    SortTypes   =   mainLogic.Sortings;\
        File    = writeToFile.FileOperation

    File.createFolder(
        resultFolder,
        presonalLink = "t.me/alanlatte"
    ); os.chdir(resultFolder)

    insertionSorting_   = SortTypes.insertionSorting;\
        selectionSort_  = SortTypes.selectionSort;\
            bubbleSort_ = SortTypes.bubbleSort;\
            radixSort_  = SortTypes.radixSort;\
                RANGE   = 10 ** 2
    File.write(
        nums = bubbleSort_(
            range_ = RANGE
            ),\
        typeOfSorting = bubbleSort_.__name__
        )
    File.write(
        nums = insertionSorting_(
            range_ = RANGE
            ),\
        typeOfSorting = insertionSorting_.__name__
        )
    File.write(
        nums = radixSort_(
            range_ = RANGE
            ),\
        typeOfSorting = radixSort_.__name__
        )
    File.write(
        nums = selectionSort_(
            range_ = RANGE
            ),\
        typeOfSorting = selectionSort_.__name__
        )

if __name__ == '__main__':
    main()
#DONE!

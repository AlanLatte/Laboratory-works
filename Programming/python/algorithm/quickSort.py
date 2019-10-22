import random
def quicksort(array):
    if len(array) <= 1:
        return array
    else:
        suppElement = random.choice(array)
    return \
        quicksort(
            [
                n for n in array if n < suppElement     # leftArray
            ])                                          +   \
        [suppElement] * array.count(suppElement)        +   \
        quicksort(
            [
                n for n in array if n > suppElement     # rightArray
            ])

from math import log10

def prefixSum(array):
    for i in range(1, len(array)): array[i] += array[i-1]
    return array

def radixSort(array, base=10):
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
        count = prefixSum(count)
        for revElem in reversed(array):
            digit = getDigit(revElem, base, pos)
            count[digit] -= 1
            new_pos, \
            output[new_pos] =   count[digit],\
                                revElem
        array = list(output)
    yield output

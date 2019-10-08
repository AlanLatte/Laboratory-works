def binarySearch(array, number):
    if len(array) == 0:
        return False
    else:
        midpoint = len(array)//2
        if array[midpoint]==number:
            return True
        else:
            if number<array[midpoint]:
                return binarySearch(array[:midpoint],number)
            else:
                return binarySearch(array[midpoint+1:],number)

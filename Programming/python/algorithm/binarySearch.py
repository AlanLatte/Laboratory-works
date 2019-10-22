def binarySearch(array, number):
    if len(array) == 0:
        return 'False'
    else:
        midpoint = len(array)//2
        if array[midpoint]==number:
            return f'{array}\nThe number {number} is on the list. \n Number index: {midpoint} '
        else:
            if number<array[midpoint]:
                return binarySearch(array[:midpoint],number)
            else:
                return binarySearch(array[midpoint+1:],number)

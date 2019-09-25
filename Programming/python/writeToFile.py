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

class FileOperation:
    def write(nums, typeOfSorting):
        import time
        start_time  = time.time()
        with open(f'{typeOfSorting}.txt','w') as result:
            for num in nums: result.write(str(num))
            result.write("\n--- %s seconds ---" % (time.time() - start_time))

    def createFolder(result,presonalLink):
        try:                    os.mkdir(result)
        except FileExistsError: return True
        else:
            print (
                f"""
                    Successfully created the directory {result}
                    Please write to the developer: {presonalLink}
                """);           return False

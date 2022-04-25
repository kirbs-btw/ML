import math

"""
kNN

k-nearest-neighbor

cluster algorithm
gets the distance of all point to our new data.
the nearest it is to a cluster of point with the same value 
the prediction is made. 

it´s easily expandable, the euclidean can be expanded with as many
parameters as you wish. 


"""


data = [[1, 1], [0, 2], [1.5, 1], [0.5, 1], [8, 10], [7, 9]]
values = [0, 0, 0, 0, 1, 1]

testPoint = [7, 9]  # value should be 1
testPoint_two = [0, 1]  # value should be 0

def distance(data, point, k):
    dist_arr = []

    for i in data:
        dist = math.sqrt((i[0] - point[0])**2 + (i[1] - point[1])**2)
        dist_arr.append(dist)

    zipped_data = sorted(zip(dist_arr, values))
    k_zipped = zipped_data[:k]
    k_values = []

    for value in k_zipped:
        k_values.append(value[1])

    return most_common(k_values)

def most_common(arr):
    return max(set(arr), key=arr.count)

print(distance(data, testPoint, 3))
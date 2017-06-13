import numpy as np

from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
rng = np.random
iris = load_iris()
data = np.array(iris.data)
print(iris.data)
print("****************************************")
print(iris.target)
print("*****************************************")
print(iris.DESCR)
print("***************************************")
print(iris.feature_names)
print("******************************************")
print(iris.target)
labels = np.array(iris.target)
data = data[:, 0]

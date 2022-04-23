import math
import random

"""
linear regression algorithm 
random points are created around a line 
goal is to predict the parameters of  the line

with a loss function and usage of gradient descent 
we can approximate the value of w and b 
"""


def randpoints():
    x_train = []
    y_train = []

    for i in range(100):
        x = i / 10
        y_clear = -1 * x + 2
        y = y_clear + (random.randint(-50, 50) / 100)
        x_train.append(x)
        y_train.append(y)

    return x_train, y_train

x_train, y_train = randpoints()

def predict(w, b, x):
    return w*x+b

def avg_loss(w, b, x, y):
    N = len(x)
    e = 0
    for i in range(0, N):
        e += (y[i]-(w*x[i]+b)) ** 2
    return 1/N*e

def update_w_and_b(w, b, x, y, alpha):
    # gradient descent
    N = len(x)
    dl_dw = 0
    dl_db = 0
    for i in range(0, N):
        dl_db += -2*(y[i]-(w*x[i]+b))
        dl_dw += -2*x[i]*(y[i]-(w*x[i]+b))
    b = b-(1/N)*dl_db*alpha
    w = w-(1/N)*dl_dw*alpha
    return w, b

def train(x, y, epochs=100, alpha=0.01):
    w = 0
    b = 0
    for epoch in range(0, epochs):
        w, b = update_w_and_b(w, b, x, y, alpha)

        if epoch % 100 == 0:
            print(f"epoch: {epoch} loss: {avg_loss(w, b, x, y)}")
    return w, b

w, b = train(x_train, y_train, epochs=5000)
print(f"w: {w}, b: {b}")
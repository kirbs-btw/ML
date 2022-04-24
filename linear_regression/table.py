import sqlite3
import random

def createTable():
    #f = open("points.sql", "w+")
    conn = sqlite3.connect("points.sql")
    cur = conn.cursor()

    command = "CREATE TABLE points(x FLOAT, y FLOAT)"
    cur.execute(command)
    conn.commit()

def randPoints():
    conn = sqlite3.connect("points.sql")
    cur = conn.cursor()

    command = "DELETE FROM points"
    cur.execute(command)
    conn.commit()

    for i in range(100):
        x = i / 10
        y_clear = -1 * x + 2
        y = y_clear + (random.randint(-50, 50) / 100)
        command = f"INSERT INTO points VALUES('{x}','{y}')"
        cur.execute(command)
    conn.commit()
    pass

def readPoints():
    conn = sqlite3.connect("points.sql")
    cur = conn.cursor()

    command = "SELECT * FROM points"
    table = cur.execute(command).fetchall()

    for row in table:
        print(row)

if __name__ == '__main__':
    randPoints()
    readPoints()
import sqlite3
import random

def create_data():
    data = []
    values = [0, 1, 1, 0, 1, 0, 1]

    for value in values:
        if value:
            x = random.randint(0, 400) / 100
            y = random.randint(0, 400) / 100
        else:
            x = random.randint(600, 1000) / 100
            y = random.randint(600, 1000) / 100
        data.append([x, y])

    return data, values

def insert_data():
    data, values = create_data()

    conn = sqlite3.connect("train.sql")
    cur = conn.cursor()


    for index, data_set in enumerate(data):
        command = f"INSERT INTO data VALUES('{data_set[0]}', '{data_set[1]}','{values[index]}')"
        cur.execute(command)
        print(command)
        conn.commit()
    return

def read_table():
    conn = sqlite3.connect("train.sql")
    cur = conn.cursor()
    command = "SELECT * FROM data"
    table = cur.execute(command).fetchall()
    for row in table:
        print(row)


def create_SQL():
    # f = open("train.sql", "w+")
    conn = sqlite3.connect("train.sql")
    cur = conn.cursor()

    command = "CREATE TABLE data(x FLOAT, y FLOAT, value INT)"
    cur.execute(command)

    conn.commit()

def get_data():
    conn = sqlite3.connect("train.sql")
    cur = conn.cursor()
    command = "SELECT * FROM data"
    table = cur.execute(command).fetchall()

    data = []
    values = []

    for row in table:
        data.append([row[0], row[1]])
        values.append(row[2])

    return data, values

if __name__ == '__main__':
    #insert_data()
    read_table()


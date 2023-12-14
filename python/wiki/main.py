import pymysql
import threading

from db import save
from extractor import parseFile

def getConn():
    return pymysql.connect(host="localhost", port=3306, db="wiki", user="dev", passwd="123456")


def savePage(page, conn):
    flag = save(page, conn)
    if not flag:
        print('log: ', page.id)
    return False

lock = threading.Lock()
# 多线程保存时出错可以直接从出错位置重新开始
index = 240
def getIndex():
    with lock:
        global index
        index += 1
        return index

def pringLog(name):
    with getConn() as conn:
        while True:
            i = getIndex()
            if(i > 875):break

            print(f'线程：{name}, 获取到的id为: {i}')
            parseFile(f'D:/work/book/wiki/out/wiki_{i}.xml', lambda page: savePage(page, conn))

if __name__ == "__main__":
    # 直接保存到数据库
    parseFile('D:\Downloads\zhwiki-latest-pages-articles.xml',  lambda page: savePage(page, getConn()))

    # 保存的时候由于数据库字符编码问题，导致中断，并且速度太慢，先进行了切割，每5000个page一个文件，后多线程进行的保存
    # for i in range(1, 20):
    #     threading.Thread(target=pringLog, args=(f'线程{i}',)).start()
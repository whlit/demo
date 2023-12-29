import pymysql
from models import Page, Revision, User
# conn 传入进来，为了减少建立数据库连接的次数
def save(page: Page, conn: pymysql.Connection):
    if pageExisted(page.id, conn):
        return False
    insertPage(page, conn)
    insertRevision(page.revision, conn)
    if userExisted(page.revision.contributor.id, conn):
        return True
    insertUser(page.revision.contributor, conn)
    return True

def insertUser(user: User, conn):
    cur = conn.cursor()
    cur.execute('insert into user (id, user_name) values (%s, %s)',
                (user.id, user.username))
    conn.commit()
    cur.close()
    

def insertPage(page: Page, conn):
    cur = conn.cursor()
    cur.execute('insert into `page` (id, title, ns, revision_id, redirect) values (%s, %s, %s, %s, %s)',
                (page.id, page.title, page.ns, page.revision.id, page.redirect))
    conn.commit()
    cur.close()

def insertRevision(revision: Revision, conn):
    cur = conn.cursor()
    cur.execute('insert into revision (id, parent_id, timest, contributor_id, comment, model, format, size, sha1, content) values (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s)',
                (revision.id, revision.parentid, revision.timestamp, revision.contributor.id, revision.comment, revision.model, revision.format, revision.text.size, revision.sha1, revision.text.content))
    conn.commit()
    cur.close()

def pageExisted(id, conn):
    if id == None: return True
    cur = conn.cursor()
    res = cur.execute('select id from page where id = %s', (id))
    conn.commit()
    cur.close
    return res != 0

def userExisted(id, conn):
    if id == None: return True
    cur = conn.cursor()
    res = cur.execute('select id from user where id = %s', (id))
    conn.commit()
    cur.close
    return res != 0
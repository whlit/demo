import re
from xml.etree.ElementTree import Element, fromstringlist
from models import Page, Revision, Text, User

def parseFile(file, consumer):
    with open(file, 'r', encoding='utf-8') as f:
        start = re.compile('<page>')
        end = re.compile('</page>')

        lines = []
        while True:

            line = f.readline()
            if not line:
                break

            if len(line) < 30:
                if start.search(line): # 读取到<page>说明一个page开始
                    lines = []
                    lines.append(line)
                    continue
                if end.search(line): # 读取到</page>说明一个page读取完成
                    lines.append(line)
                    page = parse(lines=lines) # 一个page读取完成后整理为page对象
                    stop = consumer(page) # 返回中断标志
                    if stop:
                        break
            if len(lines) > 0: # lines不为空说明在page里
                lines.append(line)

def parse(lines):
    etree = fromstringlist(lines)
    return toPage(etree=etree)

def toPage(etree: Element):
    page = Page()
    for e in etree:
        tag = e.tag
        if tag == 'title': page.title = e.text
        elif tag == 'ns': page.ns = int(e.text)
        elif tag == 'id': page.id = int(e.text)
        elif tag == 'revision': page.revision = toRevision(e)
        elif tag == 'redirect': page.redirect = e.text
        else :print('worring: page miss tag: ', tag)
    return page

def toRevision(etree: Element):
    revision = Revision()
    for e in etree:
        tag = e.tag
        if tag == 'id': revision.id = int(e.text)
        elif tag == 'parentid': revision.parentid = int(e.text)
        elif tag == 'timestamp': revision.timestamp = e.text
        elif tag == 'contributor': revision.contributor = toContributor(e)
        elif tag == 'minor': revision.minor = e.text
        elif tag == 'model': revision.model = e.text
        elif tag == 'comment': revision.comment = e.text
        elif tag == 'format': revision.format = e.text
        elif tag == 'text': revision.text = toText(e)
        elif tag == 'sha1': revision.sha1 = e.text
        else :print('worring: revision miss tag: ', tag)
    return revision

def toContributor(etree: Element):
    user = User()
    for e in etree:
        tag = e.tag
        if tag == 'id': user.id = int(e.text)
        elif tag == 'username': user.username = e.text
        else :print('worring: contributor miss tag: ', tag)
    return user

def toText(etree: Element):
    text = Text()
    text.content = etree.text
    text.size = int(etree.attrib.get('bytes'))
    return text
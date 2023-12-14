class Page:
    def __init__(self):
        self.title = None
        self.id = None
        self.ns = None
        self.revision = None
        self.redirect = None

class Revision:
    def __init__(self):
        self.id = None
        self.parentid = None
        self.timestamp = None
        self.contributor = None
        self.comment = None
        self.model = None
        self.format = None
        self.text = None
        self.sha1 = None

class User:
    def __init__(self):
        self.username = None
        self.id = None

class Text:
    def __init__(self):
        self.size = None
        self.space = None
        self.content = None
        
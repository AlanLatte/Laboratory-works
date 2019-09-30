class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __repr__(self):
        return str(self.value)



class BST:
    def __init__(self):
        self.root = None

    def __repr__(self):
        self.sorted = []
        self.getInorder(self.root)
        return str(self.sorted)

    def getInorder(self, node):
        if node:
            self.getInorder(node.left)
            self.sorted.append(node.value)
            self.getInorder(node.right)

    def run(self, value):
        if not self.root:
            self.root = Node(value)
        else:
            self.addValue(self.root, value)

    def addValue(self, node, value):
        if value <= node.value:
            if node.left:
                self.addValue(node.left, value)
            else:
                node.left = Node(value)
        else:
            if node.right:
                self.addValue(node.right, value)
            else:
                node.right = Node(value)



def bstSort(array):
    bst = BST()
    for _ in array: bst.run(_)
    yield bst

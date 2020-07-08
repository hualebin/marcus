package algorithm.search;

public class BinarySearchTree {

    private Node tree;

    public BinarySearchTree(int data) {
        this.tree = new Node(data);
    }

    public Node setLeft(Node node, int data) {
        node.left = new Node(data);
        return node.left;
    }

    public Node setRight(Node node, int data) {
        node.right = new Node(data);
        return node.right;
    }

    /**
     * 查找
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        Node p = tree;
        while(p != null) {
            if (p.data > data) {
                p = p.left;
            } else if (p.data < data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 插入
     *
     * @param data
     */
    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
        }
        Node p = tree;
        while (p != null) {
            if (p.data > data) {
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            } else if (p.data < data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            }
        }
    }

    /**
     * 删除
     *
     * @param data
     */
    public void delete(int data) {
        Node parentNode = null;
        Node node = tree;
        while (node != null && node.data != data) {
            parentNode = node;
            if (node.data > data) {
                node = node.left;
            } else if (node.data < data) {
                node = node.right;
            }
        }

        // 找不到节点
        if (node == null) {
            return;
        }
        // 要删除的节点有左右两个子节点
        if (node.left != null && node.right != null) {
            Node parent = null;
            Node child = node.right;
            // 查找右子树的最小节点
            while (child != null && child.left != null) {
                parent = child;
                child = child.left;
            }
            if (parent != null) {
                parent.left = null;
            }
            child.left = node.left;
            child.right = node.right;
            node.left = null;
            node.right = child;
        }

        // 要删除的节点只有一个子节点或者没有子节点
        Node child;
        if (node.left != null) {
            child = node.left;
        } else if (node.right != null) {
            child = node.right;
        } else {
            child = null;
        }

        // 删除节点
        if (parentNode == null) { // 判断节点是否是根节点
            tree = child;
        } else if (parentNode.left == node) {
            parentNode.left = child;
        } else {
            parentNode.right = child;
        }
    }

    /**
     * 前序遍历打印
     * 递归遍历
     * 对于树的任意节点，先打印这个结点，再打印这个节点的左子树节点，最后打印这个节点的右子树节点
     */
    private static void frontPrint(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "  ");
        if (node.left != null) {
            frontPrint(node.left);
        }
        if (node.right != null) {
            frontPrint(node.right);
        }
    }

    /**
     * 中序遍历打印
     * 递归遍历
     * 对于树的任意节点，先打印这个结点的左子树节点，再打印这个节点，最后打印这个节点的右子树节点
     */
    private static void middlePrint(Node node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            middlePrint(node.left);
        }
        System.out.print(node.data + "  ");
        if (node.right != null) {
            middlePrint(node.right);
        }
    }

    /**
     * 后序遍历打印
     * 递归遍历
     * 对于树的任意节点，先打印这个结点的左子树节点，再打印这个节点的右子树节点，最后打印这个节点
     */
    private static void backendPrint(Node node) {
        if (node == null) {
            return;
        }
        if (node.right != null) {
            backendPrint(node.right);
        }
        if (node.left != null) {
            backendPrint(node.left);
        }
        System.out.print(node.data + "  ");
    }

    public class Node {
        private int data;

        private Node left;

        private Node right;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public Node getTree() {
        return tree;
    }

    public void setTree(Node tree) {
        this.tree = tree;
    }

    public static void main(String[] args) {
        BinarySearchTree binarySearch = new BinarySearchTree(33);
        Node tree = binarySearch.getTree();
        /*Node lNode1 = binarySearch.setLeft(tree, 16);
        Node lNode2 = binarySearch.setLeft(lNode1, 13);
        Node lNode22 = binarySearch.setLeft(lNode2, 15);
        Node lNode3 = binarySearch.setRight(lNode1, 18);
        Node lNode31 = binarySearch.setLeft(lNode3, 17);
        Node lNode32 = binarySearch.setRight(lNode3, 25);
        Node lNode321 = binarySearch.setLeft(lNode32, 19);
        Node lNode322 = binarySearch.setRight(lNode32, 27);

        Node rNode1 = binarySearch.setRight(tree, 50);
        Node rNode11 = binarySearch.setLeft(rNode1, 34);
        Node rNode12 = binarySearch.setRight(rNode1, 58);
        Node rNode121 = binarySearch.setLeft(rNode12, 51);
        Node rNode1211 = binarySearch.setRight(rNode121, 55);
        Node rNode122 = binarySearch.setRight(rNode12, 66);*/

        binarySearch.insert(16);
        binarySearch.insert(13);
        binarySearch.insert(15);
        binarySearch.insert(18);
        binarySearch.insert(17);
        binarySearch.insert(25);
        binarySearch.insert(19);
        binarySearch.insert(27);
        binarySearch.insert(50);
        binarySearch.insert(34);
        binarySearch.insert(58);
        binarySearch.insert(51);
        binarySearch.insert(55);
        binarySearch.insert(66);

        System.out.println("-------------------");
        frontPrint(tree);
        System.out.println("-------------------");
        middlePrint(tree);
        System.out.println("-------------------");
        backendPrint(tree);
        System.out.println("-------------------");

        System.out.println(binarySearch.find(51).right.getData());

        System.out.println("-------------------");

        binarySearch.delete(13);

        System.out.println(binarySearch.find(16).left.getData());

        System.out.println("-------------------");

        binarySearch.delete(18);

        System.out.println(binarySearch.find(16).right.left.getData());

        System.out.println("-------------------");
        System.out.println(binarySearch.find(51).right.getData());

        binarySearch.delete(55);

        System.out.println(binarySearch.find(51).right);

    }
}

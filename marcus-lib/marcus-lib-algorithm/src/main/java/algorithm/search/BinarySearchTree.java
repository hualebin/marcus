package algorithm.search;

/**
 * 二叉查找树
 *
 * 特性：二叉查找树上的任意一个节点，满足其左子树的所有节点存储的值小于这个节点存储的值，其右子树的所有节点存储的值大于这个节点存储的值
 */
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
     * 查找节点
     *
     * @param data
     * @return
     */
    public Node find(int data) {
        Node node = this.tree;
        while (node != null) {
            if (node.data > data) {
                node = node.left;
            } else if (node.data < data) {
                node = node.right;
            } else {
                return node;
            }
        }
        return null;
    }

    /**
     * 插入节点
     * @param data
     */
    public void insert(int data) {
        if (this.tree == null) {
            this.tree = new Node(data);
            return;
        }

        Node node = this.tree;
        while (node != null) {
            if (node.data > data) {
                if (node.left == null) {
                    node.left = new Node(data);
                    return;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            }
        }
    }

    /**
     * 删除节点
     * 1、删除的节点没有子节点，直接删除节点
     * 2、删除的节点只有一个子节点，将子节点替换该节点
     * 3、删除的节点有两个节点，需要用其中序前驱节点或后继节点来替换，再删除该节点
     */
    public void delete(int data) {
        Node node = this.tree;
        Node parentNode = null;
        while(node != null) {
            if (node.data > data) {
                parentNode = node;
                node = node.left;
            } else if (node.data < data) {
                parentNode = node;
                node = node.right;
            } else {
                Node replaceNode = null;
                if (node.left != null && node.right != null) {
                    // 找中序后继节点即右子树最小节点来替换
                    Node minNode = node.right;
                    Node minParentNode = node;
                    while (minNode.left != null) {
                        minParentNode = minNode;
                        minNode = minNode.left;
                    }
                    if (minParentNode != node) {
                        minParentNode.left = null;
                        minNode.left = node.left;
                        minNode.right = node.right;
                    }
                    replaceNode = minNode;
                } else if (node.left != null || node.right != null) {
                    replaceNode = node.left != null ? node.left : node.right;
                }

                if (parentNode == null) {
                    tree = replaceNode;
                } else {
                    parentNode.left = parentNode.left == node ? replaceNode :  parentNode.left;
                    parentNode.right = parentNode.right == node ? replaceNode :  parentNode.right;
                }

                return;
            }
        }



    }

    /**
     * 前序遍历
     * 递归遍历
     * 对于树的任意节点，先打印这个节点，再打印这个节点的左子树节点，最后打印这个节点的右子树节点
     * @param node
     */
    public static void frontPrint(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getData());
        frontPrint(node.left);
        frontPrint(node.right);
    }

    /**
     * 中序遍历
     * 递归遍历
     * 对于树的任意节点，先打印这个节点的左子树节点，再打印这个节点，最后打印这个节点的右子树节点
     * @param node
     */
    public static void middlePrint(Node node) {
        if (node == null) {
            return;
        }
        middlePrint(node.left);
        System.out.println(node.getData());
        middlePrint(node.right);
    }

    /**
     * 后序遍历
     * 递归遍历
     * 对于树的任意节点，先打印这个节点的左子树节点，再打印这个节点的右子树节点，最后打印这个节点
     * @param node
     */
    public static void backendPrint(Node node) {
        if (node == null) {
            backendPrint(node.left);
            backendPrint(node.right);
            System.out.println(node.getData());
        }
    }

    public class Node {

        private int data;

        private Node left;

        private Node right;

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

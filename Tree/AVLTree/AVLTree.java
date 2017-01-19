package Test;

/**
 * 关于 AVL Tree 的实现
 */
public class AVLTree {
    class Node {
        private int key;
        private int height;

        Node left, right;

        Node(int key) {
            this.key = key;
            this.height = 1;
        }
    }

    // utils function
    public int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

    Node root;

    public Node leftRotate(Node y) {
        Node x = y.right;
        Node T = x.left;

        // 旋转
        x.left = y;
        y.right = T;

        // 平衡高度
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x;
    }

    public Node rightRotate(Node y) {
        Node x = y.left;
        Node T = x.right;

        // 转换操作
        x.right = y;
        y.left = T;

        // 平衡高度
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return x;
    }

    public Node insertNode(Node node, int key) {
        if (node == null)
            return new Node(key);
        if (key < node.key)
            node.left = insertNode(node.left, key);
        else if (key > node.key)
            node.right = insertNode(node.right, key);
        else
            throw new IllegalArgumentException("已经存在");

        // 判断该节点现在是否平衡
        node.height = 1 + max(height(node.left), height(node.right));
        int balance = height(node.left) - height(node.right);

        // LL
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // LR
        if (balance > 1 && key > node.right.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RR
        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        // RL
        if (balance < -1 && key < node.left.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // 如果不进行 rotate 的话，也要返回一个 Node
    }

    public void printMiddleOrder(Node node) {
        if (node == null)
            return;
        printMiddleOrder(node.left);
        System.out.print(node.key + " ");
        printMiddleOrder(node.right);
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.root = avlTree.insertNode(avlTree.root, 10);
        avlTree.root = avlTree.insertNode(avlTree.root, 20);
        avlTree.root = avlTree.insertNode(avlTree.root, 30);
        avlTree.root = avlTree.insertNode(avlTree.root, 40);
        avlTree.root = avlTree.insertNode(avlTree.root, 50);
        avlTree.root = avlTree.insertNode(avlTree.root, 25);

        avlTree.printMiddleOrder(avlTree.root);

    }
}


import java.awt.*;
import java.util.ArrayList;

public class BST {
    private Node root;

    public BST() {
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        if (isEmpty()) {
            Node node = new Node(data);
            root = node;
        } else {
            insertHelper(data, root);
        }
    }

    private void insertHelper(int data, Node root) {
        Node node = new Node(data);
        if (data < root.getData()) {
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else insertHelper(data, root.getLeft());
        }
        if (data > root.getData()) {
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                insertHelper(data, root.getRight());
            }
        }
    }

    public boolean contains(int data) {
        Node current = root;
        while (current != null) {
            if (data == current.getData()) {
                return true;
            } else if (data < current.getData()) {
                current = current.getLeft();
            } else if (data > current.getData()) {
                current = current.getRight();
            }
        }
        return false;
    }

    public int maxBST() {
        if (root == null) {
            return -1;
        }
        Node current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getData();
    }

    // first
    public int SecMaxBst() {
        if (root == null) {
            return -1;
        }
        Node previous = null;
        Node current = root;
        while (current.getRight() != null) {
            previous = current;
            current = current.getRight();
        }
        return previous.getData();
    }

    // with edge case
    public int SecMaxBstt() {
        if (root == null) {
            return -1;
        }
        int sec = 0;
        Node current = root;
        while (current.getRight() != null || current.getLeft() != null) {
            sec = current.getData();
            if (current.getRight() == null && current.getLeft() != null) {
                sec = current.getLeft().getData();
                break;
            }
            current = current.getRight();
        }
        return sec;
    }

    public int sumOdd(Node node){
        int sum = 0;
        if(node != null) {
            if((node.getData() % 2) != 0) {
                sum += node.getData();
            }
            sum+=sumOdd(node.getLeft());
            sum+=sumOdd(node.getRight());
        }
        return sum;
    }

    public ArrayList levelOrder() {
        ArrayList list = new ArrayList();
        Queue queue = new Queue();
        if (isEmpty()) {
            System.out.println("Empty");
        }
        if (root != null) {
            queue.enqueue(root);
            levelOrder(list, queue);
        }
        return list;
    }

    private void levelOrder(ArrayList list, Queue queue) {
        while (!queue.isEmpty()) {
            Node node = (Node) queue.dequeue();
            list.add(node.getData());
            if (node.getLeft() != null) {
                queue.enqueue(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.enqueue(node.getRight());
            }
        }
    }

    static void inorderT(Node node) {
        if (node == null)
            return;
        inorderT(node.getLeft());
        System.out.printf("%d ", node.data);

        inorderT(node.getRight());
    }

    public static Node MergeTrees(Node t1, Node t2 ) {
        if(t1 == null && t2 == null){

            return null;
        } else {
            if (t1 == null) {
                return t2;
            }
            if (t2 == null) {
                return t1;
            }
            t1.data = t1.data + t2.data;
            t1.setLeft(MergeTrees(t1.getLeft(), t2.getLeft()));
            t1.setRight(MergeTrees(t1.getRight(), t2.getRight()));
            return t1;
        }
    }

    public boolean hasPathSum(Node root, int sum) {
        if (root == null) return false;
        sum -= root.getData();
        if (sum == 0 && root.getLeft() == null && root.getRight() == null) {
            return true;
        }
        boolean left = hasPathSum(root.getLeft(), sum);
        boolean right = hasPathSum(root.getRight(), sum);
        return left || right;
    }

    public List binaryTreePaths(Node root) {
        List list = new java.awt.List();
        if(root != null)getPaths(root, list, "");
        return list;
    }

    private static void getPaths(Node root, List list, String path) {
        if(root.left == null && root.right == null) list.add(path + root.getData());
        if(root.left != null) getPaths(root.left, list, path + root.getData() + "->");
        if(root.right != null) getPaths(root.right, list, path + root.getData() + "->");
    }

    static void dfs(Node root, int sum, ArrayList<Integer> pathSum) {
        if (root == null) {
            return;
        }
        sum = sum +  (int) root.data;

        if(root.getLeft() == null && root.getRight() == null) {
            pathSum.add(sum);
            return;
        }

        dfs(root.getLeft(), sum, pathSum);
        dfs(root.getRight(), sum, pathSum);
    }

    static void findPathSum(Node root) {

        ArrayList<Integer> pathSum = new ArrayList<>();
        dfs(root, 0, pathSum);

        for(int num : pathSum) {
            System.out.print(num + " ");
        }
    }

}
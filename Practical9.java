import java.util.Scanner;

public class Practical9 {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    Node root;

    Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }

    Node delete(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Practical9 bst = new Practical9();

        while (true) {
            System.out.println("\n1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter value: ");
                    bst.root = bst.insert(bst.root, sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    System.out.println(bst.search(bst.root, key)
                            ? "Value found" : "Value not found");
                    break;
                case 3:
                    System.out.print("Enter value to delete: ");
                    bst.root = bst.delete(bst.root, sc.nextInt());
                    System.out.println("Delete operation completed");
                    break;
                case 4:
                    System.out.print("Inorder: ");
                    bst.inorder(bst.root);
                    System.out.println();
                    break;
                case 5:
                    System.out.print("Preorder: ");
                    bst.preorder(bst.root);
                    System.out.println();
                    break;
                case 6:
                    System.out.print("Postorder: ");
                    bst.postorder(bst.root);
                    System.out.println();
                    break;
                case 7:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}


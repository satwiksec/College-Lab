import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Main {
    static Node root = null;

    static Node insert(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insert(root.left, data);
        else if (data > root.data)
            root.right = insert(root.right, data);

        return root;
    }

    static void search(Node root, int key) {
        if (root == null) {
            System.out.println("Element not found");
            return;
        }

        if (root.data == key) {
            System.out.println("Element found");
        } else if (key < root.data) {
            search(root.left, key);
        } else {
            search(root.right, key);
        }
    }

    static Node findMin(Node root) {
        while (root.left != null)
            root = root.left;

        return root;
    }

    static Node delete(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            Node temp = findMin(root.right);
            root.data = temp.data;
            root.right = delete(root.right, temp.data);
        }

        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice, data;

        do {
            System.out.println("\n1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter roll number: ");
                    data = sc.nextInt();
                    root = insert(root, data);
                    break;

                case 2:
                    System.out.print("Enter roll number to search: ");
                    data = sc.nextInt();
                    search(root, data);
                    break;

                case 3:
                    System.out.print("Enter roll number to delete: ");
                    data = sc.nextInt();
                    root = delete(root, data);
                    break;

                case 4:
                    System.out.print("Inorder: ");
                    inorder(root);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Preorder: ");
                    preorder(root);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Postorder: ");
                    postorder(root);
                    System.out.println();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 7);

        sc.close();
    }
}
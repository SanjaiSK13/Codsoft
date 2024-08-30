package Package;
import java.util.Scanner;

// Node class representing each node of the binary search tree
class Node { 
    int key;
    Node left, right;

    public Node(int item) { 
        key = item; 
        left = right = null; 
    }
} 

// BinarySearchTree class which contains the tree traversal logic and main method
public class BinarySearchTree { 
    Node root;

    BinarySearchTree() { 
        root = null; 
    } 

    // Insert method for adding a new node to the binary search tree
    void insert(int key) {
        root = insertRec(root, key);
    } 

    Node insertRec(Node root, int key) {
        if (root == null) { 
            root = new Node(key); 
            return root; 
        }

        if (key < root.key) { 
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key); 
        } 

        return root;
    } 

    // Inorder traversal of the BST
    void inOrder() {
        inOrderRec(root); 
        System.out.println();
    }

    void inOrderRec(Node root) { 
        if (root != null) { 
            inOrderRec(root.left); 
            System.out.print(root.key + " "); 
            inOrderRec(root.right); 
        } 
    } 

    // Preorder traversal of the BST
    void preOrder() { 
        preOrderRec(root); 
        System.out.println(); 
    } 

    void preOrderRec(Node root) {
        if (root != null) { 
            System.out.print(root.key + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        } 
    } 

    // Postorder traversal of the BST
    void postOrder() { 
        postOrderRec(root); 
        System.out.println(); 
    } 

    void postOrderRec(Node root) { 
        if (root != null) {
            postOrderRec(root.left); 
            postOrderRec(root.right); 
            System.out.print(root.key + " "); 
        }
    } 

    // Main method to interact with the user
    public static void main(String[] args) { 
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes you want to insert:");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " values for the Binary Search Tree:");
        for (int i = 0; i < n; i++) { 
            int value = sc.nextInt();
            tree.insert(value); 
        }

        while (true) { 
            System.out.println("\nSelect a traversal option:"); 
            System.out.println("1. Inorder Traversal");
            System.out.println("2. Preorder Traversal"); 
            System.out.println("3. Postorder Traversal"); 
            System.out.println("4. Exit"); 

            int choice = sc.nextInt();
            switch (choice) {
                case 1: 
                    System.out.println("Inorder Traversal:"); 
                    tree.inOrder(); 
                    break; 
                case 2: 
                    System.out.println("Preorder Traversal:");
                    tree.preOrder(); 
                    break;
                case 3: 
                    System.out.println("Postorder Traversal:");
                    tree.postOrder(); 
                    break; 
                case 4:
                    System.out.println("Exiting..."); 
                    sc.close(); 
                    return; 
                default: 
                    System.out.println("Invalid choice! Please select again."); 
            } 
        }
    } 
} 

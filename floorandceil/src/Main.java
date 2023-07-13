/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Merna
 */


class Node {
    Node left;
    Node right;
    int data;
}
class BinarySearchTree {
    static int ceil(Node root, int input) {
        if (root == null)
            return -1;
        if (root.data == input)
            return root.data;
        if (root.data < input)
            return ceil(root.right, input);

        //else either left subtree or root has the ceil value
        int ceil = ceil(root.left, input);
        return (ceil >= input) ? ceil : root.data;
    }


    static int floor(Node root, int input){
        if (root == null)
            return -1;
        if (root.data == input)
            return root.data;
        if (root.data > input)
            return floor(root.left, input);

        //else either right subtree or root has the floor value
        int floor = floor(root.left, input);
        return (floor <= input) ? floor : root.data;
    }


    public Node insert(Node root, int data) {
        if(root == null) {
            return createNewNode(data);
        }

        if(data < root.data) {
            root.left = insert(root.left, data);
        } else if((data > root.data)) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public Node createNewNode(int m) {
        Node a = new Node();
        a.data = m;
        a.left = null;
        a.right = null;
        return a;
    }
}
public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        BinarySearchTree a = new BinarySearchTree();
        Node root = null;
        root = a.insert(root, 8);
        root = a.insert(root, 15);
        root = a.insert(root, 6);
        root = a.insert(root, 2);
        root = a.insert(root, 7);
        root = a.insert(root, 20);
        root = a.insert(root, 5);
        System.out.println(a.ceil(root, 10));
        System.out.println(a.floor(root, 9));
    }
}